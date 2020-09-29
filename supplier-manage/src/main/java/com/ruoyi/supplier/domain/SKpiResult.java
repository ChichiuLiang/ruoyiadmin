package com.ruoyi.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商绩效考评结果对象 s_kpi_result
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
public class SKpiResult extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** id */
	private Long id;

	/** 考评子表id */
	private Long kpiBId;

	/** 考评主表id */
	private Long kpiId;

	/** 供应商id */
	@Excel(name = "供应商id")
	private Long supplierId;

	/** 供应商名称 */
	@Excel(name = "供应商名称")
	private String supplierName;

	/** 分数 */
	@Excel(name = "分数")
	private Long score;

	/** 得分依据 */
	@Excel(name = "得分依据")
	private String basis;

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Long getKpiId() {
		return kpiId;
	}

	public void setKpiId(Long kpiId) {
		this.kpiId = kpiId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setKpiBId(Long kpiBId) {
		this.kpiBId = kpiBId;
	}

	public Long getKpiBId() {
		return kpiBId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getScore() {
		return score;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getBasis() {
		return basis;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("kpiBId", getKpiBId()).append("supplierId", getSupplierId()).append("score", getScore())
				.append("basis", getBasis()).append("delFlag", getDelFlag()).append("kpiId", getKpiId()).toString();
	}
}
