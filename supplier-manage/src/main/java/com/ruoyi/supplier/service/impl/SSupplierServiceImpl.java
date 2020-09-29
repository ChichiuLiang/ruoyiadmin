package com.ruoyi.supplier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.supplier.domain.SSupplier;
import com.ruoyi.supplier.domain.VKpiInfo;
import com.ruoyi.supplier.mapper.SSupplierMapper;
import com.ruoyi.supplier.service.ISSupplierService;

/**
 * 供应商档案Service业务层处理
 * 
 * @author Liu Qiyong
 * @date 2020-08-18
 */
@Service
public class SSupplierServiceImpl implements ISSupplierService {
	@Autowired
	private SSupplierMapper sSupplierMapper;

	/**
	 * 查询供应商档案
	 * 
	 * @param id
	 *            供应商档案ID
	 * @return 供应商档案
	 */
	@Override
	public SSupplier selectSSupplierById(Long id) {
		return sSupplierMapper.selectSSupplierById(id);
	}

	/**
	 * 查询供应商档案列表
	 * 
	 * @param sSupplier
	 *            供应商档案
	 * @return 供应商档案
	 */
	@Override
	@DataScope(deptAlias = "t")
	public List<SSupplier> selectSSupplierList(SSupplier sSupplier) {
		List<SSupplier> sSupplierList = sSupplierMapper.selectSSupplierList(sSupplier);
		return sSupplierList;
	}

	/**
	 * 查询供应商档案列表
	 * 
	 * @param sSupplier
	 *            供应商档案
	 * @return 供应商档案
	 */
	@Override
	public List<SSupplier> selectSSupplierListByType(SSupplier sSupplier) {
		List<SSupplier> sSupplierList = sSupplierMapper.selectSSupplierListByType(sSupplier);
		return sSupplierList;
	}
	
	/**
	 * 根据kpiId查询供应商档案列表
	 * 
	 * @param kpiId
	 *            
	 * @return 供应商档案
	 */
	@Override
	public List<SSupplier> getSupplierListByKpiId(Long kpiId) {
		List<SSupplier> sSupplierList = sSupplierMapper.getSupplierListByKpiId(kpiId);
		return sSupplierList;
	}
	
	/**
	 * 根据考核类型、年度、季度查询供应商
	 * 
	 * @param vKpiInfo
	 *            
	 * @return 供应商档案
	 */
	@Override
	public List<SSupplier> getSupplierListBySKpi(VKpiInfo vKpiInfo) {
		List<SSupplier> sSupplierList = sSupplierMapper.getSupplierListBySKpi(vKpiInfo);
		return sSupplierList;
	}

	/**
	 * 新增供应商档案
	 * 
	 * @param sSupplier
	 *            供应商档案
	 * @return 结果
	 */
	@Override
	public int insertSSupplier(SSupplier sSupplier) {
		sSupplier.setCreateTime(DateUtils.getNowDate());
		return sSupplierMapper.insertSSupplier(sSupplier);
	}

	/**
	 * 修改供应商档案
	 * 
	 * @param sSupplier
	 *            供应商档案
	 * @return 结果
	 */
	@Override
	public int updateSSupplier(SSupplier sSupplier) {
		sSupplier.setUpdateTime(DateUtils.getNowDate());
		return sSupplierMapper.updateSSupplier(sSupplier);
	}

	/**
	 * 删除供应商档案对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteSSupplierByIds(String ids) {
		return sSupplierMapper.deleteSSupplierByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除供应商档案信息
	 * 
	 * @param id
	 *            供应商档案ID
	 * @return 结果
	 */
	@Override
	public int deleteSSupplierById(Long id) {
		return sSupplierMapper.deleteSSupplierById(id);
	}

	/**
	 * 供应商档案状态修改
	 *
	 * @param sAssess
	 * @return 结果
	 */
	public int changeStatus(SSupplier sSupplier) {
		return sSupplierMapper.changeStatus(sSupplier);
	}

	/**
	 * 判断供应商是否被使用
	 *
	 * @param id
	 * @return 结果
	 */
	public boolean checkSupplierExistUse(Long id) {
		int flag = sSupplierMapper.checkSupplierExistUse(id);
		if (flag > 0) {
			return true;
		}
		return false;
	}
}
