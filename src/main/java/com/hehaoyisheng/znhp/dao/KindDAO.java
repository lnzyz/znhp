package com.hehaoyisheng.znhp.dao;

import com.hehaoyisheng.znhp.dao.DO.KindDO;

import java.util.List;

/**
 * Created by yunzhao on 2017/8/2.
 */
public interface KindDAO {
    /**
     * 获取一级分类
     * @return
     * @throws Exception
     */
    List<KindDO> getKinds() throws Exception;

    /**
     * 根据分类Id获取子分类
     * @param kindId
     * @return
     * @throws Exception
     */
    List<KindDO> getKindsByKind(Long kindId) throws Exception;

    /**
     * 修改分类
     * @param kindDO
     * @return
     * @throws Exception
     */
    boolean updateKind(KindDO kindDO) throws Exception;

    /**
     * 删除分类
     * @param kindId
     * @return
     * @throws Exception
     */
    boolean deleteKind(Long kindId) throws Exception;
}