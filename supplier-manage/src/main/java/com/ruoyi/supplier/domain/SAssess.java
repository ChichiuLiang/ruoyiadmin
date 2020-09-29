package com.ruoyi.supplier.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 评估项目对象 s_assess
 *
 * @author Liu Qiyong
 * @date 2020-08-03
 */
public class SAssess extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 分类id
	 */
	@Excel(name = "分类id")
	private Long sortId;

	/**
	 * KPI分类名称
	 */
	private String sortName;

	/**
	 * 评估项目
	 */
	@Excel(name = "评估项目")
	private String assessName;

	/**
	 * 分值
	 */
	@Excel(name = "分值")
	private Long score;

	/**
	 * 衡量标准
	 */
	@Excel(name = "衡量标准")
	private String criteriaName;

	/**
	 * 状态（0正常 1停用）
	 */
	@Excel(name = "状态", readConverterExp = "0=正常,1=停用")
	private String status;

	/** 部门组 */
	private Long[] deptIds;

	/** 对应一级供应商部门 */
	private String supplierDept;

	public String getSupplierDept() {
		return supplierDept;
	}

	public void setSupplierDept(String supplierDept) {
		this.supplierDept = supplierDept;
	}

	public Long[] getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(Long[] deptIds) {
		this.deptIds = deptIds;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setSortId(Long sortId) {
		this.sortId = sortId;
	}

	public Long getSortId() {
		return sortId;
	}

	public void setAssessName(String assessName) {
		this.assessName = assessName;
	}

	public String getAssessName() {
		return assessName;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getScore() {
		return score;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("sortId", getSortId()).append("assessName", getAssessName()).append("score", getScore())
				.append("criteriaName", getCriteriaName()).append("createBy", getCreateBy())
				.append("createTime", getCreateTime()).append("updateBy", getUpdateBy())
				.append("updateTime", getUpdateTime()).append("delFlag", getDelFlag()).append("status", getStatus())
				.toString();
	}
}
