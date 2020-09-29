package com.ruoyi.supplier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.supplier.domain.SKpi;
import com.ruoyi.supplier.domain.SKpiB;
import com.ruoyi.supplier.domain.SKpiResult;
import com.ruoyi.supplier.domain.VKpiInfo;
import com.ruoyi.supplier.mapper.SKpiBMapper;
import com.ruoyi.supplier.mapper.SKpiFileMapper;
import com.ruoyi.supplier.mapper.SKpiMapper;
import com.ruoyi.supplier.mapper.SKpiResultMapper;
import com.ruoyi.supplier.service.ISKpiService;

/**
 * 供应商绩效考评主Service业务层处理
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
@Service
public class SKpiServiceImpl implements ISKpiService {
	@Autowired
	private SKpiMapper sKpiMapper;

	@Autowired
	private SKpiBMapper sKpiBMapper;

	@Autowired
	private SKpiResultMapper sKpiResultMapper;

	@Autowired
	private SKpiFileMapper sKpiFileMapper;

	/**
	 * 查询供应商绩效考评主
	 * 
	 * @param id
	 *            供应商绩效考评主ID
	 * @return 供应商绩效考评主
	 */
	@Override
	public SKpi selectSKpiById(Long id) {
		return sKpiMapper.selectSKpiById(id);
	}

	/**
	 * 查询供应商绩效考评主列表
	 * 
	 * @param sKpi
	 *            供应商绩效考评主
	 * @return 供应商绩效考评主
	 */
	@Override
	@DataScope(deptAlias = "t")
	public List<SKpi> selectSKpiList(SKpi sKpi) {
		return sKpiMapper.selectSKpiList(sKpi);
	}

	/**
	 * 查询供应商绩效考核类型
	 * 
	 * vKpiInfo
	 * 
	 * @return 供应商绩效考核类型集合
	 */
	@Override
	@DataScope(deptAlias = "t")
	public List<VKpiInfo> selectKpiType(SKpi sKpi) {
		return sKpiMapper.selectKpiType(sKpi);
	}
	
	/**
	 * 查询供应商绩效考评主列表
	 * 
	 * @param vKpiInfo
	 * 
	 * @return 供应商绩效考评主集合
	 */
	@Override
	@DataScope(deptAlias = "t")
	public List<VKpiInfo> selectVKpiInfoList(VKpiInfo vKpiInfo){
		return sKpiMapper.selectVKpiInfoList(vKpiInfo);
	}

	/**
	 * 查询供应商绩效考评主列表
	 * 
	 * @param vKpiInfo
	 * 
	 * @return 供应商绩效考评主集合
	 */
	@Override
	@DataScope(deptAlias = "t")
	public List<VKpiInfo> selectVKpiList(SKpi sKpi) {
		return sKpiMapper.selectVKpiList(sKpi);
	}

	/**
	 * 新增供应商绩效考评主
	 * 
	 * @param sKpi
	 *            供应商绩效考评主
	 * @return 结果
	 */
	@Override
	@Transactional
	public int insertSKpi(SKpi sKpi) {
		// 插入主表 s_kpi
		sKpi.setCreateTime(DateUtils.getNowDate());
		int rows = sKpiMapper.insertSKpi(sKpi);
		List<SKpiB> sKpiBList = sKpi.getKpibs();
		for (SKpiB sKpiB : sKpiBList) {
			Long sKpiBId = sKpiBMapper.selectSKpiBId();
			sKpiB.setKpiId(sKpi.getId());
			sKpiB.setId(sKpiBId);

			List<SKpiResult> sKpiResultList = sKpiB.getKpiResults();
			if (StringUtils.isNotEmpty(sKpiResultList)) {
				for (SKpiResult sKpiResult : sKpiResultList) {
					Long sKpiResultId = sKpiResultMapper.selectSKpiResultId();
					sKpiResult.setKpiBId(sKpiBId);
					sKpiResult.setId(sKpiResultId);
					sKpiResult.setKpiId(sKpi.getId());
				}

				// 批量插入结果表 s_kpi_result
				sKpiResultMapper.batchSKpiResult(sKpiResultList);
			}
		}
		// 批量插入子表 s_kpi_b
		sKpiBMapper.batchSKpiB(sKpiBList);
		return rows;
	}
	
	/**
	 * 判断绩效考核是否存在
	 *
	 * @param sKpi
	 * @return 结果
	 */
	@Override
	public boolean checkSKpiExist(SKpi sKpi){
		int flag = sKpiMapper.checkSKpiExist(sKpi);
		if (flag > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 修改供应商绩效考评主
	 * 
	 * @param sKpi
	 *            供应商绩效考评主
	 * @return 结果
	 */
	@Override
	@Transactional
	public int updateSKpi(SKpi sKpi) {
		// 更新主表 s_kpi
		sKpi.setUpdateTime(DateUtils.getNowDate());
		int rows = sKpiMapper.updateSKpi(sKpi);
		Long kpiId = sKpi.getId();
		// 先删除子表和评分结果表
		sKpiBMapper.deleteSKpiBByKpiId(kpiId);
		sKpiResultMapper.deleteSKpiResultByKpiId(kpiId);
		// 重新添加子表和结果表数据
		List<SKpiB> sKpiBList = sKpi.getKpibs();
		for (SKpiB sKpiB : sKpiBList) {
			Long sKpiBId = sKpiBMapper.selectSKpiBId();
			sKpiB.setKpiId(kpiId);
			sKpiB.setId(sKpiBId);

			List<SKpiResult> sKpiResultList = sKpiB.getKpiResults();
			if (StringUtils.isNotEmpty(sKpiResultList)) {
				for (SKpiResult sKpiResult : sKpiResultList) {
					Long sKpiResultId = sKpiResultMapper.selectSKpiResultId();
					sKpiResult.setKpiBId(sKpiBId);
					sKpiResult.setId(sKpiResultId);
					sKpiResult.setKpiId(kpiId);
				}
				// 批量插入结果表 s_kpi_result
				sKpiResultMapper.batchSKpiResult(sKpiResultList);
			}

		}
		// 批量插入子表 s_kpi_b
		sKpiBMapper.batchSKpiB(sKpiBList);
		return rows;
	}

	/**
	 * 删除供应商绩效考评主对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteSKpiByIds(String ids) {
		return sKpiMapper.deleteSKpiByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除供应商绩效考评主信息
	 * 
	 * @param id
	 *            供应商绩效考评主ID
	 * @return 结果
	 */
	@Override
	@Transactional
	public int deleteSKpiById(Long id) {
		int rows = sKpiMapper.updateSKpiById(id);
		sKpiBMapper.updateSKpiBByKpiId(id);
		sKpiResultMapper.updateSKpiResultByKpiId(id);
		sKpiFileMapper.updateSKpiFileByKpiId(id);
		return rows;
	}

	/**
	 * 更新状态
	 *
	 * @param sKpi
	 * @return 结果
	 */
	public int updateStatus(SKpi sKpi) {
		return sKpiMapper.updateStatus(sKpi);
	}
}
