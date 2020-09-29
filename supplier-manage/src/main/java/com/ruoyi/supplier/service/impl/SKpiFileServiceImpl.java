package com.ruoyi.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.supplier.mapper.SKpiFileMapper;
import com.ruoyi.supplier.domain.SKpi;
import com.ruoyi.supplier.domain.SKpiFile;
import com.ruoyi.supplier.service.ISKpiFileService;
import com.ruoyi.common.core.text.Convert;

/**
 * 供应商绩效考评上传附件Service业务层处理
 * 
 * @author Liu Qiyong
 * @date 2020-09-03
 */
@Service
public class SKpiFileServiceImpl implements ISKpiFileService {
	@Autowired
	private SKpiFileMapper sKpiFileMapper;

	/**
	 * 查询供应商绩效考评上传附件
	 * 
	 * @param id
	 *            供应商绩效考评上传附件ID
	 * @return 供应商绩效考评上传附件
	 */
	@Override
	public SKpiFile selectSKpiFileById(Long id) {
		return sKpiFileMapper.selectSKpiFileById(id);
	}

	/**
	 * 查询供应商绩效考评上传附件列表
	 * 
	 * @param sKpiFile
	 *            供应商绩效考评上传附件
	 * @return 供应商绩效考评上传附件
	 */
	@Override
	public List<SKpiFile> selectSKpiFileList(SKpiFile sKpiFile) {
		return sKpiFileMapper.selectSKpiFileList(sKpiFile);
	}

	/**
	 * 根据绩效主报id查询上传附件列表
	 * 
	 * @param kpiId
	 * @return 上传附件集合
	 */
	@Override
	public List<SKpiFile> selectSKpiFileListByKpiId(Long kpiId) {
		return sKpiFileMapper.selectSKpiFileListByKpiId(kpiId);
	}
	
	/**
	 * 查询上传附件列表
	 * 
	 * @param sKpiList
	 * @return 上传附件集合
	 */
	@Override
	public List<SKpiFile> selectAllSKpiFileList(List<SKpi> sKpiList){
		return sKpiFileMapper.selectAllSKpiFileList(sKpiList);
	}

	/**
	 * 新增供应商绩效考评上传附件
	 * 
	 * @param sKpiFile
	 *            供应商绩效考评上传附件
	 * @return 结果
	 */
	@Override
	public int insertSKpiFile(SKpiFile sKpiFile) {
		return sKpiFileMapper.insertSKpiFile(sKpiFile);
	}

	/**
	 * 批量插入附件表
	 * 
	 * @param sKpiFileList
	 *            供应商绩效考评上传附件集合
	 * @return 结果
	 */
	public int batchInsertSKpiFile(List<SKpiFile> sKpiFileList) {
		return sKpiFileMapper.batchInsertSKpiFile(sKpiFileList);
	}

	/**
	 * 修改供应商绩效考评上传附件
	 * 
	 * @param sKpiFile
	 *            供应商绩效考评上传附件
	 * @return 结果
	 */
	@Override
	public int updateSKpiFile(SKpiFile sKpiFile) {
		return sKpiFileMapper.updateSKpiFile(sKpiFile);
	}

	/**
	 * 删除供应商绩效考评上传附件对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteSKpiFileByIds(String ids) {
		return sKpiFileMapper.deleteSKpiFileByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除供应商绩效考评上传附件信息
	 * 
	 * @param id
	 *            供应商绩效考评上传附件ID
	 * @return 结果
	 */
	@Override
	public int deleteSKpiFileById(Long id) {
		return sKpiFileMapper.deleteSKpiFileById(id);
	}
}
