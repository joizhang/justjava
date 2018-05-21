package com.joizhang.imooc.service;

import com.joizhang.imooc.model.po.User;
import org.springframework.stereotype.Service;

import static com.joizhang.imooc.util.SHAUtils.*;

@Service
public class UserService extends BaseService<User> {

    public static User makeSHA256PasswordWithSalt(User user) {
        String inStr = user.getUserName() + user.getPassWord();
        user.setPassWord(getSHA256(getSHA256(inStr)));
        return user;
    }

}
