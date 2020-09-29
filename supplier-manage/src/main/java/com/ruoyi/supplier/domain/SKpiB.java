package com.ruoyi.supplier.domain;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商绩效考评子对象 s_kpi_b
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
public class SKpiB extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** id */
	private Long id;

	/** 主表id */
	@Excel(name = "主表id")
	private Long kpiId;

	/** 评估项目id */
	@Excel(name = "评估项目id")
	private Long assessId;

	/**
	 * KPI指标第二层名称
	 */
	private String twoSortName;

	/**
	 * KPI指标第三层名称
	 */
	private String threeSortName;

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

	/**
	 * 备注
	 */
	private String remark;

	/** 对应一级供应商部门 */
	private String supplierDept;

	/** 分数 （单个供应商绩效考评） */
	private Long scoreValue;

	public Long getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(Long scoreValue) {
		this.scoreValue = scoreValue;
	}

	public String getSupplierDept() {
		return supplierDept;
	}

	public void setSupplierDept(String supplierDept) {
		this.supplierDept = supplierDept;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	/**
	 * 评估结果信息
	 */
	private List<SKpiResult> KpiResults;

	public List<SKpiResult> getKpiResults() {
		return KpiResults;
	}

	public void setKpiResults(List<SKpiResult> kpiResults) {
		KpiResults = kpiResults;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setKpiId(Long kpiId) {
		this.kpiId = kpiId;
	}

	public Long getKpiId() {
		return kpiId;
	}

	public void setAssessId(Long assessId) {
		this.assessId = assessId;
	}

	public Long getAssessId() {
		return assessId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("kpiId", getKpiId()).append("assessId", getAssessId()).append("remark", getRemark())
				.append("delFlag", getDelFlag()).append("twoSortName", getTwoSortName())
				.append("threeSortName", getThreeSortName()).append("assessName", getAssessName())
				.append("score", getScore()).append("criteriaName", getCriteriaName()).toString();
	}
}
