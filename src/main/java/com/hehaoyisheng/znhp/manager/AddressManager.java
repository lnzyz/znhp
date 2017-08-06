package com.hehaoyisheng.znhp.manager;

import com.hehaoyisheng.znhp.dao.DO.AddressDO;
import com.hehaoyisheng.znhp.dao.DO.UserDO;

import java.util.List;

/**
 * Created by Administrator on 2017-08-06.
 */
public interface AddressManager {

    Long insertAddress(UserDO userDO, AddressDO addressDO);

    List<AddressDO> selectAddress(Long userId);

    boolean updateAddress(UserDO userDO, AddressDO addressDO);

    boolean deleteAddress(Long id);
}
