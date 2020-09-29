package com.ruoyi.supplier.mapper;

import java.util.List;

import com.ruoyi.supplier.domain.SAssess;
import com.ruoyi.supplier.domain.SAssessDept;
import com.ruoyi.supplier.domain.VAssessinfo;

/**
 * 评估项目Mapper接口
 * 
 * @author Liu Qiyong
 * @date 2020-08-03
 */
public interface SAssessMapper {
	/**
	 * 查询评估项目
	 * 
	 * @param id
	 *            评估项目ID
	 * @return 评估项目
	 */
	public SAssess selectSAssessById(Long id);

	/**
	 * 查询评估项目列表
	 * 
	 * @param sAssess
	 *            评估项目
	 * @return 评估项目集合
	 */
	public List<SAssess> selectSAssessList(SAssess sAssess);

	/**
	 * 查询部门关联评估项目明细
	 * 
	 * @param vAssessinfo
	 *            部门id
	 * @return 评估项目集合
	 */
	public List<VAssessinfo> selectVAssessinfoList(VAssessinfo vAssessinfo);

	/**
	 * 新增评估项目
	 * 
	 * @param sAssess
	 *            评估项目
	 * @return 结果
	 */
	public int insertSAssess(SAssess sAssess);

	/**
	 * 批量新增评估项目关联部门信息
	 *
	 * @param assessDeptList
	 * @return 结果
	 */
	public int batchAssessDept(List<SAssessDept> assessDeptList);

	/**
	 * 修改评估项目
	 * 
	 * @param sAssess
	 *            评估项目
	 * @return 结果
	 */
	public int updateSAssess(SAssess sAssess);

	/**
	 * 删除评估项目
	 * 
	 * @param id
	 *            评估项目ID
	 * @return 结果
	 */
	public int deleteSAssessById(Long id);

	/**
	 * 批量删除评估项目
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSAssessByIds(String[] ids);

	/**
	 * 评估项目状态修改
	 *
	 * @param sAssess
	 * @return 结果
	 */
	public int changeStatus(SAssess sAssess);

	/**
	 * 通过评估项目ID删除其与部门关联
	 *
	 * @param assessId
	 * @return 结果
	 */
	public int deleteAssessDeptByAssessId(Long assessId);

	/**
	 * 判断评估项目是否被使用
	 *
	 * @param id
	 * @return 结果
	 */
	public int checkAssessExistUse(Long id);
}
