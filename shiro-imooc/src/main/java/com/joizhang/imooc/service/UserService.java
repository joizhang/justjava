package com.joizhang.imooc.service;

import com.joizhang.imooc.model.po.User;

import static com.joizhang.imooc.util.SHAUtils.*;

public class UserService extends BaseService<User> {

    public static User makeSHA256PasswordWithSalt(User user) {
        user.setPassWord(getSHA256(getSHA256(user.getUserName() + user.getPassWord())));
        return user;
    }

}
