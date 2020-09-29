package com.ruoyi.supplier.mapper;

import java.util.List;

import com.ruoyi.supplier.domain.SSupplier;
import com.ruoyi.supplier.domain.VKpiInfo;

/**
 * 供应商档案Mapper接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-18
 */
public interface SSupplierMapper {
	/**
	 * 查询供应商档案
	 * 
	 * @param id
	 *            供应商档案ID
	 * @return 供应商档案
	 */
	public SSupplier selectSSupplierById(Long id);

	/**
	 * 查询供应商档案列表
	 * 
	 * @param sSupplier
	 *            供应商档案
	 * @return 供应商档案集合
	 */
	public List<SSupplier> selectSSupplierList(SSupplier sSupplier);

	/**
	 * 查询供应商档案列表
	 * 
	 * @param sSupplier
	 *            供应商档案
	 * @return 供应商档案集合
	 */
	public List<SSupplier> selectSSupplierListByType(SSupplier sSupplier);

	/**
	 * 根据kpiId查询供应商档案列表
	 * 
	 * @param kpiId
	 * 
	 * @return 供应商档案
	 */
	public List<SSupplier> getSupplierListByKpiId(Long kpiId);

	/**
	 * 根据考核类型、年度、季度查询供应商
	 * 
	 * @param vKpiInfo
	 * 
	 * @return 供应商档案
	 */
	public List<SSupplier> getSupplierListBySKpi(VKpiInfo vKpiInfo);

	/**
	 * 新增供应商档案
	 * 
	 * @param sSupplier
	 *            供应商档案
	 * @return 结果
	 */
	public int insertSSupplier(SSupplier sSupplier);

	/**
	 * 修改供应商档案
	 * 
	 * @param sSupplier
	 *            供应商档案
	 * @return 结果
	 */
	public int updateSSupplier(SSupplier sSupplier);

	/**
	 * 删除供应商档案
	 * 
	 * @param id
	 *            供应商档案ID
	 * @return 结果
	 */
	public int deleteSSupplierById(Long id);

	/**
	 * 批量删除供应商档案
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSSupplierByIds(String[] ids);

	/**
	 * 供应商档案状态修改
	 *
	 * @param sAssess
	 * @return 结果
	 */
	public int changeStatus(SSupplier sSupplier);

	/**
	 * 判断供应商是否被使用
	 *
	 * @param id
	 * @return 结果
	 */
	public int checkSupplierExistUse(Long id);

}
