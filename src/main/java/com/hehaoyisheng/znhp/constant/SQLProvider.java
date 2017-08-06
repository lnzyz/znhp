package com.hehaoyisheng.znhp.constant;

import com.hehaoyisheng.znhp.dao.DO.AddressDO;
import com.hehaoyisheng.znhp.dao.DO.UserDO;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017-08-05.
 */
public class SQLProvider {
    /**
     * 修改User表的SQL语句
     * @param userDO
     * @return
     */
    public String updateUser(final UserDO userDO){
        return new SQL(){{
            UPDATE("user");
            if(userDO.getPhoneNumber() != null){
                SET("phoneNumber=#{userDO.phoneNumber}");
            }
            if(userDO.getPassword() != null){
                SET("password=#{userDO.password}");
            }
            if(userDO.getUsername() != null){
                SET("username=#{userDO.username}");
            }
            if(userDO.getSex() != 0){
                SET("sex=#{userDO.sex}");
            }
            if(userDO.getUserNickName() != null){
                SET("userNickName=#{userDO.userNickName}");
            }
            if(userDO.getUserHeadPortrait() != null){
                SET("userHeadPortrait=#{userDO.userHeadPortrait}");
            }
            WHERE("id=#{userDO.id}");
        }}.toString();
    }

    public String updateAddress(final AddressDO addressDO){
        return  new SQL(){{
            UPDATE("address");
            if(addressDO.getProvince() != null){
                SET("province=#{addressDO.province}");
            }
            if(addressDO.getCity() != null){
                SET("city=#{addressDO.city}");
            }
            if(addressDO.getDistory() != null){
                SET("distory=#{addressDO.distory}");
            }
            if(addressDO.getInfo() != null){
                SET("info=#{addressDO.info}");
            }
            if(addressDO.getName() != null){
                SET("name=#{addressDO.name}");
            }
            if(addressDO.getPhoneNumber() != null){
                SET("phoneNumber=#{addressDO.phoneNumber}");
            }
            WHERE("id=addressDO.id");
        }}.toString();
    }
}
