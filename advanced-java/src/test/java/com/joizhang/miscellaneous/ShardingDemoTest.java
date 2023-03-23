package com.joizhang.miscellaneous;

import org.junit.Test;

import java.util.Arrays;

public class ShardingDemoTest {

    @Test
    public void testShard1() {
        final int DB_CNT = 5;
        final int TBL_CNT = 10;
        int[][] dbs = new int[DB_CNT][TBL_CNT];
        final int dataToInsert = (int) Math.pow(10, 7);
        for (int i = 1; i < dataToInsert; i++) {
            ShardingDemo.ShardCfg shard = ShardingDemo.shard1(DB_CNT, TBL_CNT, String.valueOf(i));
            dbs[shard.dbIdx][shard.tblIdx]++;
        }
        for (int[] db : dbs) {
            System.out.println(Arrays.toString(db));
        }
    }

    @Test
    public void testShard2() {
        System.out.println("数据库扩容前");
        final int DB_CNT = 5;
        final int TBL_CNT = 10;
        int[][] dbs = new int[DB_CNT][TBL_CNT];
        final int dataToInsert = (int) Math.pow(10, 7);
        for (int i = 1; i < dataToInsert; i++) {
            ShardingDemo.ShardCfg shard = ShardingDemo.shard2(DB_CNT, TBL_CNT, String.valueOf(i));
            dbs[shard.dbIdx][shard.tblIdx]++;
        }
        for (int[] db : dbs) {
            System.out.println(Arrays.toString(db));
        }
        System.out.println("ID从10000-10010的索引为：");
        for (int i = 10000; i < 10010; i++) {
            System.out.println(ShardingDemo.shard2(DB_CNT, TBL_CNT, String.valueOf(i)));
        }

        System.out.println("数据库扩容后");
        int[][] newdbs = new int[DB_CNT * 2][TBL_CNT];
        System.arraycopy(dbs, 0, newdbs, 0, dbs.length);
        for(int i = dataToInsert; i < dataToInsert * 2; i++) {
            ShardingDemo.ShardCfg shard = ShardingDemo.shard2(DB_CNT * 2, TBL_CNT, String.valueOf(i));
            newdbs[shard.dbIdx][shard.tblIdx]++;
        }
        for (int[] db : newdbs) {
            System.out.println(Arrays.toString(db));
        }
        System.out.println("ID从10000-10010的索引为：");
        for (int i = 10000; i < 10010; i++) {
            System.out.println(ShardingDemo.shard2(DB_CNT * 2, TBL_CNT, String.valueOf(i)));
        }
    }

    @Test
    public void testShard3() {
        System.out.println("数据库扩容前");
        final int DB_CNT = 5;
        final int TBL_CNT = 10;
        int[][] dbs = new int[DB_CNT][TBL_CNT];
        final int dataToInsert = (int) Math.pow(10, 7);
        for (int i = 1; i < dataToInsert; i++) {
            ShardingDemo.ShardCfg shard = ShardingDemo.shard3(DB_CNT, TBL_CNT, String.valueOf(i));
            dbs[shard.dbIdx][shard.tblIdx]++;
        }
        for (int[] db : dbs) {
            System.out.println(Arrays.toString(db));
        }
        System.out.println("ID从10000-10010的索引为：");
        for (int i = 10000; i < 10010; i++) {
            System.out.println(ShardingDemo.shard3(DB_CNT, TBL_CNT, String.valueOf(i)));
        }

        System.out.println("数据库扩容后");
        int[][] newdbs = new int[DB_CNT * 2][TBL_CNT];
        System.arraycopy(dbs, 0, newdbs, 0, dbs.length);
        for(int i = dataToInsert; i < dataToInsert * 2; i++) {
            ShardingDemo.ShardCfg shard = ShardingDemo.shard3(DB_CNT * 2, TBL_CNT, String.valueOf(i));
            newdbs[shard.dbIdx][shard.tblIdx]++;
        }
        for (int[] db : newdbs) {
            System.out.println(Arrays.toString(db));
        }
        System.out.println("ID从10000-10010的索引为：");
        for (int i = 10000; i < 10010; i++) {
            System.out.println(ShardingDemo.shard3(DB_CNT * 2, TBL_CNT, String.valueOf(i)));
        }
    }

    @Test
    public void testShard5() {
        final int DB_CNT = 5;
        final int TBL_CNT = 9;
        int[][] dbs = new int[DB_CNT][TBL_CNT];
        final int dataToInsert = (int) Math.pow(10, 7);
        for (int i = 1; i < dataToInsert; i++) {
            ShardingDemo.ShardCfg shard = ShardingDemo.shard5(DB_CNT, TBL_CNT, String.valueOf(i));
            dbs[shard.dbIdx][shard.tblIdx]++;
        }
        for (int[] db : dbs) {
            System.out.println(Arrays.toString(db));
        }
    }
}