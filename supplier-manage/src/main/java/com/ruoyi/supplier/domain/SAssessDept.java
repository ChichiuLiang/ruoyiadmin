package com.ruoyi.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评估项目和部门对照对象 s_assess_dept
 * 
 * @author Liu Qiyong
 * @date 2020-09-24
 */
public class SAssessDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评估项目id */
    @Excel(name = "评估项目id")
    private Long assessId;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    public void setAssessId(Long assessId) 
    {
        this.assessId = assessId;
    }

    public Long getAssessId() 
    {
        return assessId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("assessId", getAssessId())
            .append("deptId", getDeptId())
            .toString();
    }
}
