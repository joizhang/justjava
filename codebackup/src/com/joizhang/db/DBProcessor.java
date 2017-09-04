package com.joizhang.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBProcessor {

    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    /**
     * 读取数据库驱动，初始化连接池。
     */
    public DBProcessor(){
        try {
            Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    /**
     * 获得一个连接
     * @throws SQLException
     */
    public void getConnection() throws SQLException {
        if(conn == null || conn.isClosed())
            conn = DriverManager.getConnection("proxool.mysql");
    }
    //---execute--------------------------------------------------------------------------------
    /**
     * 执行查询语句
     * @return 返回 ResultSet 结果集
     */
    public List<Map<String, Object>> excuteQuery(String sql) {
        if(sql == null || "".equals(sql)) return null;
        try {
            this.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return this.getListByResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeRs();
            this.closeStmt();
            this.closeConn();
        }
        return null;
    }
    /**
     * 执行带参数的查询语句
     * @return 返回 ResultSet 结果集
     */
    public List<Map<String, Object>> excuteQuery(String sql, Object[] params) {
        if(sql == null || "".equals(sql)) return null;
        if(params == null || params.length <= 0) return null;
        try {
            this.getConnection();
            pstmt = conn.prepareStatement(sql);
            this.setParameterByPreparedStatement(params);
            rs = pstmt.executeQuery(sql);
            return this.getListByResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeRs();
            this.closeStmt();
            this.closeConn();
        }
        return null;
    }
    /**
     * 执行数据库更新
     * @param sql
     * @return 返回影响的行数
     */
    public int excuteUpdate(String sql) {
        if(sql == null || "".equals(sql)) return 0;
        int result = 0;
        try {
            this.getConnection();
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStmt();
            this.closeConn();
        }
        return result;
    }
    /**
     * 执行带参数的查询语句
     * @return 返回影响的行数
     */
    public int excuteUpdate(String sql,Object[] params){
        if(sql == null || "".equals(sql)) return 0;
        if(params == null || params.length <= 0) return 0;
        int result = 0;
        try {
            this.getConnection();
            pstmt = conn.prepareStatement(sql);
            this.setParameterByPreparedStatement(params);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            closePStmt();
            this.closeConn();
        }
        return result;
    }
    /**
     * 执行批量更新
     * @param sqls SQL语句数组
     * @return true
     */
    public boolean executeBatchUpdate(String[] sqls){
        if(sqls == null || sqls.length <= 0) return false;
        boolean result = false;
        try {
            this.getConnection();
            conn.setAutoCommit(false);
            try{
                stmt=conn.createStatement();
                for(int i=0; i<sqls.length; i++){
                    stmt.executeUpdate(sqls[i]);
                }
                conn.commit();
                result = true;
            }catch(Exception ex){
                result = false;
                this.conn.rollback();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.closeStmt();
            this.closeConn();
        }
        return result;
    }
    //---get-----------------------------------------------------------------------------------
    /**
     * 获得总数
     * @param field 字段
     * @param table 表名
     * @param where 条件 赋值空为无条件
     * @return 返回SQL语句，语句结果：返回总行数列名为：count
     */
    public int getCount(String field, String table, String where){
        if(field == null || "".equals(field)) return 0;
        if(table == null || "".equals(table)) return 0;
        StringBuilder sql = new StringBuilder();
        sql.append("select count(").append(field).append(") as count ");
        sql.append("from ").append(table).append(" ");
        if(where != null) sql.append("where ").append(where);
        try {
            this.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql.toString());
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeRs();
            this.closeStmt();
            this.closeConn();
        }
        return 0;
    }
    //---close--------------------------------------------------------------------------------
    /**
     * 关闭记录集
     */
    public void closeRs(){
        try {
            if(this.rs != null){
                this.rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 关闭语句对象
     */
    public void closeStmt() {
        try{
            if(this.stmt!= null){
                this.stmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * 关闭预备语句对象
     */
    public void closePStmt() {
        try{
            if(this.pstmt!= null){
                this.pstmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * 关闭数据库连接
     */
    public void closeConn() {
        try{
            if(this.conn != null){
                this.conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //---private--------------------------------------------------------------------------
    /**
     * 获得 List by ResultSet
     * @paramrs结果集
     * @return List<Map<String, Object>>
     * @throws SQLException
     */
    private List<Map<String, Object>> getListByResultSet() throws SQLException{
        if(rs == null) return null;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        String column;
        Object value;
        ResultSetMetaData md = rs.getMetaData();
        while(rs.next()){
            map = new HashMap<String, Object>();
            //遍历此行的所有列
            for (int i = 0; i < md.getColumnCount(); i++){
                column = md.getColumnName(i + 1);//列名
//                System.out.println( column + ": " + md.getColumnClassName(i+1));
                if("java.lang.Boolean".equals(md.getColumnClassName(i+1)))
                    value = rs.getInt(column);//获得值
                else
                    value = rs.getObject(column);//获得值
                map.put(column, value == null ? "" : value);
            }
            list.add(map);
        }
        return list;
    }
    /**
     * 设置 PreparedStatement 参数
     * @param params
     * @throws SQLException
     */
    private void setParameterByPreparedStatement(Object[] params) throws SQLException{
        if(params == null || params.length <= 0) return;
        for(int i=0; i<params.length; i++){
            if(params[i] instanceof String ){
                pstmt.setString(i+1, String.valueOf(params[i]));
            }if(params[i] instanceof Integer){
                pstmt.setInt(i+1, Integer.parseInt(String.valueOf(params[i])));
            }else if(params[i] instanceof Short){
                pstmt.setShort(i+1, Short.parseShort(String.valueOf(params[i])));
            }else if(params[i] instanceof Long){
                pstmt.setLong(i+1, Long.parseLong(String.valueOf(params[i])));
            }else if(params[i] instanceof Double){
                pstmt.setDouble(i+1, Double.parseDouble(String.valueOf(params[i])));
            }else if(params[i] instanceof Float){
                pstmt.setFloat(i+1, Float.parseFloat(String.valueOf(params[i])));
            }else if(params[i] instanceof Byte){
                pstmt.setByte(i+1, Byte.parseByte(String.valueOf(params[i])));
            }else if(params[i] instanceof Byte[]){
                pstmt.setBytes(i+1, (byte[])params[i]);
            }else{
                pstmt.setObject(i+1, params[i]);
            }
        }
    }
}