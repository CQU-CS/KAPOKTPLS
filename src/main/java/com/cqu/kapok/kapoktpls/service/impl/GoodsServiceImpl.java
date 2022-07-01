package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.EcdDTO;
import com.cqu.kapok.kapoktpls.dto.GoodsDTO;
import com.cqu.kapok.kapoktpls.entity.Ecd;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.dao.GoodsDao;
import com.cqu.kapok.kapoktpls.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 15:04:47
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Integer goodsId) {
        return this.goodsDao.queryById(goodsId);
    }

    /**
     * 分页查询
     *
     * @param goods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Goods> queryByPage(Goods goods, PageRequest pageRequest) {
        long total = this.goodsDao.count(goods);
        return new PageImpl<>(this.goodsDao.queryAllByLimit(goods, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        this.goodsDao.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        this.goodsDao.update(goods);
        return this.queryById(goods.getGoodsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer goodsId) {
        return this.goodsDao.deleteById(goodsId) > 0;
    }
    @Override
    public List<Goods> queryAll(GoodsDTO goodsDTO) {
        return this.goodsDao.queryAll(goodsDTO);
    }
    @Override
    public  List<Goods> queryByGoods(Goods goods){
        return this.goodsDao.queryByGoods(goods);
    }
    @Override
    public Long getGoodsByConditionCount(Goods goods) {
        return this.goodsDao.getGoodsByConditionCount(goods);
    }
}
