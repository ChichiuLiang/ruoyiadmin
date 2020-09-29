package com.ruoyi.supplier.mapper;

import java.util.List;
import com.ruoyi.supplier.domain.SKpiSort;
import org.apache.ibatis.annotations.Param;

/**
 * KPI指标分类Mapper接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-03
 */
public interface SKpiSortMapper 
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
     * 删除KPI指标分类
     * 
     * @param id KPI指标分类ID
     * @return 结果
     */
    public int deleteSKpiSortById(Long id);

    /**
     * 批量删除KPI指标分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSKpiSortByIds(String[] ids);

    /**
     * 查询下级类目
     *
     * @param sKpiSort KPI指标分类
     * @return 结果
     */
    public int selectSortCount(SKpiSort sKpiSort);

    /**
     * 查询KPI指标是否存在评估项目
     *
     * @param sortId KPI指标ID
     * @return 结果
     */
    public int checkSortExistAssess(Long sortId);

    /**
     * 根据ID查询所有子类
     *
     * @param id 分类ID
     * @return KPI分类列表
     */
    public List<SKpiSort> selectChildrenSortById(Long id);

    /**
     * 修改子元素关系
     *
     * @param sorts 子元素
     * @return 结果
     */
    public int updateSortChildren(@Param("sorts") List<SKpiSort> sorts);
}
