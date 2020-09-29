package com.ruoyi.supplier.mapper;

import java.util.List;
import com.ruoyi.supplier.domain.SAssessDept;

/**
 * 评估项目和部门对照Mapper接口
 * 
 * @author Liu Qiyong
 * @date 2020-09-24
 */
public interface SAssessDeptMapper 
{
    /**
     * 查询评估项目和部门对照
     * 
     * @param assessId 评估项目和部门对照ID
     * @return 评估项目和部门对照
     */
    public SAssessDept selectSAssessDeptById(Long assessId);

    /**
     * 查询评估项目和部门对照列表
     * 
     * @param sAssessDept 评估项目和部门对照
     * @return 评估项目和部门对照集合
     */
    public List<SAssessDept> selectSAssessDeptList(SAssessDept sAssessDept);

    /**
     * 新增评估项目和部门对照
     * 
     * @param sAssessDept 评估项目和部门对照
     * @return 结果
     */
    public int insertSAssessDept(SAssessDept sAssessDept);

    /**
     * 修改评估项目和部门对照
     * 
     * @param sAssessDept 评估项目和部门对照
     * @return 结果
     */
    public int updateSAssessDept(SAssessDept sAssessDept);

    /**
     * 删除评估项目和部门对照
     * 
     * @param assessId 评估项目和部门对照ID
     * @return 结果
     */
    public int deleteSAssessDeptById(Long assessId);

    /**
     * 批量删除评估项目和部门对照
     * 
     * @param assessIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSAssessDeptByIds(String[] assessIds);
}
