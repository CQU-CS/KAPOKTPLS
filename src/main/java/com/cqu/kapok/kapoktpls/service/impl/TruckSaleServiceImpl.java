package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.TruckSaleDTO;
import com.cqu.kapok.kapoktpls.entity.TruckSale;
import com.cqu.kapok.kapoktpls.dao.TruckSaleDao;
import com.cqu.kapok.kapoktpls.service.TruckSaleService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TruckSale)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@Service("truckSaleService")
public class TruckSaleServiceImpl implements TruckSaleService {
    @Resource
    private TruckSaleDao truckSaleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param truckSaleId 主键
     * @return 实例对象
     */
    @Override
    public TruckSale queryById(Integer truckSaleId) {
        return this.truckSaleDao.queryById(truckSaleId);
    }

    /**
     * 分页查询
     *
     * @param truckSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TruckSale> queryByPage(TruckSale truckSale, PageRequest pageRequest) {
        long total = this.truckSaleDao.count(truckSale);
        return new PageImpl<>(this.truckSaleDao.queryAllByLimit(truckSale, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param truckSale 实例对象
     * @return 实例对象
     */
    @Override
    public TruckSale insert(TruckSale truckSale) {
        this.truckSaleDao.insert(truckSale);
        return truckSale;
    }

    /**
     * 修改数据
     *
     * @param truckSale 实例对象
     * @return 实例对象
     */
    @Override
    public TruckSale update(TruckSale truckSale) {
        this.truckSaleDao.update(truckSale);
        return this.queryById(truckSale.getTruckSaleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param truckSaleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer truckSaleId) {
        return this.truckSaleDao.deleteById(truckSaleId) > 0;
    }

    /**
     *
     * @param truckSale
     * @return
     */
    @Override
    public List<TruckSale> queryByTruckSale(TruckSale truckSale) {
        return this.truckSaleDao.queryByTruckSale(truckSale);
    }

    /**
     *
     * @param truckSaleDTO
     * @return
     */
    @Override
    public List<TruckSale> queryByTruckSaleDTO(TruckSaleDTO truckSaleDTO) {
        return this.truckSaleDao.queryByTruckSaleDTO(truckSaleDTO);
    }

    /**
     *
     * @param truckSale
     * @return
     */
    @Override
    public Long getTruckSaleByConditionCount(TruckSale truckSale) {
        return this.truckSaleDao.getTruckSaleByConditionCount(truckSale);
    }
}
