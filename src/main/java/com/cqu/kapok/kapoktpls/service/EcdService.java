package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.EcdDTO;
import com.cqu.kapok.kapoktpls.entity.Ecd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Ecd)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 14:49:10
 */
public interface EcdService {

    /**
     * 通过ID查询单条数据
     *
     * @param ecdId 主键
     * @return 实例对象
     */
    Ecd queryById(Integer ecdId);

    /**
     * 分页查询
     *
     * @param ecd 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Ecd> queryByPage(Ecd ecd, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ecd 实例对象
     * @return 实例对象
     */
    Ecd insert(Ecd ecd);

    /**
     * 修改数据
     *
     * @param ecd 实例对象
     * @return 实例对象
     */
    Ecd update(Ecd ecd);

    /**
     * 通过主键删除数据
     *
     * @param ecdId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer ecdId);
    List<Ecd> queryAll(EcdDTO ecdDTO);

    Long getEcdByConditionCount(Ecd ecd);
}
