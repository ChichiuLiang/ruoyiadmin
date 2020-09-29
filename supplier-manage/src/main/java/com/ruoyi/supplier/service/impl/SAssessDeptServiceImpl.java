package com.ruoyi.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.supplier.mapper.SAssessDeptMapper;
import com.ruoyi.supplier.domain.SAssessDept;
import com.ruoyi.supplier.service.ISAssessDeptService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评估项目和部门对照Service业务层处理
 * 
 * @author Liu Qiyong
 * @date 2020-09-24
 */
@Service
public class SAssessDeptServiceImpl implements ISAssessDeptService 
{
    @Autowired
    private SAssessDeptMapper sAssessDeptMapper;

    /**
     * 查询评估项目和部门对照
     * 
     * @param assessId 评估项目和部门对照ID
     * @return 评估项目和部门对照
     */
    @Override
    public SAssessDept selectSAssessDeptById(Long assessId)
    {
        return sAssessDeptMapper.selectSAssessDeptById(assessId);
    }

    /**
     * 查询评估项目和部门对照列表
     * 
     * @param sAssessDept 评估项目和部门对照
     * @return 评估项目和部门对照
     */
    @Override
    public List<SAssessDept> selectSAssessDeptList(SAssessDept sAssessDept)
    {
        return sAssessDeptMapper.selectSAssessDeptList(sAssessDept);
    }

    /**
     * 新增评估项目和部门对照
     * 
     * @param sAssessDept 评估项目和部门对照
     * @return 结果
     */
    @Override
    public int insertSAssessDept(SAssessDept sAssessDept)
    {
        return sAssessDeptMapper.insertSAssessDept(sAssessDept);
    }
 
    /**
     * 修改评估项目和部门对照
     * 
     * @param sAssessDept 评估项目和部门对照
     * @return 结果
     */
    @Override
    public int updateSAssessDept(SAssessDept sAssessDept)
    {
        return sAssessDeptMapper.updateSAssessDept(sAssessDept);
    }

    /**
     * 删除评估项目和部门对照对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSAssessDeptByIds(String ids)
    {
        return sAssessDeptMapper.deleteSAssessDeptByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评估项目和部门对照信息
     * 
     * @param assessId 评估项目和部门对照ID
     * @return 结果
     */
    @Override
    public int deleteSAssessDeptById(Long assessId)
    {
        return sAssessDeptMapper.deleteSAssessDeptById(assessId);
    }
}
