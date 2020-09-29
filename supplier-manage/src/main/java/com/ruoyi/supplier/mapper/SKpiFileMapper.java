package com.ruoyi.supplier.mapper;

import java.util.List;

import com.ruoyi.supplier.domain.SKpi;
import com.ruoyi.supplier.domain.SKpiFile;

/**
 * 供应商绩效考评上传附件Mapper接口
 * 
 * @author Liu Qiyong
 * @date 2020-09-03
 */
public interface SKpiFileMapper {
	/**
	 * 查询供应商绩效考评上传附件
	 * 
	 * @param id
	 *            供应商绩效考评上传附件ID
	 * @return 供应商绩效考评上传附件
	 */
	public SKpiFile selectSKpiFileById(Long id);

	/**
	 * 查询供应商绩效考评上传附件列表
	 * 
	 * @param sKpiFile
	 *            供应商绩效考评上传附件
	 * @return 供应商绩效考评上传附件集合
	 */
	public List<SKpiFile> selectSKpiFileList(SKpiFile sKpiFile);

	/**
	 * 根据绩效主报id查询上传附件列表
	 * 
	 * @param kpiId
	 * @return 上传附件集合
	 */
	public List<SKpiFile> selectSKpiFileListByKpiId(Long kpiId);
	
	/**
	 * 查询上传附件列表
	 * 
	 * @param sKpiList
	 * @return 上传附件集合
	 */
	public List<SKpiFile> selectAllSKpiFileList(List<SKpi> sKpiList);

	/**
	 * 新增供应商绩效考评上传附件
	 * 
	 * @param sKpiFile
	 *            供应商绩效考评上传附件
	 * @return 结果
	 */
	public int insertSKpiFile(SKpiFile sKpiFile);

	/**
	 * 批量插入附件表
	 * 
	 * @param sKpiFileList
	 *            供应商绩效考评上传附件集合
	 * @return 结果
	 */
	public int batchInsertSKpiFile(List<SKpiFile> sKpiFileList);

	/**
	 * 修改供应商绩效考评上传附件
	 * 
	 * @param sKpiFile
	 *            供应商绩效考评上传附件
	 * @return 结果
	 */
	public int updateSKpiFile(SKpiFile sKpiFile);

	/**
	 * 逻辑删除上传附件
	 * 
	 * @param kpiId
	 *            主表id
	 * @return 结果
	 */
	public int updateSKpiFileByKpiId(Long kpiId);

	/**
	 * 删除供应商绩效考评上传附件
	 * 
	 * @param id
	 *            供应商绩效考评上传附件ID
	 * @return 结果
	 */
	public int deleteSKpiFileById(Long id);

	/**
	 * 批量删除供应商绩效考评上传附件
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSKpiFileByIds(String[] ids);
}
