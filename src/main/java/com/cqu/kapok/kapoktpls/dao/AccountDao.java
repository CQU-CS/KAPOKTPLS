package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.AccountDTO;
import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Account)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-27 22:23:22
 */
public interface AccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param accountId 主键
     * @return 实例对象
     */
    Account queryById(Integer accountId);

    /**
     * 查询指定行数据
     *
     * @param account 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Account> queryAllByLimit(Account account, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param account 查询条件
     * @return 总行数
     */
    long count(Account account);

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 影响行数
     */
    int insert(Account account);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Account> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Account> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Account> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Account> entities);

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 影响行数
     */
    int update(Account account);

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 影响行数
     */
    int deleteById(Integer accountId);

    /**
     * 验证账号是否存在
     * @param account
     * @return
     */
    Account queryLogin(Account account);

    /**
     * 根据实体类查询
     * @param account
     * @return
     */
    List<Account> queryByAccount(Account account);

    /**
     * 根据token查询account
     * @param token
     * @return
     */
    Account queryByToken(String token);

    /**
     * 分页查询
     * @param accountDTO
     * @return
     */
    List<Account> queryByAccountDTO(AccountDTO accountDTO);

    /**
     * 分页数量
     * @param account
     * @return
     */
    Long getAccountByConditionCount(Account account);

    List<Account> getPictureByNickname(Account account);
}

