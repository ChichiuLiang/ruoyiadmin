package com.ruoyi.supplier.service;

import java.util.List;

import com.ruoyi.supplier.domain.SAssess;
import com.ruoyi.supplier.domain.SKpi;
import com.ruoyi.supplier.domain.VKpiInfo;

/**
 * 供应商绩效考评主Service接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
public interface ISKpiService {
	/**
	 * 查询供应商绩效考评主
	 * 
	 * @param id
	 *            供应商绩效考评主ID
	 * @return 供应商绩效考评主
	 */
	public SKpi selectSKpiById(Long id);

	/**
	 * 查询供应商绩效考评主列表
	 * 
	 * @param sKpi
	 *            供应商绩效考评主
	 * @return 供应商绩效考评主集合
	 */
	public List<SKpi> selectSKpiList(SKpi sKpi);

	/**
	 * 查询供应商绩效考核类型
	 *
	 * @return 供应商绩效考核类型集合
	 */
	public List<VKpiInfo> selectKpiType(SKpi sKpi);

	/**
	 * 新增供应商绩效考评主
	 * 
	 * @param sKpi
	 *            供应商绩效考评主
	 * @return 结果
	 */
	public int insertSKpi(SKpi sKpi);

	/**
	 * 修改供应商绩效考评主
	 * 
	 * @param sKpi
	 *            供应商绩效考评主
	 * @return 结果
	 */
	public int updateSKpi(SKpi sKpi);

	/**
	 * 批量删除供应商绩效考评主
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSKpiByIds(String ids);

	/**
	 * 删除供应商绩效考评主信息
	 * 
	 * @param id
	 *            供应商绩效考评主ID
	 * @return 结果
	 */
	public int deleteSKpiById(Long id);

	/**
	 * 更新状态
	 *
	 * @param sKpi
	 * @return 结果
	 */
	public int updateStatus(SKpi sKpi);

	/**
	 * 查询供应商绩效考评主列表
	 * 
	 * @param vKpiInfo
	 * 
	 * @return 供应商绩效考评主集合
	 */
	List<VKpiInfo> selectVKpiList(SKpi sKpi);

	/**
	 * 查询供应商绩效考评主列表
	 * 
	 * @param vKpiInfo
	 * 
	 * @return 供应商绩效考评主集合
	 */
	List<VKpiInfo> selectVKpiInfoList(VKpiInfo vKpiInfo);
	
	/**
	 * 判断绩效考核是否存在
	 *
	 * @param sKpi
	 * @return 结果
	 */
	public boolean checkSKpiExist(SKpi sKpi);
}
