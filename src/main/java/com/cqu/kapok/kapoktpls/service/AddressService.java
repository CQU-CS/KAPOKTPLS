package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Address)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 10:01:17
 */
public interface AddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    Address queryById(Integer addressId);

    /**
     * 分页查询
     *
     * @param address 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Address> queryByPage(Address address, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address insert(Address address);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer addressId);

}
