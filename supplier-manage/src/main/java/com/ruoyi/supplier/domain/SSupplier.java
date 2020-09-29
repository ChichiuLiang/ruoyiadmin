package com.ruoyi.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商档案对象 s_supplier
 * 
 * @author Liu Qiyong
 * @date 2020-08-18
 */
public class SSupplier extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** id */
	private Long id;

	/** 上级id */
	@Excel(name = "上级id")
	private Long parentId;

	/** 供应商名称 */
	@Excel(name = "供应商名称")
	private String supplierName;

	/** 法定代表人 */
	@Excel(name = "法定代表人")
	private String legalName;

	/** 联系地址 */
	@Excel(name = "联系地址")
	private String address;

	/** 联系电话 */
	@Excel(name = "联系电话")
	private String linkPhone;

	/** 供货产品 */
	@Excel(name = "供货产品")
	private String product;

	/** 合作时间 */
	@Excel(name = "合作时间")
	private String cooperateTime;

	/** 员工人数 */
	@Excel(name = "员工人数")
	private Long employeesNum;

	/** 主要联系人 */
	@Excel(name = "主要联系人")
	private String linkPerson;

	/** 机器设备 */
	@Excel(name = "机器设备")
	private String device;

	/** 联系人职务 */
	@Excel(name = "联系人职务")
	private String post;

	/** 生产线数量 */
	@Excel(name = "生产线数量")
	private Long lineNum;

	/** 联系方式 */
	@Excel(name = "联系方式")
	private String contactType;

	/** 月产能 */
	@Excel(name = "月产能")
	private Long capacity;

	/** 技术人员数量 */
	@Excel(name = "技术人员数量")
	private Long artisanNum;

	/** 质检人数 */
	@Excel(name = "质检人数")
	private Long qualityNum;

	/** 归属部门id */
	@Excel(name = "归属部门id")
	private Long deptId;

	/** 归属部门名称 */
	@Excel(name = "关联部门id")
	private String deptName;

	/** 供应商类型 */
	private String supplierType;

	/** 供应商类型中文名称 */
	private String supplierTypeName;

	/**
	 * 状态（0正常 1停用）
	 */
	@Excel(name = "状态", readConverterExp = "0=正常,1=停用")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getSupplierTypeName() {
		return supplierTypeName;
	}

	public void setSupplierTypeName(String supplierTypeName) {
		this.supplierTypeName = supplierTypeName;
	}

	public String getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProduct() {
		return product;
	}

	public void setCooperateTime(String cooperateTime) {
		this.cooperateTime = cooperateTime;
	}

	public String getCooperateTime() {
		return cooperateTime;
	}

	public void setEmployeesNum(Long employeesNum) {
		this.employeesNum = employeesNum;
	}

	public Long getEmployeesNum() {
		return employeesNum;
	}

	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}

	public String getLinkPerson() {
		return linkPerson;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDevice() {
		return device;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPost() {
		return post;
	}

	public void setLineNum(Long lineNum) {
		this.lineNum = lineNum;
	}

	public Long getLineNum() {
		return lineNum;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactType() {
		return contactType;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setArtisanNum(Long artisanNum) {
		this.artisanNum = artisanNum;
	}

	public Long getArtisanNum() {
		return artisanNum;
	}

	public void setQualityNum(Long qualityNum) {
		this.qualityNum = qualityNum;
	}

	public Long getQualityNum() {
		return qualityNum;
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
				.append("parentId", getParentId()).append("supplierName", getSupplierName())
				.append("legalName", getLegalName()).append("address", getAddress()).append("linkPhone", getLinkPhone())
				.append("product", getProduct()).append("cooperateTime", getCooperateTime())
				.append("employeesNum", getEmployeesNum()).append("linkPerson", getLinkPerson())
				.append("device", getDevice()).append("post", getPost()).append("lineNum", getLineNum())
				.append("contactType", getContactType()).append("capacity", getCapacity())
				.append("artisanNum", getArtisanNum()).append("qualityNum", getQualityNum())
				.append("deptId", getDeptId()).append("delFlag", getDelFlag()).append("createBy", getCreateBy())
				.append("createTime", getCreateTime()).append("updateBy", getUpdateBy())
				.append("updateTime", getUpdateTime()).append("supplierType", getSupplierType()).toString();
	}
}
