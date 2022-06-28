package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.MaterialUse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (MaterialUse)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 09:43:26
 */
public interface MaterialUseService {

    /**
     * 通过ID查询单条数据
     *
     * @param materialUseId 主键
     * @return 实例对象
     */
    MaterialUse queryById(Integer materialUseId);

    /**
     * 分页查询
     *
     * @param materialUse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<MaterialUse> queryByPage(MaterialUse materialUse, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param materialUse 实例对象
     * @return 实例对象
     */
    MaterialUse insert(MaterialUse materialUse);

    /**
     * 修改数据
     *
     * @param materialUse 实例对象
     * @return 实例对象
     */
    MaterialUse update(MaterialUse materialUse);

    /**
     * 通过主键删除数据
     *
     * @param materialUseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer materialUseId);

    /**
     * 条件查询
     * @param materialUse
     * @return
     */
    List<MaterialUse> getByCondition(MaterialUse materialUse);

}
