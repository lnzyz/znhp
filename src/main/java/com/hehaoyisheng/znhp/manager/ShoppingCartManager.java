package com.hehaoyisheng.znhp.manager;

import com.hehaoyisheng.znhp.dao.DO.ShoppingCartDO;
import com.hehaoyisheng.znhp.dao.DO.UserDO;

import java.util.List;

/**
 * Created by yunzhao on 2017/8/5.
 */
public interface ShoppingCartManager {

    /**
     * 添加购物车商品
     * @param commodity
     * @return
     */
    Long insertShoppingCartDO(Long commodity, UserDO user);

    /**
     * 根据用户查询购物车
     * @param userId
     * @return
     */
    List<ShoppingCartDO> selectShoppingDOByUserId(Long userId);

    /**
     * 删除购物车商品
     * @param id
     * @return
     */
    boolean deleteShoppingCartDOById(Long id);

    /**
     * 删除购物车
     * @param idList
     * @return
     */
    boolean deleteShoppingCartDOById(List<Long> idList);
}
