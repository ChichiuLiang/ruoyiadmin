package com.ruoyi.supplier.service;

import java.util.List;

import com.ruoyi.supplier.domain.SAssess;
import com.ruoyi.supplier.domain.VAssessinfo;

/**
 * 评估项目Service接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-03
 */
public interface ISAssessService {
	/**
	 * 查询评估项目
	 * 
	 * @param id
	 *            评估项目ID
	 * @return 评估项目
	 */
	public SAssess selectSAssessById(Long id);

	/**
	 * 查询部门关联评估项目明细
	 * 
	 * @param vAssessinfo
	 * 
	 * @return 评估项目集合
	 */
	public List<VAssessinfo> selectVAssessinfoList(VAssessinfo vAssessinfo);

	/**
	 * 查询评估项目列表
	 * 
	 * @param sAssess
	 *            评估项目
	 * @return 评估项目集合
	 */
	public List<SAssess> selectSAssessList(SAssess sAssess);

	/**
	 * 新增评估项目
	 * 
	 * @param sAssess
	 *            评估项目
	 * @return 结果
	 */
	public int insertSAssess(SAssess sAssess);

	/**
	 * 修改评估项目
	 * 
	 * @param sAssess
	 *            评估项目
	 * @return 结果
	 */
	public int updateSAssess(SAssess sAssess);

	/**
	 * 批量删除评估项目
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSAssessByIds(String ids);

	/**
	 * 删除评估项目信息
	 * 
	 * @param id
	 *            评估项目ID
	 * @return 结果
	 */
	public int deleteSAssessById(Long id);

	/**
	 * 评估项目状态修改
	 *
	 * @param sAssess
	 * @return 结果
	 */
	public int changeStatus(SAssess sAssess);

	/**
	 * 判断评估项目是否被使用
	 *
	 * @param id
	 * @return 结果
	 */
	public boolean checkAssessExistUse(Long id);
}
