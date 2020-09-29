package com.ruoyi.supplier.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;

/**
 * KPI指标分类对象 s_kpi_sort
 *
 * @author Liu Qiyong
 * @date 2020-08-03
 */
public class SKpiSort extends TreeEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 分类名称
	 */
	@Excel(name = "分类名称")
	private String sortName;

	/**
	 * 权重
	 */
	@Excel(name = "权重")
	private String weight;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	@NotBlank(message = "分类名称不能为空")
	public String getSortName() {
		return sortName;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("parentId", getParentId()).append("sortName", getSortName()).append("weight", getWeight())
				.append("createBy", getCreateBy()).append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("delFlag", getDelFlag())
				.append("orderNum", getOrderNum()).toString();
	}
}
