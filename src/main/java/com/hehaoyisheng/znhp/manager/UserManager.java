package com.hehaoyisheng.znhp.manager;

import com.hehaoyisheng.znhp.dao.DO.UserDO;

/**
 * Created by yunzhao on 2017/7/29.
 */
public interface UserManager {
    UserDO login(String username, String password);
    int registSendMsg(String phoneNumber);
    Boolean isUserExist(String username);
    UserDO regist(UserDO userDO);
}
