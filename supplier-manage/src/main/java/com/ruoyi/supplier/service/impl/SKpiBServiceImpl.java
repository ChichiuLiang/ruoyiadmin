package com.ruoyi.supplier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.supplier.domain.SKpiB;
import com.ruoyi.supplier.mapper.SKpiBMapper;
import com.ruoyi.supplier.service.ISKpiBService;

/**
 * 供应商绩效考评子Service业务层处理
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
@Service
public class SKpiBServiceImpl implements ISKpiBService {
	@Autowired
	private SKpiBMapper sKpiBMapper;

	/**
	 * 查询供应商绩效考评子
	 * 
	 * @param id
	 *            供应商绩效考评子ID
	 * @return 供应商绩效考评子
	 */
	@Override
	public SKpiB selectSKpiBById(Long id) {
		return sKpiBMapper.selectSKpiBById(id);
	}

	/**
	 * 根据主表id查询子表数据
	 */
	@Override
	public List<SKpiB> selectSKpiBByKpiId(Long kpiId) {
		return sKpiBMapper.selectSKpiBByKpiId(kpiId);
	}

	/**
	 * 查询供应商绩效考评子列表
	 * 
	 * @param sKpiB
	 *            供应商绩效考评子
	 * @return 供应商绩效考评子
	 */
	@Override
	public List<SKpiB> selectSKpiBList(SKpiB sKpiB) {
		return sKpiBMapper.selectSKpiBList(sKpiB);
	}

	/**
	 * 新增供应商绩效考评子
	 * 
	 * @param sKpiB
	 *            供应商绩效考评子
	 * @return 结果
	 */
	@Override
	public int insertSKpiB(SKpiB sKpiB) {
		return sKpiBMapper.insertSKpiB(sKpiB);
	}

	/**
	 * 修改供应商绩效考评子
	 * 
	 * @param sKpiB
	 *            供应商绩效考评子
	 * @return 结果
	 */
	@Override
	public int updateSKpiB(SKpiB sKpiB) {
		return sKpiBMapper.updateSKpiB(sKpiB);
	}

	/**
	 * 删除供应商绩效考评子对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteSKpiBByIds(String ids) {
		return sKpiBMapper.deleteSKpiBByIds(Convert.toStrArray(ids));
	}
}
