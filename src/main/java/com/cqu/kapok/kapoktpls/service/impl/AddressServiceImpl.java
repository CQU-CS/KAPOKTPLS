package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.dao.AddressDao;
import com.cqu.kapok.kapoktpls.service.AddressService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Address)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 10:01:17
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    @Override
    public Address queryById(Integer addressId) {
        return this.addressDao.queryById(addressId);
    }

    /**
     * 分页查询
     *
     * @param address 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Address> queryByPage(Address address, PageRequest pageRequest) {
        long total = this.addressDao.count(address);
        return new PageImpl<>(this.addressDao.queryAllByLimit(address, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address insert(Address address) {
        this.addressDao.insert(address);
        return address;
    }

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address update(Address address) {
        this.addressDao.update(address);
        return this.queryById(address.getAddressId());
    }

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer addressId) {
        return this.addressDao.deleteById(addressId) > 0;
    }

    /**
     * 根据实体类查询
     * @param address
     * @return
     */
    @Override
    public DataResult<List<Address>> queryByAddress(Address address) {
        return this.addressDao.queryByAddress(address);
    }
}
