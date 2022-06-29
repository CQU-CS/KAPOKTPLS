package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.GoodsDTO;
import com.cqu.kapok.kapoktpls.dto.MaterialPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.entity.MaterialPurchase;
import com.cqu.kapok.kapoktpls.dao.MaterialPurchaseDao;
import com.cqu.kapok.kapoktpls.service.MaterialPurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MaterialPurchase)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 21:19:57
 */
@Service("materialPurchaseService")
public class MaterialPurchaseServiceImpl implements MaterialPurchaseService {
    @Resource
    private MaterialPurchaseDao materialPurchaseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param materialPurchaseId 主键
     * @return 实例对象
     */
    @Override
    public MaterialPurchase queryById(Integer materialPurchaseId) {
        return this.materialPurchaseDao.queryById(materialPurchaseId);
    }

    /**
     * 分页查询
     *
     * @param materialPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MaterialPurchase> queryByPage(MaterialPurchase materialPurchase, PageRequest pageRequest) {
        long total = this.materialPurchaseDao.count(materialPurchase);
        return new PageImpl<>(this.materialPurchaseDao.queryAllByLimit(materialPurchase, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param materialPurchase 实例对象
     * @return 实例对象
     */
    @Override
    public MaterialPurchase insert(MaterialPurchase materialPurchase) {
        this.materialPurchaseDao.insert(materialPurchase);
        return materialPurchase;
    }

    /**
     * 修改数据
     *
     * @param materialPurchase 实例对象
     * @return 实例对象
     */
    @Override
    public MaterialPurchase update(MaterialPurchase materialPurchase) {
        this.materialPurchaseDao.update(materialPurchase);
        return this.queryById(materialPurchase.getMaterialPurchaseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param materialPurchaseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer materialPurchaseId) {
        return this.materialPurchaseDao.deleteById(materialPurchaseId) > 0;
    }

    @Override
    public List<MaterialPurchase> queryAll(MaterialPurchaseDTO materialPurchaseDTO) {
        return this.materialPurchaseDao.queryAll(materialPurchaseDTO);
    }

    @Override
    public Long getMaterialPurchaseByConditionCount(MaterialPurchase materialPurchase) {
        return this.materialPurchaseDao.getMaterialPurchaseByConditionCount(materialPurchase);
    }
}
