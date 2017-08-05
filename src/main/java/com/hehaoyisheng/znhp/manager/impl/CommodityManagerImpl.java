package com.hehaoyisheng.znhp.manager.impl;

import com.hehaoyisheng.znhp.dao.CommodityDAO;
import com.hehaoyisheng.znhp.dao.DO.CommodityDO;
import com.hehaoyisheng.znhp.dao.DO.KindDO;
import com.hehaoyisheng.znhp.manager.CommodityManager;
import com.hehaoyisheng.znhp.utils.CutPageUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by yunzhao on 2017/8/3.
 */
@Component
public class CommodityManagerImpl implements CommodityManager{

    @Resource
    CommodityDAO commodityDAO;

    public List <List<KindDO>> getKind() {

        return null;
    }

    public int insertCommodity(CommodityDO commodityDO) {
        CommodityDO commodityDO1 = new CommodityDO();
        commodityDO1.setName("test");
        commodityDO1.setCount(1);
        commodityDO1.setPrice(12);
        commodityDO1.setKindId(1L);
        commodityDO1.setKindName("test");
        commodityDO1.setOverView("123");
        commodityDO1.setCreateTime(new Date());
        int a = commodityDAO.add(commodityDO1);
        System.out.print(a);
        return a;
    }

    public List<CommodityDO> selectCommodityDOByKind(Long kindId, Integer from, Integer count) {
        List<CommodityDO> commodityDOList = null;
        try {
            commodityDOList = commodityDAO.selectCommodityDOByKind(kindId);
        }catch (Exception e){
            //打日志
        }
        return commodityDOList;
    }

    public List<CommodityDO> selectCommodityDOBySearch(String search, Integer from, Integer count){
        search = "%" + search + "%";
        List<CommodityDO> commodityDOList = commodityDAO.selectCommodityDOBySearch(search);
        return CutPageUtils.divide(commodityDOList, from, count);
    }

    public CommodityDO selectCommodityDOById(Long id) {
        return commodityDAO.selectCommodityDOById(id);
    }

    public List <CommodityDO> selectCommodityDOByType(String type, Integer from, Integer count) {
        from = CutPageUtils.getInteger(from);
        count = CutPageUtils.getInteger(count);
        List<CommodityDO> commodityDOList = commodityDAO.selectCommodityDOByActivityType(type);
        return CutPageUtils.divide(commodityDOList, from, count);
    }
}
