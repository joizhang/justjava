drop table if exists user;
create table user (
  username varchar(32) NOT NULL COMMENT '用户名',
  password varchar(64) NOT NULL COMMENT '密码',
  role varchar(32) NOT NULL COMMENT '角色',
  authoritytype varchar(32) default null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (userName, passWord, role, authorityType) VALUES ('admin', '9cf3e758a497c6274bd066d0b2168432f8a34aad95f63a65677a9a56acec94a7', 'ADMIN', null);