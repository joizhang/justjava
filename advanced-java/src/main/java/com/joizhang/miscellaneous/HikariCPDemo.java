package com.joizhang.miscellaneous;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HikariCPDemo {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://xinlin-04:3306/test");
        config.setUsername("test");
        config.setPassword("CCCC_123");
        config.setMinimumIdle(4);
        config.setMaximumPoolSize(8);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        try (HikariDataSource dataSource = new HikariDataSource(config);
             Connection connection = dataSource.getConnection();){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select 1 from dual");
            System.out.println(resultSet.getInt(1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
