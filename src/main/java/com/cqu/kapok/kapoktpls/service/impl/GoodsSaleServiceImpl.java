package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.GoodsDTO;
import com.cqu.kapok.kapoktpls.dto.GoodsSaleDTO;
import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.entity.GoodsSale;
import com.cqu.kapok.kapoktpls.dao.GoodsSaleDao;
import com.cqu.kapok.kapoktpls.service.GoodsSaleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodsSale)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 21:18:45
 */
@Service("goodsSaleService")
public class GoodsSaleServiceImpl implements GoodsSaleService {
    @Resource
    private GoodsSaleDao goodsSaleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsSaleId 主键
     * @return 实例对象
     */
    @Override
    public GoodsSale queryById(Integer goodsSaleId) {
        return this.goodsSaleDao.queryById(goodsSaleId);
    }

    /**
     * 分页查询
     *
     * @param goodsSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<GoodsSale> queryByPage(GoodsSale goodsSale, PageRequest pageRequest) {
        long total = this.goodsSaleDao.count(goodsSale);
        return new PageImpl<>(this.goodsSaleDao.queryAllByLimit(goodsSale, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goodsSale 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsSale insert(GoodsSale goodsSale) {
        this.goodsSaleDao.insert(goodsSale);
        return goodsSale;
    }

    /**
     * 修改数据
     *
     * @param goodsSale 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsSale update(GoodsSale goodsSale) {
        this.goodsSaleDao.update(goodsSale);
        return this.queryById(goodsSale.getGoodsSaleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsSaleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer goodsSaleId) {
        return this.goodsSaleDao.deleteById(goodsSaleId) > 0;
    }

    @Override
    public List<GoodsSale> queryAll(GoodsSaleDTO goodsSaleDTO) {
        return this.goodsSaleDao.queryAll(goodsSaleDTO);
    }

    @Override
    public Long getGoodsSaleByConditionCount(GoodsSale goodsSale) {
        return this.goodsSaleDao.getGoodsSaleByConditionCount(goodsSale);
    }
    @Override
    public Long getGoodsSaleProfit(ProfitDTO profitDTO){
        return this.goodsSaleDao.getGoodsSaleProfit(profitDTO);
    }
}
