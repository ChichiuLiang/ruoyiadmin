package com.ruoyi.supplier.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.supplier.domain.SAssessDept;
import com.ruoyi.supplier.service.ISAssessDeptService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评估项目和部门对照Controller
 * 
 * @author Liu Qiyong
 * @date 2020-09-24
 */
@Controller
@RequestMapping("/supplier/dept")
public class SAssessDeptController extends BaseController
{
    private String prefix = "supplier/dept";

    @Autowired
    private ISAssessDeptService sAssessDeptService;

    @RequiresPermissions("supplier:dept:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/dept";
    }

    /**
     * 查询评估项目和部门对照列表
     */
    @RequiresPermissions("supplier:dept:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SAssessDept sAssessDept)
    {
        startPage();
        List<SAssessDept> list = sAssessDeptService.selectSAssessDeptList(sAssessDept);
        return getDataTable(list);
    }

    /**
     * 导出评估项目和部门对照列表
     */
    @RequiresPermissions("supplier:dept:export")
    @Log(title = "评估项目和部门对照", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SAssessDept sAssessDept)
    {
        List<SAssessDept> list = sAssessDeptService.selectSAssessDeptList(sAssessDept);
        ExcelUtil<SAssessDept> util = new ExcelUtil<SAssessDept>(SAssessDept.class);
        return util.exportExcel(list, "dept");
    }

    /**
     * 新增评估项目和部门对照
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评估项目和部门对照
     */
    @RequiresPermissions("supplier:dept:add")
    @Log(title = "评估项目和部门对照", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SAssessDept sAssessDept)
    {
        return toAjax(sAssessDeptService.insertSAssessDept(sAssessDept));
    }

    /**
     * 修改评估项目和部门对照
     */
    @GetMapping("/edit/{assessId}")
    public String edit(@PathVariable("assessId") Long assessId, ModelMap mmap)
    {
        SAssessDept sAssessDept = sAssessDeptService.selectSAssessDeptById(assessId);
        mmap.put("sAssessDept", sAssessDept);
        return prefix + "/edit";
    }

    /**
     * 修改保存评估项目和部门对照
     */
    @RequiresPermissions("supplier:dept:edit")
    @Log(title = "评估项目和部门对照", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SAssessDept sAssessDept)
    {
        return toAjax(sAssessDeptService.updateSAssessDept(sAssessDept));
    }

    /**
     * 删除评估项目和部门对照
     */
    @RequiresPermissions("supplier:dept:remove")
    @Log(title = "评估项目和部门对照", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sAssessDeptService.deleteSAssessDeptByIds(ids));
    }
}
