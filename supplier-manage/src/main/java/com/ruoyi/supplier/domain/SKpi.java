package com.ruoyi.supplier.domain;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商绩效考评主对象 s_kpi
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
public class SKpi extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** id */
	private Long id;

	/** 考核对象（1美体内衣供应商2包装袋供应商3包装物料供应商4二级供应商5二级供应商自评） */
	private Integer kpiType;

	/** 年份 */
	@Excel(name = "年份")
	private String year;

	/** 月份 */
	@Excel(name = "月份")
	private String month;

	/** 季度 */
	@Excel(name = "季度")
	private String quarter;

	/** 创建部门 */
	private Long deptId;

	/** 备注 */
	private String remark;

	/**
	 * 状态（1自由态 2提交态 3审核通过）
	 */
	private Integer status;

	/**
	 * 评估项目信息
	 */
	private List<SKpiB> kpibs;

	/**
	 * 供应商id（单个供应商绩效考评）
	 */
	private Long supplierId;

	/** 联系人 */
	private String linkName;

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public List<SKpiB> getKpibs() {
		return kpibs;
	}

	public void setKpibs(List<SKpiB> kpibs) {
		this.kpibs = kpibs;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setKpiType(Integer kpiType) {
		this.kpiType = kpiType;
	}

	public Integer getKpiType() {
		return kpiType;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMonth() {
		return month;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getDeptId() {
		return deptId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("kpiType", getKpiType()).append("year", getYear()).append("month", getMonth())
				.append("quarter", getQuarter()).append("deptId", getDeptId()).append("createBy", getCreateBy())
				.append("createTime", getCreateTime()).append("updateBy", getUpdateBy())
				.append("updateTime", getUpdateTime()).append("delFlag", getDelFlag()).append("remark", getRemark())
				.append("status", getStatus()).toString();
	}
}
