package com.cqu.kapok.kapoktpls.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.PersonService;
import com.cqu.kapok.kapoktpls.service.impl.CompanyServiceImpl;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.vo.CarrierManageVo;
import com.cqu.kapok.kapoktpls.vo.PersonVo;
import org.springframework.beans.BeanUtils;
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
//        PageRequest pageRequest = PageRequest.of(page-1,size);
//        Person person = new Person();
//        Map<String,Object> map = new HashMap<>();
//        List<Person> persons = this.personService.queryByPage(person, pageRequest).getContent();
//        List<String> companies = new ArrayList<>();
//        map.put("persons",persons);
//        for(int i=0;i<persons.size();i++) {
//            companies.add(this.companyService.queryById(persons.get(i).getCompanyId()).getCompanyName());
//        }
//        map.put("companies",companies);

        List<PersonVo> personVos = new ArrayList<>();
        //1.获取主要数据
        PageRequest pageRequest = PageRequest.of(page-1,size);
        Person person = new Person();
        List<Person> persons = this.personService.queryByPage(person, pageRequest).getContent();
        String[] gender = {"女","男"};
        for(Person person1:persons){
            String companyName = this.companyService.queryById(person1.getCompanyId()).getCompanyName();
            PersonVo personVo = new PersonVo();
            BeanUtils.copyProperties(person1,personVo);
            personVo.setCompanyName(companyName);
            personVo.setPersonGenderString(gender[person1.getPersonGender()]);
            personVos.add(personVo);
        }
        return DataResult.successByDatas(personVos);
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
    public DataResult add(@RequestBody Person person) {
        return DataResult.successByData(this.personService.insert(person));
    }

    /**
     * 编辑数据
     *
     * @param person 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult edit(@RequestBody Person person) {
        return DataResult.successByData(this.personService.update(person));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult deleteById(Integer id) {
        return DataResult.successByData(this.personService.deleteById(id));
    }

    /**
     * 根据Person对象来查询Person
     * @param person
     * @return
     */
    @PostMapping("queryByPerson")
    DataResult queryByPerson(@RequestBody Person person){
        return DataResult.successByData(this.personService.queryByPerson(person)) ;
    }

}

