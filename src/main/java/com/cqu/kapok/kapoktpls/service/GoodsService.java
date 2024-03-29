package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.GoodsDTO;
import com.cqu.kapok.kapoktpls.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 15:04:47
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    Goods queryById(Integer goodsId);

    /**
     * 分页查询
     *
     * @param goods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Goods> queryByPage(Goods goods, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer goodsId);
    List<Goods> queryAll(GoodsDTO goodsDTO);
    List<Goods> queryByGoods(Goods goods);
    Long getGoodsByConditionCount(Goods goods);

}
