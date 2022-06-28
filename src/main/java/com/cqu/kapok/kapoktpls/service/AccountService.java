package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Account)表服务接口
 *
 * @author makejava
 * @since 2022-06-27 22:23:22
 */
public interface AccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param accountId 主键
     * @return 实例对象
     */
    Account queryById(Integer accountId);

    /**
     * 分页查询
     *
     * @param account 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Account> queryByPage(Account account, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account insert(Account account);

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account update(Account account);

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer accountId);

}
