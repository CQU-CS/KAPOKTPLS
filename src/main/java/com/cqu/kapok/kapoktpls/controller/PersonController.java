package com.cqu.kapok.kapoktpls.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cqu.kapok.kapoktpls.dto.PersonDTO;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.OfficeMaterialPurchase;
import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.PersonService;
import com.cqu.kapok.kapoktpls.service.impl.CompanyServiceImpl;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.vo.CarrierManageVo;
import com.cqu.kapok.kapoktpls.vo.OfficeMaterialPurchaseVo;
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
     * @param personDTO
     * @return
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody PersonDTO personDTO) {
        PageRequest pageRequest = PageRequest.of(personDTO.getPage()-1, personDTO.getSize());
        Person person = new Person();
        BeanUtils.copyProperties(personDTO,person);
        List<Person> persons = this.personService.queryByPage(person, pageRequest).getContent();
        List<PersonVo> personVos = new ArrayList<>();
        for(Person person1:persons) {
            PersonVo personVo = new PersonVo();
            BeanUtils.copyProperties(person1,personVo);
            personVo.setCompanyName(this.companyService.queryById(personVo.getCompanyId()).getCompanyName());
            if (personVo.getPersonGender()==1) personVo.setPersonGenderString("男");
            else personVo.setPersonGenderString("女");
            personVos.add(personVo);
        }
        Long total = this.personService.count(person);
        return DataResult.successByTotalData(personVos,total);
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
    @PostMapping("add")
    public DataResult add(@RequestBody Person person) {
        return DataResult.successByData(this.personService.insert(person));
    }

    /**
     * 编辑数据
     *
     * @param person 实体
     * @return 编辑结果
     */
    @PostMapping("edit")
    public DataResult edit(@RequestBody Person person) {
        return DataResult.successByData(this.personService.update(person));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestParam Integer id) {
        return this.personService.deleteById(id)?DataResult.succ():DataResult.err();
    }

    /**
     * 根据Person对象来查询Person
     * @param person
     * @return
     */
    @PostMapping("queryByPerson")
    DataResult queryByPerson(@RequestBody Person person){
        return DataResult.successByDatas(this.personService.queryByPerson(person)) ;
    }

}

