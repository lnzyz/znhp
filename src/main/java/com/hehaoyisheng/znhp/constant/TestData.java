package com.hehaoyisheng.znhp.constant;

import com.google.common.collect.Lists;
import com.hehaoyisheng.znhp.dao.DO.UserDO;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 伪造数据
 * Created by yunzhao on 2017/7/30.
 */
public class TestData {
    private static List<UserDO> userDOList = Lists.newArrayList();

    public static UserDO queryByPhoneNumebr(@Nonnull String phoneNumber){
        for(UserDO userDO : userDOList){
            if(StringUtils.equals(userDO.getPassword(), phoneNumber)){
                return userDO;
            }
        }
        return null;
    }

    public static UserDO queryByUsername(@Nonnull String username){
        for(UserDO userDO : userDOList){
            if(StringUtils.equals(userDO.getUsername(), username)){
                return userDO;
            }
        }
        return null;
    }

    public static synchronized UserDO regist(UserDO userDO){
        userDOList.add(userDO);
        userDO.setId(userDOList.size());
        return userDO;
    }
}
