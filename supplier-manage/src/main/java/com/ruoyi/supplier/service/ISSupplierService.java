package com.ruoyi.supplier.service;

import java.util.List;

import com.ruoyi.supplier.domain.SAssess;
import com.ruoyi.supplier.domain.SSupplier;
import com.ruoyi.supplier.domain.VKpiInfo;

/**
 * 供应商档案Service接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-18
 */
public interface ISSupplierService {
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
	 * 批量删除供应商档案
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSSupplierByIds(String ids);

	/**
	 * 删除供应商档案信息
	 * 
	 * @param id
	 *            供应商档案ID
	 * @return 结果
	 */
	public int deleteSSupplierById(Long id);

	/**
	 * 供应商档案修改
	 *
	 * @param sSupplier
	 * @return 结果
	 */
	public int changeStatus(SSupplier sSupplier);

	/**
	 * 判断供应商是否被引用
	 *
	 * @param id
	 * @return 结果
	 */
	public boolean checkSupplierExistUse(Long id);

	/**
	 * 查询供应商档案列表
	 * 
	 * @param sSupplier
	 *            供应商档案
	 * @return 供应商档案
	 */
	List<SSupplier> selectSSupplierListByType(SSupplier sSupplier);

	/**
	 * 根据kpiId查询供应商档案列表
	 * 
	 * @param kpiId
	 *            
	 * @return 供应商档案
	 */
	List<SSupplier> getSupplierListByKpiId(Long kpiId);

	/**
	 * 根据考核类型、年度、季度查询供应商
	 * 
	 * @param vKpiInfo
	 *            
	 * @return 供应商档案
	 */
	List<SSupplier> getSupplierListBySKpi(VKpiInfo vKpiInfo);

}
