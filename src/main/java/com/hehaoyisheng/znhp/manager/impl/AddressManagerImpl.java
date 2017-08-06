package com.hehaoyisheng.znhp.manager.impl;

import com.hehaoyisheng.znhp.dao.AddressDAO;
import com.hehaoyisheng.znhp.dao.DO.AddressDO;
import com.hehaoyisheng.znhp.dao.DO.UserDO;
import com.hehaoyisheng.znhp.manager.AddressManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-08-06.
 */
@Component
public class AddressManagerImpl implements AddressManager {

    @Resource
    private AddressDAO addressDAO;

    public Long insertAddress(UserDO userDO, AddressDO addressDO) {
        Long result = -1L;
        try {
            addressDO.setUserId(userDO.getId());
            addressDO.setUsername(userDO.getUsername());
            result = addressDAO.insertAddressDO(addressDO);
        }catch (Exception e){

        }
        return result;
    }

    public List<AddressDO> selectAddress(Long userId) {
        return addressDAO.selectAddressDOByUserId(userId);
    }

    public boolean updateAddress(UserDO userDO, AddressDO addressDO) {
        addressDO.setUserId(userDO.getId());
        addressDO.setUsername(userDO.getUsername());
        addressDAO.updateAddressDOById(addressDO);
        return true;
    }

    public boolean deleteAddress(Long id) {
        addressDAO.deleteAddressDOById(id);
        return true;
    }
}
