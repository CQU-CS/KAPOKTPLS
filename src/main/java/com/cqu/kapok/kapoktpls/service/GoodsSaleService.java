package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.GoodsSaleDTO;
import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.entity.GoodsSale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * (GoodsSale)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 21:18:45
 */
public interface GoodsSaleService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsSaleId 主键
     * @return 实例对象
     */
    GoodsSale queryById(Integer goodsSaleId);

    /**
     * 分页查询
     *
     * @param goodsSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<GoodsSale> queryByPage(GoodsSale goodsSale, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param goodsSale 实例对象
     * @return 实例对象
     */
    GoodsSale insert(GoodsSale goodsSale);

    /**
     * 修改数据
     *
     * @param goodsSale 实例对象
     * @return 实例对象
     */
    GoodsSale update(GoodsSale goodsSale);

    /**
     * 通过主键删除数据
     *
     * @param goodsSaleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer goodsSaleId);

	List<GoodsSale> queryAll(GoodsSaleDTO goodsSaleDTO);

    Long getGoodsSaleByConditionCount(GoodsSale goodsSale);
    Long getGoodsSaleProfit(ProfitDTO profitDTO);

    /**
     * 当月商品销售额
     * @param date
     * @return
     */
    Long getMonthPrice(Date date);

}
