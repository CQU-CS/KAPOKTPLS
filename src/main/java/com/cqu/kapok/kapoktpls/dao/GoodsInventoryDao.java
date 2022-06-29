package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.entity.GoodsInventory;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (GoodsInventory)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 17:21:08
 */
public interface GoodsInventoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsInventoryId 主键
     * @return 实例对象
     */
    GoodsInventory queryById(Integer goodsInventoryId);

    /**
     * 查询指定行数据
     *
     * @param goodsInventory 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<GoodsInventory> queryAllByLimit(GoodsInventory goodsInventory, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param goodsInventory 查询条件
     * @return 总行数
     */
    long count(GoodsInventory goodsInventory);

    /**
     * 新增数据
     *
     * @param goodsInventory 实例对象
     * @return 影响行数
     */
    int insert(GoodsInventory goodsInventory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsInventory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<GoodsInventory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsInventory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<GoodsInventory> entities);

    /**
     * 修改数据
     *
     * @param goodsInventory 实例对象
     * @return 影响行数
     */
    int update(GoodsInventory goodsInventory);

    /**
     * 通过主键删除数据
     *
     * @param goodsInventoryId 主键
     * @return 影响行数
     */
    int deleteById(Integer goodsInventoryId);

	List<GoodsInventory> queryAll(GoodsInventory goodsInventory);

    Long getGoodsByConditionCount(GoodsInventory goodsInventory);
}

