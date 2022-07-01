package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Person)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 10:01:59
 */
public interface PersonService {

    /**
     * 通过ID查询单条数据
     *
     * @param personId 主键
     * @return 实例对象
     */
    Person queryById(Integer personId);

    /**
     * 分页查询
     *
     * @param person 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Person> queryByPage(Person person, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    Person insert(Person person);

    /**
     * 修改数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    Person update(Person person);

    /**
     * 通过主键删除数据
     *
     * @param personId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer personId);

    /**
     * 根据Person对象来查询Person
     * @param person
     * @return
     */
    List<Person> queryByPerson(Person person);

    /**
     * 计数
     * @param person
     * @return
     */
    Long count(Person person);

}
