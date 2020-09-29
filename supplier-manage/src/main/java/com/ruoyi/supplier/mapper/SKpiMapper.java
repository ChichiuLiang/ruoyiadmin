package com.ruoyi.supplier.mapper;

import java.util.List;
import com.ruoyi.supplier.domain.SKpi;
import com.ruoyi.supplier.domain.VKpiInfo;

/**
 * 供应商绩效考评主Mapper接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
public interface SKpiMapper {
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
	 * @param vKpiInfo
	 * 
	 * @return 供应商绩效考核类型集合
	 */
	public List<VKpiInfo> selectKpiType(SKpi sKpi);

	/**
	 * 查询供应商绩效考评主列表
	 * 
	 * @param vKpiInfo
	 * 
	 * @return 供应商绩效考评主集合
	 */
	public List<VKpiInfo> selectVKpiList(SKpi sKpi);
	
	/**
	 * 查询供应商绩效考评主列表
	 * 
	 * @param vKpiInfo
	 * 
	 * @return 供应商绩效考评主集合
	 */
	public List<VKpiInfo> selectVKpiInfoList(VKpiInfo vKpiInfo);

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
	 * 删除供应商绩效考评主
	 * 
	 * @param id
	 *            供应商绩效考评主ID
	 * @return 结果
	 */
	public int updateSKpiById(Long id);

	/**
	 * 删除供应商绩效考评主
	 * 
	 * @param id
	 *            供应商绩效考评主ID
	 * @return 结果
	 */
	public int deleteSKpiById(Long id);

	/**
	 * 批量删除供应商绩效考评主
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSKpiByIds(String[] ids);

	/**
	 * 更新状态
	 *
	 * @param sKpi
	 * @return 结果
	 */
	public int updateStatus(SKpi sKpi);
	
	/**
	 * 判断绩效考核是否存在
	 *
	 * @param sKpi
	 * @return 结果
	 */
	public int checkSKpiExist(SKpi sKpi);
}
