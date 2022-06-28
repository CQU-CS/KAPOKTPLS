package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.OfficeMaterialPurchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (OfficeMaterialPurchase)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 09:44:07
 */
public interface OfficeMaterialPurchaseService {

    /**
     * 通过ID查询单条数据
     *
     * @param officeMaterialPurchaseId 主键
     * @return 实例对象
     */
    OfficeMaterialPurchase queryById(Integer officeMaterialPurchaseId);

    /**
     * 分页查询
     *
     * @param officeMaterialPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<OfficeMaterialPurchase> queryByPage(OfficeMaterialPurchase officeMaterialPurchase, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param officeMaterialPurchase 实例对象
     * @return 实例对象
     */
    OfficeMaterialPurchase insert(OfficeMaterialPurchase officeMaterialPurchase);

    /**
     * 修改数据
     *
     * @param officeMaterialPurchase 实例对象
     * @return 实例对象
     */
    OfficeMaterialPurchase update(OfficeMaterialPurchase officeMaterialPurchase);

    /**
     * 通过主键删除数据
     *
     * @param officeMaterialPurchaseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer officeMaterialPurchaseId);

    /**
     * 条件查询
     * @param officeMaterialPurchase
     * @return
     */
    List<OfficeMaterialPurchase> getByCondition(OfficeMaterialPurchase officeMaterialPurchase);

}
