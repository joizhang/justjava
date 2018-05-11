package com.joizhang.dao;

import com.joizhang.Application;
import com.joizhang.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class SecKillDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SecKillDao secKillDao;

    @Test
    public void reduceNumber() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date killTime = df.parse("2015-12-27 00:00:01");
        System.out.println(secKillDao.reduceNumber(1001L, killTime));
    }

    @Test
    public void queryById() throws Exception {
        System.out.println(secKillDao.queryById(1000L));
        assertEquals(secKillDao.queryById(1000L).getName(), "5000元秒杀iphone 7");
        assertEquals(secKillDao.queryById(1000L).getNumber(), 100);
    }

    @Test
    public void queryAll() throws Exception {

    }

    @Test
    public void insertSeckills() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date startTime = df.parse("2016-11-11 00:00:00");
        Date endTime = df.parse("2016-11-11 01:00:01");
        System.out.println(startTime);
        List<Seckill> seckills = new ArrayList<Seckill>();
        seckills.add(new Seckill("6000元秒杀Mac BOOK PRO", 30, startTime, endTime));
        seckills.add(new Seckill("7000元秒杀Mac BOOK PRO", 40, startTime, endTime));
        seckills.add(new Seckill("8000元秒杀Mac BOOK PRO", 50, startTime, endTime));

        secKillDao.insertSeckills(seckills);
    }

}