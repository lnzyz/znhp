package com.hehaoyisheng.znhp.dao.Impl;

import com.hehaoyisheng.znhp.dao.DO.UserDO;
import com.hehaoyisheng.znhp.dao.UserDAO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;

/**
 * Created by yunzhao on 2017/8/3.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    public UserDO queryUserByUsername(@Nonnull String username) {
        return null;
    }

    public UserDO queryUserByPhoneNumber(@Nonnull String phoneNumber) {
        return null;
    }

    public UserDO queryUserById(@Nonnull int id) {
        return null;
    }

    public int addUser(@Nonnull UserDO userDO) {
        return 0;
    }

    public boolean updateUser(@Nonnull UserDO userDO) {
        return false;
    }

    public boolean deleteUser(@Nonnull UserDO userDO) {
        return false;
    }
}
