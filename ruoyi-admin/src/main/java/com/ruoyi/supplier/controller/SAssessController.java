package com.ruoyi.supplier.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.supplier.domain.SAssess;
import com.ruoyi.supplier.service.ISAssessService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评估项目Controller
 *
 * @author Liu Qiyong
 * @date 2020-08-03
 */
@Controller
@RequestMapping("/supplier/assess")
public class SAssessController extends BaseController {
    private String prefix = "supplier/assess";

    @Autowired
    private ISAssessService sAssessService;

    @RequiresPermissions("supplier:assess:view")
    @GetMapping()
    public String assess() {
        return prefix + "/assess";
    }

    /**
     * 查询评估项目列表
     */
    @RequiresPermissions("supplier:assess:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SAssess sAssess) {
        startPage();
        List<SAssess> list = sAssessService.selectSAssessList(sAssess);
        return getDataTable(list);
    }

    /**
     * 导出评估项目列表
     */
    @RequiresPermissions("supplier:assess:export")
    @Log(title = "评估项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SAssess sAssess) {
        List<SAssess> list = sAssessService.selectSAssessList(sAssess);
        ExcelUtil<SAssess> util = new ExcelUtil<SAssess>(SAssess.class);
        return util.exportExcel(list, "assess");
    }

    /**
     * 新增评估项目
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存评估项目
     */
    @RequiresPermissions("supplier:assess:add")
    @Log(title = "评估项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SAssess sAssess) {
        sAssess.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(sAssessService.insertSAssess(sAssess));
    }

    /**
     * 修改评估项目
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        SAssess sAssess = sAssessService.selectSAssessById(id);
        mmap.put("sAssess", sAssess);
        return prefix + "/edit";
    }

    /**
     * 修改保存评估项目
     */
    @RequiresPermissions("supplier:assess:edit")
    @Log(title = "评估项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SAssess sAssess) {
        sAssess.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(sAssessService.updateSAssess(sAssess));
    }

    /**
     * 删除评估项目
     */
    @RequiresPermissions("supplier:assess:remove")
    @Log(title = "评估项目", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id")Long id) {
    	if(sAssessService.checkAssessExistUse(id)){
    		return AjaxResult.warn("评估项目已经被引用,不允许删除");
    	}
        return toAjax(sAssessService.deleteSAssessById(id));
    }

    /**
     * 评估项目状态修改
     */
    @Log(title = "评估项目管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("supplier:assess:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(SAssess sAssess) {
        return toAjax(sAssessService.changeStatus(sAssess));
    }
}
