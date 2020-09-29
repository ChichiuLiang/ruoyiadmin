package com.ruoyi.supplier.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.supplier.domain.SKpiSort;
import com.ruoyi.supplier.service.ISKpiSortService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * KPI指标分类Controller
 *
 * @author Liu Qiyong
 * @date 2020-08-03
 */
@Controller
@RequestMapping("/supplier/sort")
public class SKpiSortController extends BaseController {
    private String prefix = "supplier/sort";

    @Autowired
    private ISKpiSortService sKpiSortService;

    @RequiresPermissions("supplier:sort:view")
    @GetMapping()
    public String sort() {
        return prefix + "/sort";
    }

    /**
     * 查询KPI指标分类列表
     */
    @RequiresPermissions("supplier:sort:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SKpiSort> list(SKpiSort sKpiSort) {
        List<SKpiSort> list = sKpiSortService.selectSKpiSortList(sKpiSort);
        return list;
    }

    /**
     * 导出KPI指标分类列表
     */
    @RequiresPermissions("supplier:sort:export")
    @Log(title = "KPI指标分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SKpiSort sKpiSort) {
        List<SKpiSort> list = sKpiSortService.selectSKpiSortList(sKpiSort);
        ExcelUtil<SKpiSort> util = new ExcelUtil<SKpiSort>(SKpiSort.class);
        return util.exportExcel(list, "sort");
    }

    /**
     * 新增KPI指标分类
     */
    @GetMapping(value = {"/add/", "/add/{parentId}"})
    public String add(@PathVariable(value = "parentId", required = false) Long parentId, ModelMap mmap) {
        if (null != parentId)
            mmap.put("sort", sKpiSortService.selectSKpiSortById(parentId));
        return prefix + "/add";
    }

    /**
     * 选择KPI指标分类树
     */
    @GetMapping(value = {"/selectSortTree/{id}","/selectSortTree/{id}/{excludeId}", "/selectSortTree/"})
    public String selectSortTree(@PathVariable(value = "id", required = false) Long id,
                                 @PathVariable(value = "excludeId", required = false) String excludeId, ModelMap mmap) {
        if (null != id) {
            mmap.put("sort", sKpiSortService.selectSKpiSortById(id));
            mmap.put("excludeId", excludeId);
        }
        return prefix + "/tree";
    }

    /**
     * 加载KPI分类树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = sKpiSortService.selectSortTree();
        return ztrees;
    }

    /**
     * 加载KPI分类列表树（排除下级）
     */
    @GetMapping("/treeData/{excludeId}")
    @ResponseBody
    public List<Ztree> treeDataExcludeChild(@PathVariable(value = "excludeId", required = false) Long excludeId) {
        SKpiSort sort = new SKpiSort();
        sort.setId(excludeId);
        List<Ztree> ztrees = sKpiSortService.selectSortTreeExcludeChild(sort);
        return ztrees;
    }


    /**
     * 新增保存KPI指标分类
     */
    @RequiresPermissions("supplier:sort:add")
    @Log(title = "KPI指标分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SKpiSort sKpiSort) {
        sKpiSort.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(sKpiSortService.insertSKpiSort(sKpiSort));
    }

    /**
     * 修改KPI指标分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        SKpiSort sKpiSort = sKpiSortService.selectSKpiSortById(id);
        mmap.put("sKpiSort", sKpiSort);
        return prefix + "/edit";
    }

    /**
     * 修改保存KPI指标分类
     */
    @RequiresPermissions("supplier:sort:edit")
    @Log(title = "KPI指标分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SKpiSort sKpiSort) {
        sKpiSort.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(sKpiSortService.updateSKpiSort(sKpiSort));
    }

    /**
     * 删除KPI指标分类
     */
    @RequiresPermissions("supplier:sort:remove")
    @Log(title = "KPI指标分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id) {
        if (sKpiSortService.selectSortCount(id) > 0) {
            return AjaxResult.warn("存在下级类目,不允许删除");
        }
        if (sKpiSortService.checkSortExistAssess(id))
        {
            return AjaxResult.warn("KPI指标存在评估项目,不允许删除");
        }
        return toAjax(sKpiSortService.deleteSKpiSortById(id));
    }

}
