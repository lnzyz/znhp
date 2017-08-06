package com.hehaoyisheng.znhp.dao;

import com.hehaoyisheng.znhp.constant.SQLProvider;
import com.hehaoyisheng.znhp.dao.DO.UserDO;
import org.apache.ibatis.annotations.*;

import javax.annotation.Nonnull;

/**
 * Created by yunzhao on 2017/7/29.
 */
public interface UserDAO {
    /**
     * 根据用户名查用户信息
     * @return
     */
    @Select("select * from user username=#{username}")
    UserDO queryUserByUsername(@Nonnull String username);

    /**
     * 根据手机号查用户信息
     * @param phoneNumber
     * @return
     */
    @Select("select * from user where phoneNumber=#{phoneNumber}")
    UserDO queryUserByPhoneNumber(@Nonnull String phoneNumber);

    /**
     * 根据id查用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    UserDO queryUserById(@Nonnull int id);

    /**
     * 添加新的用户
     * @param userDO 用户的DO
     * @return
     */
    @Insert("insert into user (username, password, phoneNumber, userNickName, userHeadPortrait, sex) values (#{userDO.username}, " +
            "#{userDO.password}, #{userDO.phoneNumber}, #{userDO.userNickName}, #{userDO.userHeadPortrait}, #{userDO.sex})")
    int addUser(@Nonnull UserDO userDO);

    /**
     * 修改用户
     * @param userDO
     * @return
     */
    @UpdateProvider(type = SQLProvider.class, method = "updateUser")
    boolean updateUser(UserDO userDO);

    /**
     * 仅需要传userId
     * @param userId
     * @return
     */
    @Delete("delete from user where id=#{userId}")
    boolean deleteUser(@Nonnull Long userId);
}
