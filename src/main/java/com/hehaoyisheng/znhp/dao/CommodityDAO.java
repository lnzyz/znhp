package com.hehaoyisheng.znhp.dao;

import com.hehaoyisheng.znhp.dao.DO.CommodityDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by yunzhao on 2017/8/3.
 */
public interface CommodityDAO {

    @Insert("insert into commodity (name, price, activityPrice, kindId, kindName, pic, overView, info, count)" +
            " values(#{commodity.name}, #{commodity.price}," +
            " #{commodity.activityPrice}, #{commodity.kindId}, #{commodity.kindName}, #{commodity.pic}," +
            " #{commodity.overView}, #{commodity.info}, #{commodity.count})")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int add(@Param("commodity") CommodityDO commodityDO);

    @Select("select * from commodity where kindId=#{kindId}")
    List<CommodityDO> selectCommodityDOByKind(Long kingId);

    @Select("select * from commodity where name like #{search}")
    List<CommodityDO> selectCommodityDOBySearch(String search);

    @Select("select * from commodity where id=#{id}")
    CommodityDO selectCommodityDOById(Long id);

    @Select("select * from commodity where activityType=#{type}")
    List<CommodityDO> selectCommodityDOByActivityType(String type);
}
