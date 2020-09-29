package com.ruoyi.supplier.service;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.supplier.domain.SKpiSort;

/**
 * KPI指标分类Service接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-03
 */
public interface ISKpiSortService 
{
    /**
     * 查询KPI指标分类
     * 
     * @param id KPI指标分类ID
     * @return KPI指标分类
     */
    public SKpiSort selectSKpiSortById(Long id);

    /**
     * 查询KPI指标分类列表
     * 
     * @param sKpiSort KPI指标分类
     * @return KPI指标分类集合
     */
    public List<SKpiSort> selectSKpiSortList(SKpiSort sKpiSort);

    /**
     * 新增KPI指标分类
     * 
     * @param sKpiSort KPI指标分类
     * @return 结果
     */
    public int insertSKpiSort(SKpiSort sKpiSort);

    /**
     * 修改KPI指标分类
     * 
     * @param sKpiSort KPI指标分类
     * @return 结果
     */
    public int updateSKpiSort(SKpiSort sKpiSort);

    /**
     * 批量删除KPI指标分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSKpiSortByIds(String ids);

    /**
     * 删除KPI指标分类信息
     * 
     * @param id KPI指标分类ID
     * @return 结果
     */
    public int deleteSKpiSortById(Long id);

    /**
     * 查询KPI指标分类树列表
     *
     * @return 所有分类信息
     */
    public List<Ztree> selectSortTree();

    /**
     * 查询下级类目
     *
     * @param parentId 父ID
     * @return 结果
     */
    public int selectSortCount(Long parentId);

    /**
     * 查询KPI指标是否存在评估项目
     *
     * @param sortId KPI指标ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkSortExistAssess(Long sortId);

    /**
     * 查询KPI分类树（排除下级）
     *
     * @param sKpiSort KPI分类信息
     * @return 所有分类信息
     */
    public List<Ztree> selectSortTreeExcludeChild(SKpiSort sKpiSort);
}
