package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.BuildingSaleDTO;
import com.cqu.kapok.kapoktpls.entity.BuildingSale;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * (BuildingSale)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 08:57:16
 */
public interface BuildingSaleService {

    /**
     * 通过ID查询单条数据
     *
     * @param buildingSaleId 主键
     * @return 实例对象
     */
    BuildingSale queryById(Integer buildingSaleId);

    /**
     * 分页查询
     *
     * @param buildingSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BuildingSale> queryByPage(BuildingSale buildingSale, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param buildingSale 实例对象
     * @return 实例对象
     */
    BuildingSale insert(BuildingSale buildingSale);

    /**
     * 修改数据
     *
     * @param buildingSale 实例对象
     * @return 实例对象
     */
    BuildingSale update(BuildingSale buildingSale);

    /**
     * 通过主键删除数据
     *
     * @param buildingSaleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer buildingSaleId);

    /**
     * 根据实体类查询
     * @param buildingSale
     * @return
     */
    List<BuildingSale> queryByBuildingSale(BuildingSale buildingSale);

    /**
     * 分页查询
     * @param buildingSaleDTO
     * @return
     */
    List<BuildingSale> queryByBuildingSaleDTO(BuildingSaleDTO buildingSaleDTO);
    Long getBuildingSaleByConditionCount(BuildingSale buildingSale);

    /**
     * 获取某个月份的buildingSale总收入
     * @return
     */
    Long getMonthPrice(Date date);
}
