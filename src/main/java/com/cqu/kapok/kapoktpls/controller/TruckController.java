package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.RepairRecord;
import com.cqu.kapok.kapoktpls.entity.TransportationTask;
import com.cqu.kapok.kapoktpls.entity.Truck;
import com.cqu.kapok.kapoktpls.service.TruckService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
     *
     * @param truck
     * @return
     */
    @PostMapping("queryByTruck")
    public DataResult<List<Truck>> queryByTruck(Truck truck){
        return this.truckService.queryByTruck(truck);
    }

    /**
     * 新增数据
     *
     * @param truck 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Truck> add(Truck truck) {
        return ResponseEntity.ok(this.truckService.insert(truck));
    }

    /**
     * 编辑数据
     *
     * @param truck 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Truck> edit(Truck truck) {
        return ResponseEntity.ok(this.truckService.update(truck));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.truckService.deleteById(id));
    }

}

