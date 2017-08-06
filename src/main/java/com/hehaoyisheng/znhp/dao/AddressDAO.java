package com.hehaoyisheng.znhp.dao;

import com.hehaoyisheng.znhp.constant.SQLProvider;
import com.hehaoyisheng.znhp.dao.DO.AddressDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * Created by Administrator on 2017-08-06.
 */
public interface AddressDAO {

    @Insert("insert into address (userId, username, province, city, distory, info, postCode, postCode, phoneNumber) " +
            "values (#{addressDO.userId}, #{addressDO.username}, #{addressDO.province}, #{addressDO.city}, " +
            "#{addressDO.distory}, #{addressDO.info}, #{addressDO.postCode}, #{addressDO.postCode}, #{addressDO.phoneNumber})")
    long insertAddressDO(AddressDO addressDO);

    @Select("select * from address where userId=#{userId}")
    List<AddressDO> selectAddressDOByUserId(Long userId);

    @Delete("delete from address where id=#{id}")
    void deleteAddressDOById(Long id);

    @UpdateProvider(type = SQLProvider.class, method = "updateAddress")
    void updateAddressDOById(AddressDO addressDO);
}
