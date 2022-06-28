package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.MaterialInventoryDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialInventory;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (MaterialInventory)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 21:19:34
 */
public interface MaterialInventoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param materialInventoryId 主键
     * @return 实例对象
     */
    MaterialInventory queryById(Integer materialInventoryId);

    /**
     * 查询指定行数据
     *
     * @param materialInventory 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<MaterialInventory> queryAllByLimit(MaterialInventory materialInventory, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param materialInventory 查询条件
     * @return 总行数
     */
    long count(MaterialInventory materialInventory);

    /**
     * 新增数据
     *
     * @param materialInventory 实例对象
     * @return 影响行数
     */
    int insert(MaterialInventory materialInventory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaterialInventory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MaterialInventory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaterialInventory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MaterialInventory> entities);

    /**
     * 修改数据
     *
     * @param materialInventory 实例对象
     * @return 影响行数
     */
    int update(MaterialInventory materialInventory);

    /**
     * 通过主键删除数据
     *
     * @param materialInventoryId 主键
     * @return 影响行数
     */
    int deleteById(Integer materialInventoryId);

	List<MaterialInventory> queryAll(MaterialInventoryDTO materialInventoryDTO);

    Long getMaterialInventoryByConditionCount(MaterialInventory materialInventory);
}

