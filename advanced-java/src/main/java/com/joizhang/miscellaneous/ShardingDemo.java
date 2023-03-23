package com.joizhang.miscellaneous;

import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * 详细结果请看单元测试ShardingDemoTest
 */
public class ShardingDemo {

    public static class ShardCfg {
        final int dbIdx;

        final int tblIdx;

        public ShardCfg(int dbIdx, int tblIdx) {
            this.dbIdx = dbIdx;
            this.tblIdx = tblIdx;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ShardCfg.class.getSimpleName() + "[", "]")
                    .add("dbIdx=" + dbIdx)
                    .add("tblIdx=" + tblIdx)
                    .toString();
        }
    }

    /**
     * 常见错误案例一：非互质关系导致的数据偏斜问题
      */
    public static ShardCfg shard1(int db_cnt, int tbl_cnt, String userId) {
        int hash = userId.hashCode();
        // 对库数量取余结果为库序号
        int dbIdx = Math.abs(hash % db_cnt);
        // 对表数量取余结果为表序号
        int tblIdx = Math.abs(hash % tbl_cnt);

        return new ShardCfg(dbIdx, tblIdx);
    }

    /**
     * 常见错误案例二：扩容难以持续
     * <p>
     * 该方案有个比较大的问题，那就是在计算表序号的时候，依赖了总库的数量，那么后续翻倍扩容法进行扩容时，
     * 会出现扩容前后数据不在同一个表中，从而无法实施。
     */
    //
    public static ShardCfg shard2(int db_cnt, int tbl_cnt, String userId) {
        // ① 算Hash
        int hash = userId.hashCode();
        // ② 总分片数
        int sumSlot = db_cnt * tbl_cnt;
        // ③ 分片序号
        int slot = Math.abs(hash % sumSlot);
        // ④ 计算库序号和表序号的错误案例
        int dbIdx = slot % db_cnt;
        int tblIdx = slot / db_cnt;

        return new ShardCfg(dbIdx, tblIdx);
    }

    /**
     * 常用姿势一：标准的二次分片法
     * <p>
     * 1、翻倍扩容法前期操作性高，但是后续如果分库数已经是大几十的时候，每次扩容都非常耗费资源。
     * <p>
     * 2、连续的分片键Hash值大概率会散落在相同的库中，某些业务可能容易存在库热点（例如新生成的用户Hash
     * 相邻且递增，且新增用户又是高概率的活跃用户，那么一段时间内生成的新用户都会集中在相邻的几个库中）。
     */
    public static ShardCfg shard3(int db_cnt, int tbl_cnt, String userId) {
        // ① 算Hash
        int hash = userId.hashCode();
        // ② 总分片数
        int sumSlot = db_cnt * tbl_cnt;
        // ③ 分片序号
        int slot = Math.abs(hash % sumSlot);
        // ④ 重新修改二次求值方案
        int dbIdx = slot / tbl_cnt ;
        int tblIdx = slot % tbl_cnt ;

        return new ShardCfg(dbIdx, tblIdx);
    }

    /**
     * 常用姿势二：关系表冗余
     */
    public static ShardCfg shard4(int db_cnt, int tbl_cnt, String userId) {
//        int tblIdx = Math.abs(userId.hashCode() % TBL_CNT);
//        // 从缓存获取
//        Integer dbIdx = loadFromCache(userId);
//        if (null == dbIdx) {
//            // 从路由表获取
//            dbIdx = loadFromRouteTable(userId);
//            if (null != dbIdx) {
//                // 保存到缓存
//                saveRouteCache(userId, dbIdx);
//            }
//        }
//        if (null == dbIdx) {
//            // 此处可以自由实现计算库的逻辑
//            dbIdx = selectRandomDbIdx();
//            saveToRouteTable(userId, dbIdx);
//            saveRouteCache(userId, dbIdx);
//        }
//
//        return new ShardCfg(dbIdx, tblIdx);
        return null;
    }

    /**
     * 常用姿势三：基因法
     * <p>
     * 该方案并不是一定不行，而是我们在采用的时候，要综合分片键的样本规则，
     * 选取的分片键前缀位数，库数量，表数量，四个变量对最终的偏斜率都有影响。
     */
    public static ShardCfg shard5(int db_cnt, int tbl_cnt, String userId) {
        int dbIdx = Math.abs(userId.substring(0, Math.min(userId.length(), 4)).hashCode() % db_cnt );
        int tblIdx = Math.abs(userId.hashCode() % tbl_cnt);
        return new ShardCfg(dbIdx, tblIdx);
    }

    /**
     * 常用姿势四：剔除公因数法
     * <p>
     * 针对不少业务从N库1表升级到N库M表下，需要维护库序号不变的场景下可以考虑。
     */
    public static ShardCfg shard6(int db_cnt, int tbl_cnt, String userId) {
        int dbIdx = Math.abs(userId.hashCode() % db_cnt);
        // 计算表序号时先剔除掉公约数的影响
        int tblIdx = Math.abs((userId.hashCode() / tbl_cnt) % tbl_cnt);
        return new ShardCfg(dbIdx, tblIdx);
    }

    private final TreeMap<Long, Integer> nodeTreeMap = new TreeMap<>();

    // 常用姿势五：一致性Hash法
    public ShardCfg shard7(String userId) {
        int hash = userId.hashCode();
        int dbIdx = nodeTreeMap.tailMap((long) hash, false).firstEntry().getValue();
        int tblIdx = Math.abs(hash % 100);
        return new ShardCfg(dbIdx, tblIdx);
    }
}
