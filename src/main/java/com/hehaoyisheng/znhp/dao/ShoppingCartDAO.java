package com.hehaoyisheng.znhp.dao;

import com.hehaoyisheng.znhp.dao.DO.ShoppingCartDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by yunzhao on 2017/8/5.
 */
public interface ShoppingCartDAO {

    /**
     * 添加购物车商品
     * @param shoppingCartDO
     * @return
     */
    @Insert("insert into shopCart (userId, username, commodityId, commodityName, commodityView) " +
            "values (#{shoppingCartDO.userId}, #{shoppingCartDO.username}, #{shoppingCartDO.commodityId}, #{shoppingCartDO.commodityName}, " +
            "#{shoppingCartDO.commodityView})")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insertShoppingCartDO(ShoppingCartDO shoppingCartDO);

    /**
     * 根据用户查询购物车
     * @param userId
     * @return
     */
    @Select("select * from shopCart where userId=#{userId}")
    List<ShoppingCartDO> selectShoppingDOByUserId(Long userId);

    /**
     * 删除购物车商品
     * @param id
     * @return
     */
    @Delete("delete from shopCart where id=#{id}")
    void deleteShoppingCartDOById(Long id);
}
