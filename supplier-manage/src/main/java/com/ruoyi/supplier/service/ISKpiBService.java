package com.ruoyi.supplier.service;

import java.util.List;
import com.ruoyi.supplier.domain.SKpiB;

/**
 * 供应商绩效考评子Service接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
public interface ISKpiBService {
	/**
	 * 查询供应商绩效考评子
	 * 
	 * @param id
	 *            供应商绩效考评子ID
	 * @return 供应商绩效考评子
	 */
	public SKpiB selectSKpiBById(Long id);

	/**
	 * 根据主表id查询子表数据
	 * 
	 * @param kpiId
	 * @return
	 */
	public List<SKpiB> selectSKpiBByKpiId(Long kpiId);

	/**
	 * 查询供应商绩效考评子列表
	 * 
	 * @param sKpiB
	 *            供应商绩效考评子
	 * @return 供应商绩效考评子集合
	 */
	public List<SKpiB> selectSKpiBList(SKpiB sKpiB);

	/**
	 * 新增供应商绩效考评子
	 * 
	 * @param sKpiB
	 *            供应商绩效考评子
	 * @return 结果
	 */
	public int insertSKpiB(SKpiB sKpiB);

	/**
	 * 修改供应商绩效考评子
	 * 
	 * @param sKpiB
	 *            供应商绩效考评子
	 * @return 结果
	 */
	public int updateSKpiB(SKpiB sKpiB);

	/**
	 * 批量删除供应商绩效考评子
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSKpiBByIds(String ids);
}
