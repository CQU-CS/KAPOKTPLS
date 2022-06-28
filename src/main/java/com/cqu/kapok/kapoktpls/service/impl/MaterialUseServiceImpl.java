package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.MaterialUse;
import com.cqu.kapok.kapoktpls.dao.MaterialUseDao;
import com.cqu.kapok.kapoktpls.service.MaterialUseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MaterialUse)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 09:43:26
 */
@Service("materialUseService")
public class MaterialUseServiceImpl implements MaterialUseService {
    @Resource
    private MaterialUseDao materialUseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param materialUseId 主键
     * @return 实例对象
     */
    @Override
    public MaterialUse queryById(Integer materialUseId) {
        return this.materialUseDao.queryById(materialUseId);
    }

    /**
     * 分页查询
     *
     * @param materialUse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MaterialUse> queryByPage(MaterialUse materialUse, PageRequest pageRequest) {
        long total = this.materialUseDao.count(materialUse);
        return new PageImpl<>(this.materialUseDao.queryAllByLimit(materialUse, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param materialUse 实例对象
     * @return 实例对象
     */
    @Override
    public MaterialUse insert(MaterialUse materialUse) {
        this.materialUseDao.insert(materialUse);
        return materialUse;
    }

    /**
     * 修改数据
     *
     * @param materialUse 实例对象
     * @return 实例对象
     */
    @Override
    public MaterialUse update(MaterialUse materialUse) {
        this.materialUseDao.update(materialUse);
        return this.queryById(materialUse.getMaterialUseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param materialUseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer materialUseId) {
        return this.materialUseDao.deleteById(materialUseId) > 0;
    }

    /**
     * 条件查询
     * @param materialUse
     * @return
     */
    @Override
    public List<MaterialUse> getByCondition(MaterialUse materialUse) {
        return this.materialUseDao.getByCondition(materialUse);
    }
}
