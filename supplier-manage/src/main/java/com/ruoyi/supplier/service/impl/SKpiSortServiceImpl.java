package com.ruoyi.supplier.service.impl;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.supplier.domain.SKpiSort;
import com.ruoyi.supplier.mapper.SKpiSortMapper;
import com.ruoyi.supplier.service.ISKpiSortService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * KPI指标分类Service业务层处理
 *
 * @author Liu Qiyong
 * @date 2020-08-03
 */
@Service
public class SKpiSortServiceImpl implements ISKpiSortService {
    @Autowired
    private SKpiSortMapper sKpiSortMapper;

    /**
     * 查询KPI指标分类
     *
     * @param id KPI指标分类ID
     * @return KPI指标分类
     */
    @Override
    public SKpiSort selectSKpiSortById(Long id) {
        return sKpiSortMapper.selectSKpiSortById(id);
    }

    /**
     * 查询KPI指标分类列表
     *
     * @param sKpiSort KPI指标分类
     * @return KPI指标分类
     */
    @Override
    public List<SKpiSort> selectSKpiSortList(SKpiSort sKpiSort) {
        return sKpiSortMapper.selectSKpiSortList(sKpiSort);
    }

    /**
     * 新增KPI指标分类
     *
     * @param sKpiSort KPI指标分类
     * @return 结果
     */
    @Override
    public int insertSKpiSort(SKpiSort sKpiSort) {
        SKpiSort info = null;
        if (null != sKpiSort.getParentId())
            info = sKpiSortMapper.selectSKpiSortById(sKpiSort.getParentId());
        if (null != info)
            sKpiSort.setAncestors(info.getAncestors() + "," + sKpiSort.getParentId());
        else
            sKpiSort.setAncestors("0");

        sKpiSort.setCreateTime(DateUtils.getNowDate());
        return sKpiSortMapper.insertSKpiSort(sKpiSort);
    }

    /**
     * 修改KPI指标分类
     *
     * @param sKpiSort KPI指标分类
     * @return 结果
     */
    @Override
    @Transactional
    public int updateSKpiSort(SKpiSort sKpiSort) {
        SKpiSort newSKpiSort = selectSKpiSortById(sKpiSort.getParentId());
        SKpiSort oldSKpiSort = selectSKpiSortById(sKpiSort.getId());
        if (StringUtils.isNotNull(newSKpiSort) && StringUtils.isNotNull(oldSKpiSort)) {
            String newAncestors = newSKpiSort.getAncestors() + "," + newSKpiSort.getId();
            String oldAncestors = oldSKpiSort.getAncestors();
            sKpiSort.setAncestors(newAncestors);
            updateSortChildren(sKpiSort.getId(), newAncestors, oldAncestors);
        }
        sKpiSort.setUpdateTime(DateUtils.getNowDate());
        return sKpiSortMapper.updateSKpiSort(sKpiSort);
    }

    /**
     * 修改子元素关系
     *
     * @param id           被修改的ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateSortChildren(Long id, String newAncestors, String oldAncestors) {
        List<SKpiSort> children = sKpiSortMapper.selectChildrenSortById(id);
        for (SKpiSort child : children) {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0) {
            sKpiSortMapper.updateSortChildren(children);
        }
    }

    /**
     * 删除KPI指标分类对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSKpiSortByIds(String ids) {
        return sKpiSortMapper.deleteSKpiSortByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除KPI指标分类信息
     *
     * @param id KPI指标分类ID
     * @return 结果
     */
    @Override
    public int deleteSKpiSortById(Long id) {
        return sKpiSortMapper.deleteSKpiSortById(id);
    }

    /**
     * 查询KPI指标分类树列表
     *
     * @return 所有分类信息
     */
    @Override
    public List<Ztree> selectSortTree() {
        List<SKpiSort> sortList = sKpiSortMapper.selectSKpiSortList(new SKpiSort());
        List<Ztree> ztrees = initZtree(sortList);
        return ztrees;
    }

    /**
     * 查询KPI分类管理树（排除下级）
     *
     * @param sKpiSort
     * @return KPI分类树信息
     */
    @Override
    public List<Ztree> selectSortTreeExcludeChild(SKpiSort sKpiSort) {
        Long id = sKpiSort.getId();
        List<SKpiSort> sortList = sKpiSortMapper.selectSKpiSortList(sKpiSort);
        Iterator<SKpiSort> it = sortList.iterator();
        while (it.hasNext()) {
            SKpiSort d = (SKpiSort) it.next();
            if (d.getId().intValue() == id
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), id + "")) {
                it.remove();
            }
        }
        List<Ztree> ztrees = initZtree(sortList);
        return ztrees;
    }

    /**
     * 对象转KPI分类树
     *
     * @param sortList KPI分类列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SKpiSort> sortList) {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SKpiSort sort : sortList) {
            Ztree ztree = new Ztree();
            ztree.setId(sort.getId());
            ztree.setpId(sort.getParentId());
            ztree.setName(sort.getSortName());
            ztree.setTitle(sort.getSortName());
            ztrees.add(ztree);
        }
        return ztrees;
    }


    /**
     * 查询下级类目
     *
     * @param parentId 父ID
     * @return 结果
     */
    @Override
    public int selectSortCount(Long parentId) {
        SKpiSort sKpiSort = new SKpiSort();
        sKpiSort.setParentId(parentId);
        return sKpiSortMapper.selectSortCount(sKpiSort);
    }

    /**
     * 查询KPI指标是否存在评估项目
     *
     * @param sortId KPI指标ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkSortExistAssess(Long sortId){
        int result = sKpiSortMapper.checkSortExistAssess(sortId);
        return result > 0 ? true : false;
    }
}
