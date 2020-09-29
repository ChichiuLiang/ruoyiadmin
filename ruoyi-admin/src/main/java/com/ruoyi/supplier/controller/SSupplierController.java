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
import com.ruoyi.supplier.domain.SAssess;
import com.ruoyi.supplier.domain.SSupplier;
import com.ruoyi.supplier.service.ISSupplierService;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.service.DictService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商档案Controller
 * 
 * @author Liu Qiyong
 * @date 2020-08-18
 */
@Controller
@RequestMapping("/supplier/supplier")
public class SSupplierController extends BaseController {
	private String prefix = "supplier/supplier";

	@Autowired
	private ISSupplierService sSupplierService;

	@Autowired
	private DictService dictService;

	@RequiresPermissions("supplier:supplier:view")
	@GetMapping()
	public String supplier() {
		return prefix + "/supplier";
	}

	/**
	 * 查询供应商档案列表
	 */
	@RequiresPermissions("supplier:supplier:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SSupplier sSupplier) {
		startPage();
		List<SSupplier> list = sSupplierService.selectSSupplierList(sSupplier);
		List<SysDictData> dicts = dictService.getType("supplier_type");
		String supplierType = "";
		String[] sSuppliers = null;
		for (SSupplier ssp : list) {
			String supplierTypeName = "";
			supplierType = ssp.getSupplierType();
			if (StringUtils.isNotEmpty(supplierType)) {
				sSuppliers = supplierType.split(",");
				for (String s : sSuppliers) {
					for (SysDictData dict : dicts) {
						if (dict.getDictValue().equals(s)) {
							supplierTypeName += dict.getDictLabel() + ",";
							break;
						}
					}
				}
			}
			if ("".equals(supplierTypeName)) {
				continue;
			}
			ssp.setSupplierTypeName(supplierTypeName.substring(0, supplierTypeName.length() - 1));
		}
		return getDataTable(list);
	}

	/**
	 * 导出供应商档案列表
	 */
	@RequiresPermissions("supplier:supplier:export")
	@Log(title = "供应商档案", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SSupplier sSupplier) {
		List<SSupplier> list = sSupplierService.selectSSupplierList(sSupplier);
		ExcelUtil<SSupplier> util = new ExcelUtil<SSupplier>(SSupplier.class);
		return util.exportExcel(list, "supplier");
	}

	/**
	 * 新增供应商档案
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存供应商档案
	 */
	@RequiresPermissions("supplier:supplier:add")
	@Log(title = "供应商档案", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SSupplier sSupplier) {
		sSupplier.setCreateBy(ShiroUtils.getLoginName());
		return toAjax(sSupplierService.insertSSupplier(sSupplier));
	}

	/**
	 * 修改供应商档案
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {

		SSupplier sSupplier = sSupplierService.selectSSupplierById(id);
		List<SysDictData> dicts = dictService.getType("supplier_type");
		for (SysDictData dict : dicts) {
			dict.setFlag(false);
		}
		String supplierType = sSupplier.getSupplierType();
		if (StringUtils.isNotEmpty(supplierType)) {
			String[] supplierTypes = supplierType.split(",");
			for (String s : supplierTypes) {
				for (SysDictData dict : dicts) {
					if (dict.getDictValue().equals(s)) {
						dict.setFlag(true);
						break;
					}
				}
			}
		}
		mmap.put("sSupplier", sSupplier);
		mmap.put("dicts", dicts);
		return prefix + "/edit";
	}

	/**
	 * 修改保存供应商档案
	 */
	@RequiresPermissions("supplier:supplier:edit")
	@Log(title = "供应商档案", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SSupplier sSupplier) {
		sSupplier.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(sSupplierService.updateSSupplier(sSupplier));
	}

	/**
	 * 删除供应商档案
	 */
	@RequiresPermissions("supplier:supplier:remove")
	@Log(title = "供应商档案", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(sSupplierService.deleteSSupplierByIds(ids));
	}

	/**
	 * 删除评估项目
	 */
	@RequiresPermissions("supplier:supplier:remove")
	@Log(title = "供应商档案", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{id}")
	@ResponseBody
	public AjaxResult remove(@PathVariable("id") Long id) {
		if (sSupplierService.checkSupplierExistUse(id)) {
			return AjaxResult.warn("供应商已经被引用,不允许删除");
		}
		return toAjax(sSupplierService.deleteSSupplierById(id));
	}

	/**
	 * 供应商档案状态修改
	 */
	@Log(title = "供应商档案", businessType = BusinessType.UPDATE)
	@RequiresPermissions("supplier:supplier:edit")
	@PostMapping("/changeStatus")
	@ResponseBody
	public AjaxResult changeStatus(SSupplier sSupplier) {
		return toAjax(sSupplierService.changeStatus(sSupplier));
	}
}
