package com.ruoyi.supplier.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 部门关联评估项目视图 VAssessinfo
 *
 * @author Liu Qiyong
 * @date 2020-08-03
 */
public class VAssessinfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * KPI指标第一层id
	 */
	private Long oneSortId;

	/**
	 * KPI指标第二层id
	 */
	private Long twoSortId;

	/**
	 * KPI指标第三层id
	 */
	private Long threeSortId;

	/**
	 * KPI指标第一层名称
	 */
	private String oneSortName;

	/**
	 * KPI指标第二层名称
	 */
	private String twoSortName;

	/**
	 * KPI指标第三层名称
	 */
	private String threeSortName;

	/**
	 * 评估项目id
	 */
	private Long assessId;

	/**
	 * 评估项目
	 */
	private String assessName;

	/**
	 * 分值
	 */
	private Long score;

	/**
	 * 衡量标准
	 */
	private String criteriaName;

	/** 关联部门 */
	private Long deptId;

	/** 对应一级供应商部门 */
	private String supplierDept;

	public String getSupplierDept() {
		return supplierDept;
	}

	public void setSupplierDept(String supplierDept) {
		this.supplierDept = supplierDept;
	}

	public Long getAssessId() {
		return assessId;
	}

	public void setAssessId(Long assessId) {
		this.assessId = assessId;
	}

	public Long getOneSortId() {
		return oneSortId;
	}

	public void setOneSortId(Long oneSortId) {
		this.oneSortId = oneSortId;
	}

	public Long getTwoSortId() {
		return twoSortId;
	}

	public void setTwoSortId(Long twoSortId) {
		this.twoSortId = twoSortId;
	}

	public Long getThreeSortId() {
		return threeSortId;
	}

	public void setThreeSortId(Long threeSortId) {
		this.threeSortId = threeSortId;
	}

	public String getOneSortName() {
		return oneSortName;
	}

	public void setOneSortName(String oneSortName) {
		this.oneSortName = oneSortName;
	}

	public String getTwoSortName() {
		return twoSortName;
	}

	public void setTwoSortName(String twoSortName) {
		this.twoSortName = twoSortName;
	}

	public String getThreeSortName() {
		return threeSortName;
	}

	public void setThreeSortName(String threeSortName) {
		this.threeSortName = threeSortName;
	}

	public String getAssessName() {
		return assessName;
	}

	public void setAssessName(String assessName) {
		this.assessName = assessName;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("oneSortId", getOneSortId())
				.append("twoSortId", getTwoSortId()).append("threeSortId", getThreeSortId())
				.append("oneSortName", getOneSortName()).append("twoSortName", getTwoSortName())
				.append("threeSortName", getThreeSortName()).append("assessId", getAssessId())
				.append("assessName", getAssessName()).append("score", getScore())
				.append("criteriaName", getCriteriaName()).append("deptId", getDeptId()).toString();
	}
}
