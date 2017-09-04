create DATABASE seckill;
use seckill;

--创建秒杀库存表
create TABLE seckill (
seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
name varchar(120) NOT NULL COMMENT '名称',
number int NOT NULL COMMENT '库存数量',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
start_time timestamp NOT NULL COMMENT '秒杀开始时间',
end_time timestamp NOT NULL COMMENT '秒杀结束时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

--秒杀成功明细表
create table success_killed (
seckill_id bigint NOT NULL COMMENT '秒杀商品id',
user_phone bigint NOT NULL COMMENT '用户手机',
state tinyint NOT NULL COMMENT '状态标志：-1无效，0成功，1已付款',
create_time timestamp NOT NULL COMMENT '创建时间',
PRIMARY KEY (seckill_id, user_phone),
key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';



