package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (MaterialSale)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 09:40:39
 */
public interface MaterialSaleService {

    /**
     * 通过ID查询单条数据
     *
     * @param materialSaleId 主键
     * @return 实例对象
     */
    MaterialSale queryById(Integer materialSaleId);

    /**
     * 分页查询
     *
     * @param materialSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<MaterialSale> queryByPage(MaterialSale materialSale, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param materialSale 实例对象
     * @return 实例对象
     */
    MaterialSale insert(MaterialSale materialSale);

    /**
     * 修改数据
     *
     * @param materialSale 实例对象
     * @return 实例对象
     */
    MaterialSale update(MaterialSale materialSale);

    /**
     * 通过主键删除数据
     *
     * @param materialSaleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer materialSaleId);

    /**
     * 条件查询
     * @param materialSale
     * @return
     */
    List<MaterialSale> getByCondition(MaterialSale materialSale);
}
