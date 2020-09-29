package com.ruoyi.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.supplier.mapper.SKpiResultMapper;
import com.ruoyi.supplier.domain.SKpiResult;
import com.ruoyi.supplier.service.ISKpiResultService;
import com.ruoyi.common.core.text.Convert;

/**
 * 供应商绩效考评结果Service业务层处理
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
@Service
public class SKpiResultServiceImpl implements ISKpiResultService {
	@Autowired
	private SKpiResultMapper sKpiResultMapper;

	/**
	 * 查询供应商绩效考评结果
	 * 
	 * @param id
	 *            供应商绩效考评结果ID
	 * @return 供应商绩效考评结果
	 */
	@Override
	public SKpiResult selectSKpiResultById(Long id) {
		return sKpiResultMapper.selectSKpiResultById(id);
	}

	/**
	 * 根据主表id查询评分结果数据
	 * 
	 * @param kpiId
	 * @return
	 */
	@Override
	public List<SKpiResult> selectSKpiResultByKpiId(Long kpiId) {
		return sKpiResultMapper.selectSKpiResultByKpiId(kpiId);
	}

	/**
	 * 查询供应商绩效考评结果列表
	 * 
	 * @param sKpiResult
	 *            供应商绩效考评结果
	 * @return 供应商绩效考评结果
	 */
	@Override
	public List<SKpiResult> selectSKpiResultList(SKpiResult sKpiResult) {
		return sKpiResultMapper.selectSKpiResultList(sKpiResult);
	}

	/**
	 * 新增供应商绩效考评结果
	 * 
	 * @param sKpiResult
	 *            供应商绩效考评结果
	 * @return 结果
	 */
	@Override
	public int insertSKpiResult(SKpiResult sKpiResult) {
		return sKpiResultMapper.insertSKpiResult(sKpiResult);
	}

	/**
	 * 修改供应商绩效考评结果
	 * 
	 * @param sKpiResult
	 *            供应商绩效考评结果
	 * @return 结果
	 */
	@Override
	public int updateSKpiResult(SKpiResult sKpiResult) {
		return sKpiResultMapper.updateSKpiResult(sKpiResult);
	}

	/**
	 * 删除供应商绩效考评结果对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteSKpiResultByIds(String ids) {
		return sKpiResultMapper.deleteSKpiResultByIds(Convert.toStrArray(ids));
	}
}
