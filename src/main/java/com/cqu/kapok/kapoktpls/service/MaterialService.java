package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.MaterialDTO;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.entity.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Material)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 10:09:56
 */
public interface MaterialService {

    /**
     * 通过ID查询单条数据
     *
     * @param materialId 主键
     * @return 实例对象
     */
    Material queryById(Integer materialId);

    /**
     * 分页查询
     *
     * @param material 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Material> queryByPage(Material material, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param material 实例对象
     * @return 实例对象
     */
    Material insert(Material material);

    /**
     * 修改数据
     *
     * @param material 实例对象
     * @return 实例对象
     */
    Material update(Material material);

    /**
     * 通过主键删除数据
     *
     * @param materialId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer materialId);

    List<Material> queryAllByCondition(MaterialDTO materialDTO);

    Long getMaterialByConditionCount(Material material);
}
