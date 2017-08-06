package com.hehaoyisheng.znhp.manager.impl;

import com.hehaoyisheng.znhp.dao.DO.CommodityDO;
import com.hehaoyisheng.znhp.dao.DO.ShoppingCartDO;
import com.hehaoyisheng.znhp.dao.DO.UserDO;
import com.hehaoyisheng.znhp.dao.ShoppingCartDAO;
import com.hehaoyisheng.znhp.manager.CommodityManager;
import com.hehaoyisheng.znhp.manager.ShoppingCartManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yunzhao on 2017/8/5.
 */
@Component
public class ShoppingCartManagerImpl implements ShoppingCartManager {

    @Resource
    private ShoppingCartDAO shoppingCartDAO;

    @Resource
    private CommodityManager commodityManager;

    public int insertShoppingCartDO(Long commodityId, UserDO user) {
        int lastInsertCount = -1;
        try {
            CommodityDO commodityDO = commodityManager.selectCommodityDOById(commodityId);
            ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
            shoppingCartDO.setCommodityId(commodityId);
            shoppingCartDO.setCommodityName(commodityDO.getName());
            shoppingCartDO.setCommodityView(commodityDO.getOverView());
            shoppingCartDO.setUsername(user.getUsername());
            lastInsertCount = shoppingCartDAO.insertShoppingCartDO(shoppingCartDO);
        }catch (Exception e){

        }
        return lastInsertCount;
    }

    public List<ShoppingCartDO> selectShoppingDOByUserId(Long userId) {
        List<ShoppingCartDO> resultList = null;
        try {
            resultList = shoppingCartDAO.selectShoppingDOByUserId(userId);
        }catch (Exception e){

        }
        return resultList;
    }

    public boolean deleteShoppingCartDOById(Long id) {
        try {
            shoppingCartDAO.deleteShoppingCartDOById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    public boolean deleteShoppingCartDOById(List<Long> idList) {
        try {
            for(Long id : idList){
                shoppingCartDAO.deleteShoppingCartDOById(id);
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        return true;
    }
}
