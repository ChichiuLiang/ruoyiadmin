package com.ruoyi.supplier.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.supplier.domain.SAssess;
import com.ruoyi.supplier.domain.SAssessDept;
import com.ruoyi.supplier.domain.VAssessinfo;
import com.ruoyi.supplier.mapper.SAssessMapper;
import com.ruoyi.supplier.service.ISAssessService;

/**
 * 评估项目Service业务层处理
 * 
 * @author Liu Qiyong
 * @date 2020-08-03
 */
@Service
public class SAssessServiceImpl implements ISAssessService {
	@Autowired
	private SAssessMapper sAssessMapper;

	/**
	 * 查询评估项目
	 * 
	 * @param id
	 *            评估项目ID
	 * @return 评估项目
	 */
	@Override
	public SAssess selectSAssessById(Long id) {
		return sAssessMapper.selectSAssessById(id);
	}

	/**
	 * 查询评估项目列表
	 * 
	 * @param sAssess
	 *            评估项目
	 * @return 评估项目
	 */
	@Override
	public List<SAssess> selectSAssessList(SAssess sAssess) {
		return sAssessMapper.selectSAssessList(sAssess);
	}

	/**
	 * 查询部门关联评估项目明细
	 * 
	 * @param deptId
	 *            部门id
	 * @return 评估项目集合
	 */
	@Override
	public List<VAssessinfo> selectVAssessinfoList(VAssessinfo vAssessinfo) {
		return sAssessMapper.selectVAssessinfoList(vAssessinfo);
	}

	/**
	 * 新增评估项目
	 * 
	 * @param sAssess
	 *            评估项目
	 * @return 结果
	 */
	@Override
	@Transactional
	public int insertSAssess(SAssess sAssess) {
		sAssess.setCreateTime(DateUtils.getNowDate());
		// 新增评估项目
		sAssessMapper.insertSAssess(sAssess);
		return insertAssessDept(sAssess);
	}

	/**
	 * 新增评估项目关联部门信息
	 *
	 * @param sAssess
	 */
	public int insertAssessDept(SAssess sAssess) {
		int rows = 1;
		List<SAssessDept> list = new ArrayList<SAssessDept>();
		for (Long deptId : sAssess.getDeptIds()) {
			SAssessDept sad = new SAssessDept();
			sad.setAssessId(sAssess.getId());
			sad.setDeptId(deptId);
			list.add(sad);
		}
		if (list.size() > 0) {
			rows = sAssessMapper.batchAssessDept(list);
		}
		return rows;
	}

	/**
	 * 修改评估项目
	 * 
	 * @param sAssess
	 *            评估项目
	 * @return 结果
	 */
	@Override
	@Transactional
	public int updateSAssess(SAssess sAssess) {
		// 修改评估项目信息
		sAssess.setUpdateTime(DateUtils.getNowDate());
		sAssessMapper.updateSAssess(sAssess);
		// 删除评估项目与部门关联
		sAssessMapper.deleteAssessDeptByAssessId(sAssess.getId());
		return insertAssessDept(sAssess);
	}

	/**
	 * 删除评估项目对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteSAssessByIds(String ids) {
		return sAssessMapper.deleteSAssessByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除评估项目信息
	 * 
	 * @param id
	 *            评估项目ID
	 * @return 结果
	 */
	@Override
	public int deleteSAssessById(Long id) {
		return sAssessMapper.deleteSAssessById(id);
	}

	/**
	 * 评估项目状态修改
	 *
	 * @param sAssess
	 * @return 结果
	 */
	public int changeStatus(SAssess sAssess) {
		return sAssessMapper.changeStatus(sAssess);
	}

	/**
	 * 判断评估项目是否被使用
	 *
	 * @param id
	 * @return 结果
	 */
	public boolean checkAssessExistUse(Long id) {
		int flag = sAssessMapper.checkAssessExistUse(id);
		if (flag > 0) {
			return true;
		}
		return false;
	}
}
