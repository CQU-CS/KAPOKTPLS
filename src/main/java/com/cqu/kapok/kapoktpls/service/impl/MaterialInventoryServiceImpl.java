package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.GoodsDTO;
import com.cqu.kapok.kapoktpls.dto.MaterialInventoryDTO;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.entity.MaterialInventory;
import com.cqu.kapok.kapoktpls.dao.MaterialInventoryDao;
import com.cqu.kapok.kapoktpls.service.MaterialInventoryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MaterialInventory)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 21:19:34
 */
@Service("materialInventoryService")
public class MaterialInventoryServiceImpl implements MaterialInventoryService {
    @Resource
    private MaterialInventoryDao materialInventoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param materialInventoryId 主键
     * @return 实例对象
     */
    @Override
    public MaterialInventory queryById(Integer materialInventoryId) {
        return this.materialInventoryDao.queryById(materialInventoryId);
    }

    /**
     * 分页查询
     *
     * @param materialInventory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MaterialInventory> queryByPage(MaterialInventory materialInventory, PageRequest pageRequest) {
        long total = this.materialInventoryDao.count(materialInventory);
        return new PageImpl<>(this.materialInventoryDao.queryAllByLimit(materialInventory, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param materialInventory 实例对象
     * @return 实例对象
     */
    @Override
    public MaterialInventory insert(MaterialInventory materialInventory) {
        this.materialInventoryDao.insert(materialInventory);
        return materialInventory;
    }

    /**
     * 修改数据
     *
     * @param materialInventory 实例对象
     * @return 实例对象
     */
    @Override
    public MaterialInventory update(MaterialInventory materialInventory) {
        this.materialInventoryDao.update(materialInventory);
        return this.queryById(materialInventory.getMaterialInventoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param materialInventoryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer materialInventoryId) {
        return this.materialInventoryDao.deleteById(materialInventoryId) > 0;
    }

    @Override
    public List<MaterialInventory> queryAll(MaterialInventoryDTO materialInventoryDTO) {
        return this.materialInventoryDao.queryAll(materialInventoryDTO);
    }

    @Override
    public Long getMaterialInventoryByConditionCount(MaterialInventory materialInventory) {
        return this.materialInventoryDao.getMaterialInventoryByConditionCount(materialInventory);
    }
}
