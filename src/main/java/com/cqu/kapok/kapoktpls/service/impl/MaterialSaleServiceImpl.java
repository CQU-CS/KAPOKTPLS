package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.dao.MaterialSaleDao;
import com.cqu.kapok.kapoktpls.service.MaterialSaleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MaterialSale)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 09:40:39
 */
@Service("materialSaleService")
public class MaterialSaleServiceImpl implements MaterialSaleService {
    @Resource
    private MaterialSaleDao materialSaleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param materialSaleId 主键
     * @return 实例对象
     */
    @Override
    public MaterialSale queryById(Integer materialSaleId) {
        return this.materialSaleDao.queryById(materialSaleId);
    }

    /**
     * 分页查询
     *
     * @param materialSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MaterialSale> queryByPage(MaterialSale materialSale, PageRequest pageRequest) {
        long total = this.materialSaleDao.count(materialSale);
        return new PageImpl<>(this.materialSaleDao.queryAllByLimit(materialSale, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param materialSale 实例对象
     * @return 实例对象
     */
    @Override
    public MaterialSale insert(MaterialSale materialSale) {
        this.materialSaleDao.insert(materialSale);
        return materialSale;
    }

    /**
     * 修改数据
     *
     * @param materialSale 实例对象
     * @return 实例对象
     */
    @Override
    public MaterialSale update(MaterialSale materialSale) {
        this.materialSaleDao.update(materialSale);
        return this.queryById(materialSale.getMaterialSaleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param materialSaleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer materialSaleId) {
        return this.materialSaleDao.deleteById(materialSaleId) > 0;
    }

    @Override
    public List<MaterialSale> getByCondition(MaterialSale materialSale) {
        return this.materialSaleDao.getByCondition(materialSale);
    }
}
