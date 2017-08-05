package com.hehaoyisheng.znhp.dao;

import com.hehaoyisheng.znhp.dao.DO.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import javax.annotation.Nonnull;

/**
 * Created by yunzhao on 2017/7/29.
 */
public interface UserDAO {
    /**
     * 根据用户名查用户信息
     * @return
     */
    UserDO queryUserByUsername(@Nonnull String username);

    /**
     * 根据手机号查用户信息
     * @param phoneNumber
     * @return
     */
    UserDO queryUserByPhoneNumber(@Nonnull String phoneNumber);

    /**
     * 根据id查用户信息
     * @param id
     * @return
     */
    UserDO queryUserById(@Nonnull int id);

    /**
     * 添加新的用户
     * @param userDO 用户的DO
     * @return
     */
    int addUser(@Nonnull UserDO userDO);

    /**
     * 修改用户
     * @param userDO
     * @return
     */
    boolean updateUser(@Nonnull UserDO userDO);

    /**
     * 仅需要传userId
     * @param userDO
     * @return
     */
    boolean deleteUser(@Nonnull UserDO userDO);
}
