package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.dao.PersonDao;
import com.cqu.kapok.kapoktpls.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Person)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 10:01:59
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonDao personDao;

    /**
     * 通过ID查询单条数据
     *
     * @param personId 主键
     * @return 实例对象
     */
    @Override
    public Person queryById(Integer personId) {
        return this.personDao.queryById(personId);
    }

    /**
     * 分页查询
     *
     * @param person 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Person> queryByPage(Person person, PageRequest pageRequest) {
        long total = this.personDao.count(person);
        return new PageImpl<>(this.personDao.queryAllByLimit(person, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    @Override
    public Person insert(Person person) {
        this.personDao.insert(person);
        return person;
    }

    /**
     * 修改数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    @Override
    public Person update(Person person) {
        this.personDao.update(person);
        return this.queryById(person.getPersonId());
    }

    /**
     * 通过主键删除数据
     *
     * @param personId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer personId) {
        return this.personDao.deleteById(personId) > 0;
    }



    /**
     * 根据Person对象来查询Person
     * @param person
     * @return
     */
    @Override
    public List<Person> queryByPerson(Person person) {
        return this.personDao.queryByPerson(person);
    }

    /**
     * 计数
     * @param person
     * @return
     */
    @Override
    public Long count(Person person) {
        return this.personDao.count(person);
    }


}
