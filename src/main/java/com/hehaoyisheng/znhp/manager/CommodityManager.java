package com.hehaoyisheng.znhp.manager;

import com.hehaoyisheng.znhp.dao.DO.CommodityDO;
import com.hehaoyisheng.znhp.dao.DO.KindDO;
import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.List;

/**
 * Created by yunzhao on 2017/8/2.
 */
public interface CommodityManager {
    /**
     * 获取分类
     * @return
     */
    List<List<KindDO>> getKind();

    /**
     * 添加商品
     * @param commodityDO
     * @return
     */
    int insertCommodity(CommodityDO commodityDO);

    /**
     * 根据分类获取商品
     * @param kindId
     * @param from
     * @param count
     * @return
     */
    List<CommodityDO> selectCommodityDOByKind(Long kindId, Integer from, Integer count);

    /**
     * 搜索商品
     * @param search 搜索文本
     * @param from
     * @param count
     * @return
     */
    List<CommodityDO> selectCommodityDOBySearch(String search, Integer from, Integer count);

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    CommodityDO selectCommodityDOById(Long id);

    /**
     * 根据活动类型获取商品列表
     * @param from
     * @param count
     * @return
     */
    List<CommodityDO> selectCommodityDOByType(String type, Integer from, Integer count);
}
