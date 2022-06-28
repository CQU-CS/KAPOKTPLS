package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.BuildingSale;
import com.cqu.kapok.kapoktpls.dao.BuildingSaleDao;
import com.cqu.kapok.kapoktpls.service.BuildingSaleService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BuildingSale)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 08:57:16
 */
@Service("buildingSaleService")
public class BuildingSaleServiceImpl implements BuildingSaleService {
    @Resource
    private BuildingSaleDao buildingSaleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param buildingSaleId 主键
     * @return 实例对象
     */
    @Override
    public BuildingSale queryById(Integer buildingSaleId) {
        return this.buildingSaleDao.queryById(buildingSaleId);
    }

    /**
     * 分页查询
     *
     * @param buildingSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BuildingSale> queryByPage(BuildingSale buildingSale, PageRequest pageRequest) {
        long total = this.buildingSaleDao.count(buildingSale);
        return new PageImpl<>(this.buildingSaleDao.queryAllByLimit(buildingSale, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param buildingSale 实例对象
     * @return 实例对象
     */
    @Override
    public BuildingSale insert(BuildingSale buildingSale) {
        this.buildingSaleDao.insert(buildingSale);
        return buildingSale;
    }

    /**
     * 修改数据
     *
     * @param buildingSale 实例对象
     * @return 实例对象
     */
    @Override
    public BuildingSale update(BuildingSale buildingSale) {
        this.buildingSaleDao.update(buildingSale);
        return this.queryById(buildingSale.getBuildingSaleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param buildingSaleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer buildingSaleId) {
        return this.buildingSaleDao.deleteById(buildingSaleId) > 0;
    }

    /**
     * 根据实体类查询
     * @param buildingSale
     * @return
     */
    @Override
    public DataResult<List<BuildingSale>> queryByBuildingSale(BuildingSale buildingSale) {
        return this.buildingSaleDao.queryByBuildingSale(buildingSale);
    }


}
