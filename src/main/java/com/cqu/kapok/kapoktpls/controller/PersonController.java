package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.PersonService;
import com.cqu.kapok.kapoktpls.service.impl.CompanyServiceImpl;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Person)表控制层
 *
 * @author makejava
 * @since 2022-06-25 10:01:59
 */
@RestController
@RequestMapping("person")
public class PersonController {
    /**
     * 服务对象
     */
    @Resource
    private PersonService personService;

    /**
     * 公司
     */
    @Resource
    private CompanyService companyService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("queryByPage")
    public DataResult queryByPage(@RequestParam Integer page,@RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Person person = new Person();
        Map<String,Object> map = new HashMap<>();
        List<Person> persons = this.personService.queryByPage(person, pageRequest).getContent();
        List<String> companies = new ArrayList<>();
        map.put("persons",persons);
        for(int i=0;i<persons.size();i++) {
            companies.add(this.companyService.queryById(persons.get(i).getCompanyId()).getCompanyName());
        }
        map.put("companies",companies);
        return DataResult.successByData(map);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Person> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.personService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param person 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Person> add(Person person) {
        return ResponseEntity.ok(this.personService.insert(person));
    }

    /**
     * 编辑数据
     *
     * @param person 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Person> edit(Person person) {
        return ResponseEntity.ok(this.personService.update(person));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.personService.deleteById(id));
    }

    /**
     * 根据Person对象来查询Person
     * @param person
     * @return
     */
    @PostMapping("queryByPerson")
    DataResult<List<Person>> queryByPerson(Person person){

        return DataResult.successByDatas(this.personService.queryByPerson(person)) ;
    }

}

