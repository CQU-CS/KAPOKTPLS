package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.CompanyDTO;
import com.cqu.kapok.kapoktpls.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Company)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 10:03:24
 */
public interface CompanyService {

    /**
     * 通过ID查询单条数据
     *
     * @param companyId 主键
     * @return 实例对象
     */
    Company queryById(Integer companyId);

    /**
     * 分页查询
     *
     * @param company 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Company> queryByPage(Company company, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    Company insert(Company company);

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    Company update(Company company);

    /**
     * 通过主键删除数据
     *
     * @param companyId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer companyId);

    List<Company> queryAll(CompanyDTO companyDTO);

    Long getCompanyByConditionCount(Company company);

    List<Company> queryCompany(Company company);

}
