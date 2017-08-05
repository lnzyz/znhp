package com.hehaoyisheng.znhp.controller;

import com.google.common.collect.Lists;
import com.hehaoyisheng.znhp.constant.ZnhpStatusCodes;
import com.hehaoyisheng.znhp.controller.DTO.BaseDTO;
import com.hehaoyisheng.znhp.dao.DO.CommodityDO;
import com.hehaoyisheng.znhp.dao.DO.CommodityView;
import com.hehaoyisheng.znhp.manager.CommodityManager;
import com.hehaoyisheng.znhp.utils.CutPageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品相关controller
 * Created by yunzhao on 2017/8/2.
 */
@Controller
public class CommodityController {

    @Resource
    CommodityManager commodityManager;

    /**
     * 获取所有分类
     * @return
     */
    @RequestMapping("/kind")
    @ResponseBody
    public BaseDTO getKind(){
        commodityManager.insertCommodity(new CommodityDO());
        return BaseDTO.createSuccessBaseDTO(null);
    }

    /**
     * 获取分类下所有产品
     * @param kindId
     * @return
     */
    @RequestMapping("/getCommodityListByKind")
    @ResponseBody
    public BaseDTO getCommodityListByKind(Long kindId, Integer from, Integer count){
        from = CutPageUtils.getInteger(from);
        count = CutPageUtils.getCount(count);
        List<CommodityDO> list = commodityManager.selectCommodityDOByKind(kindId, from, count);
        if(list == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.SYSTEM_ERROR);
        }
        List<CommodityView> data = DOToView(CutPageUtils.divide(list, from, count));
        return BaseDTO.createSuccessBaseDTO(data, list.size());
    }

    /**
     * 搜索商品
     * @param searchText 搜索文本
     * @return
     */
    @RequestMapping("/getCommodityListBySearch")
    @ResponseBody
    public BaseDTO getCommodityListBySearch(String searchText, Integer from, Integer count){
        from = CutPageUtils.getInteger(from);
        count = CutPageUtils.getCount(count);
        List<CommodityDO> list = commodityManager.selectCommodityDOBySearch(searchText, from, count);
        if(list == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.SYSTEM_ERROR);
        }
        List<CommodityView> data = DOToView(CutPageUtils.divide(list, from, count));
        return BaseDTO.createSuccessBaseDTO(data, list.size());
    }

    /**
     * 活动商品
     * @param from
     * @param count
     * @return
     */
    @RequestMapping("/getCommodityListByActivity")
    @ResponseBody
    public BaseDTO getCommodityListByActivity(Integer from, Integer count){
        from = CutPageUtils.getInteger(from);
        count = CutPageUtils.getCount(count);
        List<CommodityDO> list = commodityManager.selectCommodityDOByType("activity", from, count);
        if(list == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.SYSTEM_ERROR);
        }
        List<CommodityView> data = DOToView(CutPageUtils.divide(list, from, count));
        return BaseDTO.createSuccessBaseDTO(data, list.size());
    }

    /**
     * 新品推荐
     * @param from
     * @param count
     * @return
     */
    @RequestMapping("/getCommodityListByNew")
    @ResponseBody
    public BaseDTO getCommodityListByNew(Integer from, Integer count){
        from = CutPageUtils.getInteger(from);
        count = CutPageUtils.getCount(count);
        List<CommodityDO> list = commodityManager.selectCommodityDOByType("newCommodity", from, count);
        if(list == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.SYSTEM_ERROR);
        }
        List<CommodityView> data = DOToView(CutPageUtils.divide(list, from, count));
        return BaseDTO.createSuccessBaseDTO(data, list.size());
    }

    /**
     * 获取商品详情
     * @param commodityId
     * @return
     */
    @RequestMapping("/getCommodityInfo")
    @ResponseBody
    public BaseDTO getCommodityInfo(Long commodityId){
        CommodityDO commodityDO = commodityManager.selectCommodityDOById(commodityId);
        return BaseDTO.createSuccessBaseDTO(commodityDO);
    }

    private List<CommodityView> DOToView(List<CommodityDO> list){
        List<CommodityView> data = Lists.newArrayList();
        for(CommodityDO commodityDO : list){
            CommodityView commodityView = new CommodityView();
            commodityView.setId(commodityDO.getId());
            commodityView.setName(commodityDO.getName());
            commodityView.setPrice(commodityDO.getPrice());
            commodityView.setOverView(commodityDO.getOverView());
            data.add(commodityView);
        }
        return data;
    }
}
