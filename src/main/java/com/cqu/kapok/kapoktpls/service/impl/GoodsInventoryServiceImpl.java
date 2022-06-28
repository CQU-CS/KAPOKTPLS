package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.GoodsInventory;
import com.cqu.kapok.kapoktpls.dao.GoodsInventoryDao;
import com.cqu.kapok.kapoktpls.service.GoodsInventoryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (GoodsInventory)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 09:37:21
 */
@Service("goodsInventoryService")
public class GoodsInventoryServiceImpl implements GoodsInventoryService {
    @Resource
    private GoodsInventoryDao goodsInventoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsInventoryId 主键
     * @return 实例对象
     */
    @Override
    public GoodsInventory queryById(Integer goodsInventoryId) {
        return this.goodsInventoryDao.queryById(goodsInventoryId);
    }

    /**
     * 分页查询
     *
     * @param goodsInventory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<GoodsInventory> queryByPage(GoodsInventory goodsInventory, PageRequest pageRequest) {
        long total = this.goodsInventoryDao.count(goodsInventory);
        return new PageImpl<>(this.goodsInventoryDao.queryAllByLimit(goodsInventory, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goodsInventory 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsInventory insert(GoodsInventory goodsInventory) {
        this.goodsInventoryDao.insert(goodsInventory);
        return goodsInventory;
    }

    /**
     * 修改数据
     *
     * @param goodsInventory 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsInventory update(GoodsInventory goodsInventory) {
        this.goodsInventoryDao.update(goodsInventory);
        return this.queryById(goodsInventory.getGoodsInventoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsInventoryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer goodsInventoryId) {
        return this.goodsInventoryDao.deleteById(goodsInventoryId) > 0;
    }
}
