package com.ruoyi.supplier.service;

import java.util.List;
import com.ruoyi.supplier.domain.SKpiResult;

/**
 * 供应商绩效考评结果Service接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
public interface ISKpiResultService 
{
    /**
     * 查询供应商绩效考评结果
     * 
     * @param id 供应商绩效考评结果ID
     * @return 供应商绩效考评结果
     */
    public SKpiResult selectSKpiResultById(Long id);
    
    /**
	 * 根据主表id查询评分结果数据
	 * 
	 * @param kpiId
	 * @return
	 */
	public List<SKpiResult> selectSKpiResultByKpiId(Long kpiId);

    /**
     * 查询供应商绩效考评结果列表
     * 
     * @param sKpiResult 供应商绩效考评结果
     * @return 供应商绩效考评结果集合
     */
    public List<SKpiResult> selectSKpiResultList(SKpiResult sKpiResult);

    /**
     * 新增供应商绩效考评结果
     * 
     * @param sKpiResult 供应商绩效考评结果
     * @return 结果
     */
    public int insertSKpiResult(SKpiResult sKpiResult);

    /**
     * 修改供应商绩效考评结果
     * 
     * @param sKpiResult 供应商绩效考评结果
     * @return 结果
     */
    public int updateSKpiResult(SKpiResult sKpiResult);

    /**
     * 批量删除供应商绩效考评结果
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSKpiResultByIds(String ids);
}
