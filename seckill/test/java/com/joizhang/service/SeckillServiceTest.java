package com.joizhang.service;

import com.joizhang.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class SeckillServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        System.out.println(seckillService.getSeckillList());
        assertEquals(seckillService.getSeckillList().size(), 4);
    }

    @Test
    public void getById() throws Exception {
        System.out.println(seckillService.getById(1000L));
        assertEquals(seckillService.getById(1000L).getSeckillId(), 1000L);
    }

    @Test
    public void exportSeckillUrl() throws Exception {

    }

    /*@Test
    public void MD5() {
        System.out.println(SeckillServiceImpl.getMD5(1001L));
    }
*/
    @Test
    public void executeSeckill() throws Exception {
        //System.out.println(seckillService.executeSeckill(1001L, 15922865715L, "35f874f7fca0ed68e87fc14c6fbc9fe4"));
        assertNotNull(seckillService.executeSeckill(1001L, 15922865715L, "35f874f7fca0ed68e87fc14c6fbc9fe4"));

    }

}