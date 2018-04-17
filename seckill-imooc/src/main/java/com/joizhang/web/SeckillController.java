package com.joizhang.web;

import com.joizhang.dto.Exposer;
import com.joizhang.dto.SeckillExecution;
import com.joizhang.dto.SeckillResult;
import com.joizhang.entity.Seckill;
import com.joizhang.enums.SeckillStatEnum;
import com.joizhang.exception.RepeatKillException;
import com.joizhang.exception.SeckillCloseException;
import com.joizhang.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/seckill")
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;


    @RequestMapping(name = "/list", method = RequestMethod.GET)
    public List<Seckill> list() {
        List<Seckill> seckills = seckillService.getSeckillList();
        return seckills;
    }

    @RequestMapping(name = "/{seckillId}/detail", method = RequestMethod.GET)
    public Seckill detail(@PathVariable Long seckillId) {
        Seckill seckill;
        if (seckillId != null && (seckill = seckillService.getById(seckillId)) != null) {
            return seckill;
        }
        return null;
    }

    @RequestMapping(name = "/{seckillId}/exposer", method = RequestMethod.POST)
    public SeckillResult<Exposer> exposer(@PathVariable long seckillId) {
        SeckillResult<Exposer> result;

        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(name = "/{seckillId}/{md5}/execution", method = RequestMethod.POST)
    public SeckillResult<SeckillExecution> execute(@PathVariable long seckillId,
                                                   @PathVariable String md5,
                                                   @CookieValue(value = "killPhone", required = false) Long userPhone) {
        if (userPhone == null) {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }
        SeckillResult<SeckillExecution> result;
        try {
            SeckillExecution execution = seckillService.executeSeckill(seckillId, userPhone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (RepeatKillException e1) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(false, execution);
        } catch (SeckillCloseException e2) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(false, execution);
        } catch (Exception e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(false, execution);
        }
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    public SeckillResult<Long> time() {
        Date now = new Date();
        return new SeckillResult<Long>(true, now.getTime());
    }

}
