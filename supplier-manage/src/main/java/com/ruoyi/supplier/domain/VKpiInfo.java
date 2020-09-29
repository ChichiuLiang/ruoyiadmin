package com.ruoyi.supplier.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 绩效考核评分视图 VKpiInfo
 *
 * @author Liu Qiyong
 * @date 2020-08-03
 */
public class VKpiInfo extends BaseEntity {

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
	@Excel(name = "KPI指标")
	private String oneSortName;

	/**
	 * KPI指标第二层名称
	 */
	@Excel(name = "KPI指标")
	private String twoSortName;

	/**
	 * KPI指标第三层名称
	 */
	@Excel(name = "KPI指标")
	private String threeSortName;

	/**
	 * 评估项目id
	 */
	private Long assessId;

	/**
	 * 评估项目
	 */
	@Excel(name = "评估项目")
	private String assessName;

	/**
	 * 评估项目初始分值
	 */
	@Excel(name = "评估项目分值")
	private Long assessScore;

	/**
	 * 衡量标准
	 */
	@Excel(name = "衡量标准")
	private String criteriaName;

	/** 关联部门 id */
	private Long deptId;

	/** 关联部门名称 */
	@Excel(name = "部门")
	private String deptName;

	/** 主表id */
	private Long kpiId;

	/** 考核对象（1美体内衣供应商2包装袋供应商3包装物料供应商4二级供应商5二级供应商自评） */
	private Integer kpiType;

	/** 考核类型名称 */
	private String typeName;

	/** 年份 */
	@Excel(name = "年份")
	private String year;

	/** 月份 */
	@Excel(name = "月份")
	private String month;

	/** 季度 */
	@Excel(name = "季度")
	private String quarter;

	/** 主表备注 */
	private String kpiRemark;

	/**
	 * 状态（1自由态 2提交态 3审核通过）
	 */
	private Integer status;

	/** 子表id */
	private Long kpiBId;

	/** 评分结果表id */
	private Long kpiResultId;

	/** 供应商 */
	@Excel(name = "供应商")
	private String supplierName;

	/** 供应商id */
	private Long supplierId;

	/** 二级供应商 */
	@Excel(name = "供应商")
	private String kpiSupplierName;

	/** 二级供应商id */
	private Long kpiSupplierId;

	/** 分数 */
	@Excel(name = "分数")
	private Long score;

	/** 得分依据 */
	@Excel(name = "得分依据")
	private String basis;

	/** 供应商部门 */
	private String supplierDept;

	/** 联系人 */
	private String linkName;

	public String getKpiSupplierName() {
		return kpiSupplierName;
	}

	public void setKpiSupplierName(String kpiSupplierName) {
		this.kpiSupplierName = kpiSupplierName;
	}

	public Long getKpiSupplierId() {
		return kpiSupplierId;
	}

	public void setKpiSupplierId(Long kpiSupplierId) {
		this.kpiSupplierId = kpiSupplierId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getSupplierDept() {
		return supplierDept;
	}

	public void setSupplierDept(String supplierDept) {
		this.supplierDept = supplierDept;
	}

	public Long getAssessScore() {
		return assessScore;
	}

	public void setAssessScore(Long assessScore) {
		this.assessScore = assessScore;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getKpiId() {
		return kpiId;
	}

	public void setKpiId(Long kpiId) {
		this.kpiId = kpiId;
	}

	public Integer getKpiType() {
		return kpiType;
	}

	public void setKpiType(Integer kpiType) {
		this.kpiType = kpiType;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getKpiRemark() {
		return kpiRemark;
	}

	public void setKpiRemark(String kpiRemark) {
		this.kpiRemark = kpiRemark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getKpiBId() {
		return kpiBId;
	}

	public void setKpiBId(Long kpiBId) {
		this.kpiBId = kpiBId;
	}

	public Long getKpiResultId() {
		return kpiResultId;
	}

	public void setKpiResultId(Long kpiResultId) {
		this.kpiResultId = kpiResultId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
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
				.append("assessName", getAssessName()).append("assessScore", getAssessScore())
				.append("kpiId", getKpiId()).append("kpiBId", getKpiBId()).append("kpiResultId", getKpiResultId())
				.append("deptName", getDeptName()).append("status", getStatus()).append("year", getYear())
				.append("month", getMonth()).append("quarter", getQuarter()).append("kpiRemark", getKpiRemark())
				.append("supplierDept", getSupplierDept()).append("kpiType", getKpiType())
				.append("supplierName", getSupplierName()).append("supplierId", getSupplierId())
				.append("kpiSupplierName", getKpiSupplierName()).append("kpiSupplierId", getKpiSupplierId())
				.append("score", getScore()).append("basis", getBasis()).append("criteriaName", getCriteriaName())
				.append("deptId", getDeptId()).append("typeName", getTypeName()).toString();
	}
}
