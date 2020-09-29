package com.ruoyi.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商绩效考评上传附件对象 s_kpi_file
 * 
 * @author Liu Qiyong
 * @date 2020-09-03
 */
public class SKpiFile extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** id */
	private Long id;

	/** 主表id */
	@Excel(name = "主表id")
	private Long kpiId;

	/** 文件名 */
	@Excel(name = "文件名")
	private String fileName;

	/** 文件路径 */
	@Excel(name = "文件路径")
	private String filePath;

	/** 文件大小 */
	@Excel(name = "文件大小")
	private Long fileSize;

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
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

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("kpiId", getKpiId()).append("fileName", getFileName()).append("filePath", getFilePath())
				.append("delFlag", getDelFlag()).toString();
	}
}
