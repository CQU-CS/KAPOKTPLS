package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.MaterialPurchaseDTO;
import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialPurchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * (MaterialPurchase)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 21:19:57
 */
public interface MaterialPurchaseService {

    /**
     * 通过ID查询单条数据
     *
     * @param materialPurchaseId 主键
     * @return 实例对象
     */
    MaterialPurchase queryById(Integer materialPurchaseId);

    /**
     * 分页查询
     *
     * @param materialPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<MaterialPurchase> queryByPage(MaterialPurchase materialPurchase, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param materialPurchase 实例对象
     * @return 实例对象
     */
    MaterialPurchase insert(MaterialPurchase materialPurchase);

    /**
     * 修改数据
     *
     * @param materialPurchase 实例对象
     * @return 实例对象
     */
    MaterialPurchase update(MaterialPurchase materialPurchase);

    /**
     * 通过主键删除数据
     *
     * @param materialPurchaseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer materialPurchaseId);

    List<MaterialPurchase> queryAll(MaterialPurchaseDTO materialPurchaseDTO);

    Long getMaterialPurchaseByConditionCount(MaterialPurchase materialPurchase);
    Long getMaterialPurchaseProfit(ProfitDTO profitDTO);

    /**
     * 当月支出
     * @param date
     * @return
     */
    Long getMonthPrice(Date date);
}
