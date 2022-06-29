package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.GoodsInventoryDTO;
import com.cqu.kapok.kapoktpls.entity.GoodsInventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (GoodsInventory)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 17:21:14
 */
public interface GoodsInventoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsInventoryId 主键
     * @return 实例对象
     */
    GoodsInventory queryById(Integer goodsInventoryId);

    /**
     * 分页查询
     *
     * @param goodsInventory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<GoodsInventory> queryByPage(GoodsInventory goodsInventory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param goodsInventory 实例对象
     * @return 实例对象
     */
    GoodsInventory insert(GoodsInventory goodsInventory);

    /**
     * 修改数据
     *
     * @param goodsInventory 实例对象
     * @return 实例对象
     */
    GoodsInventory update(GoodsInventory goodsInventory);

    /**
     * 通过主键删除数据
     *
     * @param goodsInventoryId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer goodsInventoryId);

	List<GoodsInventory> queryAll(GoodsInventoryDTO goodsInventoryDTO);

    Long getGoodsByConditionCount(GoodsInventory goodsInventory);
}
