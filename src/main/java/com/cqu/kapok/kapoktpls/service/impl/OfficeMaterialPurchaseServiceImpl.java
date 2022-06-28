package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.OfficeMaterialPurchase;
import com.cqu.kapok.kapoktpls.dao.OfficeMaterialPurchaseDao;
import com.cqu.kapok.kapoktpls.service.OfficeMaterialPurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OfficeMaterialPurchase)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 09:44:07
 */
@Service("officeMaterialPurchaseService")
public class OfficeMaterialPurchaseServiceImpl implements OfficeMaterialPurchaseService {
    @Resource
    private OfficeMaterialPurchaseDao officeMaterialPurchaseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param officeMaterialPurchaseId 主键
     * @return 实例对象
     */
    @Override
    public OfficeMaterialPurchase queryById(Integer officeMaterialPurchaseId) {
        return this.officeMaterialPurchaseDao.queryById(officeMaterialPurchaseId);
    }

    /**
     * 分页查询
     *
     * @param officeMaterialPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<OfficeMaterialPurchase> queryByPage(OfficeMaterialPurchase officeMaterialPurchase, PageRequest pageRequest) {
        long total = this.officeMaterialPurchaseDao.count(officeMaterialPurchase);
        return new PageImpl<>(this.officeMaterialPurchaseDao.queryAllByLimit(officeMaterialPurchase, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param officeMaterialPurchase 实例对象
     * @return 实例对象
     */
    @Override
    public OfficeMaterialPurchase insert(OfficeMaterialPurchase officeMaterialPurchase) {
        this.officeMaterialPurchaseDao.insert(officeMaterialPurchase);
        return officeMaterialPurchase;
    }

    /**
     * 修改数据
     *
     * @param officeMaterialPurchase 实例对象
     * @return 实例对象
     */
    @Override
    public OfficeMaterialPurchase update(OfficeMaterialPurchase officeMaterialPurchase) {
        this.officeMaterialPurchaseDao.update(officeMaterialPurchase);
        return this.queryById(officeMaterialPurchase.getOfficeMaterialPurchaseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param officeMaterialPurchaseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer officeMaterialPurchaseId) {
        return this.officeMaterialPurchaseDao.deleteById(officeMaterialPurchaseId) > 0;
    }

    /**
     * 条件查询
     * @param officeMaterialPurchase
     * @return
     */
    @Override
    public List<OfficeMaterialPurchase> getByCondition(OfficeMaterialPurchase officeMaterialPurchase) {
        return this.officeMaterialPurchaseDao.getByCondition(officeMaterialPurchase);
    }
}
