package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.MaterialInventoryDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialInventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (MaterialInventory)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 21:19:34
 */
public interface MaterialInventoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param materialInventoryId 主键
     * @return 实例对象
     */
    MaterialInventory queryById(Integer materialInventoryId);

    /**
     * 分页查询
     *
     * @param materialInventory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<MaterialInventory> queryByPage(MaterialInventory materialInventory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param materialInventory 实例对象
     * @return 实例对象
     */
    MaterialInventory insert(MaterialInventory materialInventory);

    /**
     * 修改数据
     *
     * @param materialInventory 实例对象
     * @return 实例对象
     */
    MaterialInventory update(MaterialInventory materialInventory);

    /**
     * 通过主键删除数据
     *
     * @param materialInventoryId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer materialInventoryId);

	List<MaterialInventory> queryAll(MaterialInventoryDTO materialInventoryDTO);

    Long getMaterialInventoryByConditionCount(MaterialInventory materialInventory);
}
