package com.ruoyi.supplier.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.supplier.domain.SKpi;
import com.ruoyi.supplier.domain.SKpiB;
import com.ruoyi.supplier.domain.SKpiFile;
import com.ruoyi.supplier.domain.SKpiResult;
import com.ruoyi.supplier.domain.SSupplier;
import com.ruoyi.supplier.domain.VAssessinfo;
import com.ruoyi.supplier.domain.VKpiInfo;
import com.ruoyi.supplier.service.ISAssessService;
import com.ruoyi.supplier.service.ISKpiBService;
import com.ruoyi.supplier.service.ISKpiFileService;
import com.ruoyi.supplier.service.ISKpiResultService;
import com.ruoyi.supplier.service.ISKpiService;
import com.ruoyi.supplier.service.ISSupplierService;
import com.ruoyi.system.service.ISysConfigService;

/**
 * 供应商绩效考评主Controller
 * 
 * @author Liu Qiyong
 * @date 2020-08-26
 */
@Controller
@RequestMapping("/supplier/kpi")
public class SKpiController extends BaseController {
	@Autowired
	private ISKpiService sKpiService;

	@Autowired
	private ISKpiBService sKpiBService;

	@Autowired
	private ISKpiResultService sKpiResultService;

	@Autowired
	private ISSupplierService isSupplierService;

	@Autowired
	private ISKpiFileService isKpiFileService;

	@Autowired
	private ISAssessService isAssessService;
	
	@Autowired
    private ISysConfigService configService;
	
	private String prefix = "supplier/kpi";

	@RequiresPermissions(value = { "supplier:kpi:view", "supplier:kpiBag:view", "supplier:kpiMatter:view",
			"supplier:kpiCustom:view", "supplier:kpiSelf:view", "supplier:kpi:report" }, logical = Logical.OR)
	@GetMapping("/{type}")
	public String kpi(@PathVariable("type") int type, SSupplier sSupplier, ModelMap mmap) {
		String returnValue = "";
		List<SSupplier> supplierList = new ArrayList<SSupplier>();
		switch (type) {
		case 1:// 美体内衣工厂供应商
			returnValue = prefix + "/kpi";
			break;
		case 2:// 美体内衣包装袋供应商
			returnValue = prefix + "/kpi_bag";
			break;
		case 3:// 美体内衣包装物料供应商
			returnValue = prefix + "/kpi_matter";
			break;
		case 4:// 二级供应商绩效考评
			supplierList = isSupplierService.selectSSupplierList(sSupplier);
			mmap.put("supplierList", supplierList);
			returnValue = prefix + "/kpi_custom";
			break;
		case 5:// 二级供应商绩效自评
			supplierList = isSupplierService.selectSSupplierList(sSupplier);
			mmap.put("supplierList", supplierList);
			returnValue = prefix + "/kpi_self";
			break;
		case 6:// 供应商绩效考核报表
			List<VKpiInfo> vKpiInfoList = new ArrayList<VKpiInfo>();
			vKpiInfoList = sKpiService.selectKpiType(new SKpi());
			mmap.put("vKpiInfoList", vKpiInfoList);
			returnValue = prefix + "/report";
			break;
		default:
			break;
		}
		return returnValue;
	}

	/**
	 * 查询供应商绩效考评主列表
	 */
	@RequiresPermissions(value = { "supplier:kpi:list", "supplier:kpiBag:list", "supplier:kpiMatter:list",
			"supplier:kpiCustom:list", "supplier:kpiSelf:list" }, logical = Logical.OR)
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SKpi sKpi) {
		startPage();
		List<SKpi> list = sKpiService.selectSKpiList(sKpi);
		return getDataTable(list);
	}

	/**
	 * 查询供应商绩效考评报表
	 */
	@RequiresPermissions("supplier:kpiReport:list")
	@PostMapping("/reportList")
	@ResponseBody
	public TableDataInfo reportList(SKpi sKpi) {
		startPage();
		List<VKpiInfo> list = sKpiService.selectVKpiList(sKpi);
		return getDataTable(list);
	}

	/**
	 * 查询供应商绩效考评结果列表
	 */
	@RequiresPermissions(value = { "supplier:kpi:list", "supplier:kpiBag:list", "supplier:kpiMatter:list",
			"supplier:kpiCustom:list", "supplier:kpiSelf:list" }, logical = Logical.OR)
	@PostMapping("/childlist")
	@ResponseBody
	public TableDataInfo childlist(Long kpiId) {
		List<Map<String, Object>> rstList = new ArrayList<Map<String, Object>>();
		List<SKpiB> sKpiBList = sKpiBService.selectSKpiBByKpiId(kpiId);
		List<SKpiResult> sKpiResultList = sKpiResultService.selectSKpiResultByKpiId(kpiId);
		for (SKpiB sKpiB : sKpiBList) {
			Map<String, Object> eachMap = new HashMap<String, Object>();
			eachMap.put("assessId", sKpiB.getAssessId());
			eachMap.put("twoSortName", sKpiB.getTwoSortName());
			eachMap.put("threeSortName", sKpiB.getThreeSortName());
			eachMap.put("assessName", sKpiB.getAssessName());
			eachMap.put("score", sKpiB.getScore());
			eachMap.put("criteriaName", sKpiB.getCriteriaName());
			eachMap.put("remark", sKpiB.getRemark());
			eachMap.put("supplierDept", sKpiB.getSupplierDept());
			eachMap.put("scoreValue", sKpiB.getScoreValue());
			int i = 0;
			for (SKpiResult sKpiResult : sKpiResultList) {
				if (sKpiB.getId().equals(sKpiResult.getKpiBId())) {
					eachMap.put("score" + i, sKpiResult.getScore());
					eachMap.put("basis" + i, sKpiResult.getBasis());
					i++;
				}
			}
			rstList.add(eachMap);
		}

		return getDataTable(rstList);
	}

	/**
	 * 查询该部门关联的评估项目列表
	 */
	@GetMapping("/getAssessListByDeptId/{type}")
	@ResponseBody
	public TableDataInfo getAssessListByDeptId(@PathVariable("type") int type) {
		VAssessinfo vAssessinfo = new VAssessinfo();
		vAssessinfo.setDeptId(ShiroUtils.getSysUser().getDeptId());
		switch (type) {
		case 1: // 美体内衣工厂供应商
			vAssessinfo.setOneSortId(Long.valueOf(configService.selectConfigByKey("kpi.id1")));
			break;
		case 2:// 美体内衣包装袋供应商
			vAssessinfo.setOneSortId(Long.valueOf(configService.selectConfigByKey("kpi.id2")));
			break;
		case 3:// 美体内衣包装物料供应商
			vAssessinfo.setOneSortId(Long.valueOf(configService.selectConfigByKey("kpi.id3")));
			break;
		case 4:// 二级供应商绩效考评
			vAssessinfo.setOneSortId(Long.valueOf(configService.selectConfigByKey("kpi.id4")));
			break;
		case 5:// 二级供应商绩效自评
			vAssessinfo.setOneSortId(Long.valueOf(configService.selectConfigByKey("kpi.id5")));
			break;
		default:
			break;
		}

		List<VAssessinfo> list = isAssessService.selectVAssessinfoList(vAssessinfo);
		return getDataTable(list);
	}

	/**
	 * 查询供应商绩效考评结果列表
	 */
	@RequiresPermissions("supplier:kpiReport:list")
	@PostMapping("/reportChildlist")
	@ResponseBody
	public TableDataInfo reportChildlist(VKpiInfo vKpiInfo) {
		List<Map<String, Object>> rstList = new ArrayList<Map<String, Object>>();
		List<VKpiInfo> vKpiInfoList = sKpiService.selectVKpiInfoList(vKpiInfo);
		List<String> list = new ArrayList<String>();
		Map<String, Object> eachMap = new HashMap<String, Object>();
		int i = 0;
		for (VKpiInfo vInfo : vKpiInfoList) {
			String flag = vInfo.getAssessId() + "" + vInfo.getDeptId();
			if (!list.contains(flag)) {
				if (null != eachMap && eachMap.size() > 0)
					rstList.add(eachMap);
				i = 0;
				eachMap = new HashMap<String, Object>();
				eachMap.put("assessId", vInfo.getAssessId());
				eachMap.put("twoSortName", vInfo.getTwoSortName());
				eachMap.put("threeSortName", vInfo.getThreeSortName());
				eachMap.put("assessName", vInfo.getAssessName());
				eachMap.put("assessScore", vInfo.getAssessScore());
				eachMap.put("criteriaName", vInfo.getCriteriaName());
				eachMap.put("deptName", vInfo.getDeptName());
				eachMap.put("remark", vInfo.getRemark());
				eachMap.put("supplierDept", vInfo.getSupplierDept());
				eachMap.put("score" + i, vInfo.getScore());
				eachMap.put("basis" + i, vInfo.getBasis());

				list.add(flag);
			} else {
				eachMap.put("score" + i, vInfo.getScore());
				eachMap.put("basis" + i, vInfo.getBasis());
			}
			i++;
		}

		return getDataTable(rstList);
	}

	/**
	 * 查询供应商，动态展示列
	 */
	@GetMapping("/getSupplier/{type}")
	@ResponseBody
	public Map<String, Object> getSupplier(@PathVariable("type") int type) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		SSupplier sSupplier = new SSupplier();
		switch (type) { //供应商类型
		case 1: // 一级供应商
			sSupplier.setSupplierType("1");
			break;
		case 2:// 包装袋供应商
			sSupplier.setSupplierType("3");
			break;
		case 3:// 包装物料供应商
			sSupplier.setSupplierType("4");
			break;
		default:
			break;
		}

		List<SSupplier> ssupplierList = isSupplierService.selectSSupplierListByType(sSupplier);
		for (int i = 0; i < ssupplierList.size(); i++) {
			SSupplier ss = ssupplierList.get(i);
			map.put(ss.getId().toString() + "," + i, ss.getSupplierName());
		}

		return map;
	}
	
	/**
	 * 根据kpiId查询供应商，动态展示列
	 */
	@GetMapping("/getSupplierByKpiId/{kpiId}")
	@ResponseBody
	public Map<String, Object> getSupplierByKpiId(@PathVariable("kpiId") Long kpiId) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

		List<SSupplier> ssupplierList = isSupplierService.getSupplierListByKpiId(kpiId);
		for (int i = 0; i < ssupplierList.size(); i++) {
			SSupplier ss = ssupplierList.get(i);
			map.put(ss.getId().toString() + "," + i, ss.getSupplierName());
		}

		return map;
	}
	
	/**
	 * 根据考核类型、年度、季度查询供应商，动态展示列
	 */
	@PostMapping("/getSupplierBySKpi")
	@ResponseBody
	public Map<String, Object> getSupplierBySKpi(@RequestBody VKpiInfo vKpiInfo) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

		List<SSupplier> ssupplierList = isSupplierService.getSupplierListBySKpi(vKpiInfo);
		for (int i = 0; i < ssupplierList.size(); i++) {
			SSupplier ss = ssupplierList.get(i);
			map.put(ss.getId().toString() + "," + i, ss.getSupplierName());
		}

		return map;
	}

	/**
	 * 导出供应商绩效考评主列表
	 */
	@RequiresPermissions("supplier:kpi:export")
	@Log(title = "供应商绩效考评", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SKpi sKpi) {
		List<SKpi> list = sKpiService.selectSKpiList(sKpi);
		ExcelUtil<SKpi> util = new ExcelUtil<SKpi>(SKpi.class);
		return util.exportExcel(list, "kpi");
	}

	/**
	 * 新增供应商绩效考评主
	 */
	@GetMapping("/add/{type}")
	public String add(@PathVariable("type") int type, SSupplier sSupplier, ModelMap mmap) {
		String returnValue = "";
		List<SSupplier> supplierList = new ArrayList<SSupplier>();
		switch (type) {
		case 1:// 美体内衣工厂供应商
			returnValue = prefix + "/add";
			break;
		case 2:// 美体内衣包装袋供应商
			returnValue = prefix + "/add_bag";
			break;
		case 3:// 美体内衣包装物料供应商
			returnValue = prefix + "/add_matter";
			break;
		case 4:// 二级供应商
			supplierList = isSupplierService.selectSSupplierList(sSupplier);
			mmap.put("supplierList", supplierList);
			returnValue = prefix + "/add_custom";
			break;
		case 5:// 二级供应商自评
			supplierList = isSupplierService.selectSSupplierList(sSupplier);
			mmap.put("supplierList", supplierList);
			returnValue = prefix + "/add_self";
			break;
		default:
			break;
		}
		return returnValue;
	}

	/**
	 * 新增保存供应商绩效考评主
	 */
	@RequiresPermissions(value = { "supplier:kpi:add", "supplier:kpiBag:add", "supplier:kpiMatter:add",
			"supplier:kpiCustom:add", "supplier:kpiSelf:add" }, logical = Logical.OR)
	@Log(title = "供应商绩效考评", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SKpi sKpi) {
		if(sKpiService.checkSKpiExist(sKpi)){
    		return AjaxResult.warn("该年度季度的绩效考核信息已经存在，不能重复新增！");
    	}
		sKpi.setCreateBy(ShiroUtils.getLoginName());
		return toAjax(sKpiService.insertSKpi(sKpi));
	}

	/**
	 * 修改供应商绩效考评主
	 */
	@GetMapping("/edit/{type}/{id}")
	public String edit(@PathVariable("id") Long id, @PathVariable("type") int type, SSupplier sSupplier,
			ModelMap mmap) {
		String returnValue = "";
		SKpi sKpi = sKpiService.selectSKpiById(id);
		List<SSupplier> supplierList = new ArrayList<SSupplier>();
		mmap.put("sKpi", sKpi);
		switch (type) {
		case 1:// 美体内衣工厂供应商
			returnValue = prefix + "/edit";
			break;
		case 2:// 美体内衣包装袋供应商
			returnValue = prefix + "/edit_bag";
			break;
		case 3:// 美体内衣包装物料供应商
			returnValue = prefix + "/edit_matter";
			break;
		case 4:// 二级供应商
			supplierList = isSupplierService.selectSSupplierList(sSupplier);
			mmap.put("supplierList", supplierList);
			returnValue = prefix + "/edit_custom";
			break;
		case 5:// 二级供应商自评
			supplierList = isSupplierService.selectSSupplierList(sSupplier);
			mmap.put("supplierList", supplierList);
			returnValue = prefix + "/edit_self";
			break;
		default:
			break;
		}

		return returnValue;
	}

	/**
	 * 修改保存供应商绩效考评
	 */
	@RequiresPermissions(value = { "supplier:kpi:edit", "supplier:kpiBag:edit", "supplier:kpiMatter:edit",
			"supplier:kpiCustom:edit", "supplier:kpiSelf:edit" }, logical = Logical.OR)
	@Log(title = "供应商绩效考评", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SKpi sKpi) {
		sKpi.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(sKpiService.updateSKpi(sKpi));
	}

	/**
	 * 删除供应商绩效考评评分表
	 */
	@RequiresPermissions(value = { "supplier:kpi:remove", "supplier:kpiBag:remove", "supplier:kpiMatter:remove",
			"supplier:kpiCustom:remove", "supplier:kpiSelf:remove" }, logical = Logical.OR)
	@Log(title = "供应商绩效考评", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{id}")
	@ResponseBody
	public AjaxResult remove(@PathVariable("id") Long id) {
		return toAjax(sKpiService.deleteSKpiById(id));
	}

	/**
	 * 删除供应商绩效考评
	 */
	@RequiresPermissions(value = { "supplier:kpi:remove", "supplier:kpiBag:remove", "supplier:kpiMatter:remove",
			"supplier:kpiCustom:remove", "supplier:kpiSelf:remove" }, logical = Logical.OR)
	@Log(title = "供应商绩效考评", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(sKpiService.deleteSKpiByIds(ids));
	}

	/**
	 * 更新状态
	 */
	@Log(title = "供应商绩效考评", businessType = BusinessType.UPDATE)
	@PostMapping("/updateStatus")
	@ResponseBody
	public AjaxResult updateStatus(SKpi sKpi) {
		return toAjax(sKpiService.updateStatus(sKpi));
	}

	/**
	 * 跳转到上传/下载文件页面
	 */
	@GetMapping("/upload/{id}")
	public String upload(@PathVariable("id") Long id, ModelMap mmap) {
		List<SKpiFile> sKpiFileList = isKpiFileService.selectSKpiFileListByKpiId(id);
		mmap.put("sKpiFileList", sKpiFileList);
		mmap.put("kpiId", id);
		return prefix + "/upload";
	}

	/**
	 * 跳转到下载文件页面
	 */
	@GetMapping("/download")
	public String download(SKpi sKpi, ModelMap mmap) {
		List<SKpi> sKpiList = sKpiService.selectSKpiList(sKpi);
		List<SKpiFile> sKpiFileList = isKpiFileService.selectAllSKpiFileList(sKpiList);
		mmap.put("sKpiFileList", sKpiFileList);
		return prefix + "/download";
	}

	/**
	 * 多文件上传
	 */
	@RequiresPermissions(value = { "supplier:kpi:upload", "supplier:kpiBag:upload", "supplier:kpiMatter:upload",
			"supplier:kpiCustom:upload", "supplier:kpiSelf:upload" }, logical = Logical.OR)
	@Log(title = "供应商绩效考评", businessType = BusinessType.UPDATE)
	@PostMapping("/uploadSKpiFile")
	@ResponseBody
	public AjaxResult uploadSKpiFile(@RequestParam MultipartFile[] file, SKpiFile sKpiFile) {
		try {
			// 上传文件路径
			String filePath = Global.getUploadPath();
			String fileName = "";
			Long fileSize = 0L;
			List<SKpiFile> sKpiFileList = new ArrayList<SKpiFile>();
			for (MultipartFile myFile : file) {
				// 获取文件名
				fileName = myFile.getOriginalFilename();
				// 获取文件大小
				fileSize = myFile.getSize();
				// 上传并返回新文件名称带路径
				filePath = FileUploadUtils.upload(filePath, myFile);

				sKpiFile.setFileName(fileName);
				sKpiFile.setFileSize(fileSize);
				sKpiFile.setFilePath(filePath);
				sKpiFileList.add(sKpiFile);
			}
			return toAjax(isKpiFileService.batchInsertSKpiFile(sKpiFileList));
		} catch (IOException e) {
			return AjaxResult.error(e.getMessage());
		}
	}

	/**
	 * 删除附件
	 */
	@Log(title = "供应商绩效考评", businessType = BusinessType.DELETE)
	@PostMapping("/deleteSKpiFile")
	@ResponseBody
	public AjaxResult deleteSKpiFile(SKpiFile sKpiFile) {
		int row = isKpiFileService.deleteSKpiFileById(sKpiFile.getId());
		if (row > 0) {
			String localPath = Global.getProfile();
			// 数据库资源地址
			String resourcePath = localPath
					+ StringUtils.substringAfter(sKpiFile.getFilePath(), Constants.RESOURCE_PREFIX);
			File file = new File(resourcePath);
			if (file.exists()) {
				file.delete();
			}
		}
		return toAjax(0);
	}

	/**
	 * 下载附件
	 */
	@GetMapping("/downloadSKpiFile/{fileId}")
	public void downloadSKpiFile(@PathVariable("fileId") Long fileId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		SKpiFile sKpiFile = isKpiFileService.selectSKpiFileById(fileId);
		String filePath = sKpiFile.getFilePath();
		// 本地资源路径
		String localPath = Global.getProfile();
		// 数据库资源地址
		String resourPath = localPath + StringUtils.substringAfter(filePath, Constants.RESOURCE_PREFIX);
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, sKpiFile.getFileName()));
		FileUtils.writeBytes(resourPath, response.getOutputStream());
	}
	
	/**
	 * 下载附件
	 */
	@PostMapping("/downloadSKpiFile")
	public void downloadSKpiFile(Long[] fileIds, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		for(Long fileId : fileIds){
			SKpiFile sKpiFile = isKpiFileService.selectSKpiFileById(fileId);
			String filePath = sKpiFile.getFilePath();
			String realFileName = sKpiFile.getFileName() + filePath.substring(filePath.indexOf("."));
			// 本地资源路径
			String localPath = Global.getProfile();
			// 数据库资源地址
			String resourPath = localPath + StringUtils.substringAfter(filePath, Constants.RESOURCE_PREFIX);
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition",
					"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
			FileUtils.writeBytes(resourPath, response.getOutputStream());
		}
	}
}
