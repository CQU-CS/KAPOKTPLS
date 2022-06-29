package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.GoodsPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.GoodsPurchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (GoodsPurchase)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 21:11:50
 */
public interface GoodsPurchaseService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsPurchaseId 主键
     * @return 实例对象
     */
    GoodsPurchase queryById(Integer goodsPurchaseId);

    /**
     * 分页查询
     *
     * @param goodsPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<GoodsPurchase> queryByPage(GoodsPurchase goodsPurchase, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param goodsPurchase 实例对象
     * @return 实例对象
     */
    GoodsPurchase insert(GoodsPurchase goodsPurchase);

    /**
     * 修改数据
     *
     * @param goodsPurchase 实例对象
     * @return 实例对象
     */
    GoodsPurchase update(GoodsPurchase goodsPurchase);

    /**
     * 通过主键删除数据
     *
     * @param goodsPurchaseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer goodsPurchaseId);

	List<GoodsPurchase> queryAll(GoodsPurchaseDTO goodsPurchaseDTO);

    Long getGoodsPurchaseByConditionCount(GoodsPurchase goodsPurchase);
}
