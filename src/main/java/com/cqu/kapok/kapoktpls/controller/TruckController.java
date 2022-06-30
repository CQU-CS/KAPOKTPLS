package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.TransportationTaskDTO;
import com.cqu.kapok.kapoktpls.dto.TruckDTO;
import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.entity.RepairRecord;
import com.cqu.kapok.kapoktpls.entity.TransportationTask;
import com.cqu.kapok.kapoktpls.entity.Truck;
import com.cqu.kapok.kapoktpls.service.PersonService;
import com.cqu.kapok.kapoktpls.service.TruckService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.CompanyVo;
import com.cqu.kapok.kapoktpls.vo.TruckVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * (Truck)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@RestController
@RequestMapping("truck")
public class TruckController {
    /**
     * 服务对象
     */
    @Resource
    private TruckService truckService;
    @Resource
    private PersonService personService;

    /**
     * 分页查询
     *
     * @param truck 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Truck>> queryByPage(Truck truck, PageRequest pageRequest) {
        return ResponseEntity.ok(this.truckService.queryByPage(truck, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Truck> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.truckService.queryById(id));
    }

    /**
     * 通过实体类查询
     *
     * @param truck
     * @return
     */
    @PostMapping("queryByTruck")
    public DataResult<List<Truck>> queryByTruck(Truck truck){
        return DataResult.successByDatas(this.truckService.queryByTruck(truck));
    }

    /**
     * 新增数据
     *
     * @param truckVo 实体
     * @return 新增结果
     */
    @PostMapping("addByTruck")
    public DataResult add(@RequestBody TruckVo truckVo) {
        Truck truck = new Truck();
        Person person = new Person();
        BeanUtils.copyProperties(truckVo,truck);
        if(truckVo.getPersonName()!=null){
            person.setPersonName(truckVo.getPersonName());
            List<Person> people = this.personService.queryByPerson(person);
            if(people.size()!=0){
                for(Person person1:people){
                    truck.setPersonId(person1.getPersonId());
                }
            }else{
                person.setCompanyId(1);
                Person insert = this.personService.insert(person);
                truck.setPersonId(insert.getPersonId());
            }
        }
        return DataResult.successByData(this.truckService.insert(truck));
    }

    /**
     * 编辑数据
     *
     * @param truckVo 实体
     * @return 编辑结果
     */
    @PostMapping("editByTruck")
    public DataResult edit(@RequestBody TruckVo truckVo) {
        Truck truck = new Truck();
        Person person = new Person();
        BeanUtils.copyProperties(truckVo,truck);
        if(truckVo.getPersonName()!=null){
            person.setPersonName(truckVo.getPersonName());
            List<Person> people = this.personService.queryByPerson(person);
            if(people.size()!=0){
                for (Person person1:people){
                    truck.setPersonId(person1.getPersonId());
                }
            }else{
                person.setCompanyId(1);
                Person insert = this.personService.insert(person);
                truck.setPersonId(insert.getPersonId());
            }
        }
        return DataResult.successByData(this.truckService.update(truck));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByTruckId")
    public DataResult deleteById(Integer id) {
        try{
            boolean b = this.truckService.deleteById(id);
        } catch (Exception e){
            return DataResult.errByErrCode(Code.TRUCK_DELETE_ERROR);
        }
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 通过queryByTruckDTO分页查询
     *
     * @param truckDTO
     * @return
     */
    @PostMapping("queryByTruckDTO")
    DataResult queryByTruckDTO(@RequestBody TruckDTO truckDTO){
        ArrayList<TruckVo> truckVos = new ArrayList<TruckVo>();
        truckDTO.setPage((truckDTO.getPage() - 1) * truckDTO.getLimit());
        List<Truck> trucks =this.truckService.queryByTruckDTO(truckDTO);
        Truck truck = new Truck();
        BeanUtils.copyProperties(truckDTO,truck);
        Long total = this.truckService.getTruckByConditionCount(truck);
        for(Truck truck1:trucks){
            String personName = this.personService.queryById(truck1.getPersonId()).getPersonName();
            TruckVo truckVo = new TruckVo();
            BeanUtils.copyProperties(truck1,truckVo);
            truckVo.setPersonName(personName);
            truckVos.add(truckVo);
        }
        return DataResult.successByTotalData(truckVos, total);
    }

}

