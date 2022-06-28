package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.CompanyDTO;
import com.cqu.kapok.kapoktpls.dto.EcdDTO;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.entity.Ecd;
import com.cqu.kapok.kapoktpls.dao.EcdDao;
import com.cqu.kapok.kapoktpls.service.EcdService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Ecd)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 14:49:10
 */
@Service("ecdService")
public class EcdServiceImpl implements EcdService {
    @Resource
    private EcdDao ecdDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ecdId 主键
     * @return 实例对象
     */
    @Override
    public Ecd queryById(Integer ecdId) {
        return this.ecdDao.queryById(ecdId);
    }

    /**
     * 分页查询
     *
     * @param ecd 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Ecd> queryByPage(Ecd ecd, PageRequest pageRequest) {
        long total = this.ecdDao.count(ecd);
        return new PageImpl<>(this.ecdDao.queryAllByLimit(ecd, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ecd 实例对象
     * @return 实例对象
     */
    @Override
    public Ecd insert(Ecd ecd) {
        this.ecdDao.insert(ecd);
        return ecd;
    }

    /**
     * 修改数据
     *
     * @param ecd 实例对象
     * @return 实例对象
     */
    @Override
    public Ecd update(Ecd ecd) {
        this.ecdDao.update(ecd);
        return this.queryById(ecd.getEcdId());
    }

    /**
     * 通过主键删除数据
     *
     * @param ecdId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer ecdId) {
        return this.ecdDao.deleteById(ecdId) > 0;
    }
    @Override
    public List<Ecd> queryAll(EcdDTO ecdDTO) {
        return this.ecdDao.queryAll(ecdDTO);
    }

    @Override
    public Long getEcdByConditionCount(Ecd ecd) {
        return this.ecdDao.getEcdByConditionCount(ecd);
    }
}
