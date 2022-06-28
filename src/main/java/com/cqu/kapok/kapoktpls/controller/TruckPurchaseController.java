package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.Truck;
import com.cqu.kapok.kapoktpls.entity.TruckPurchase;
import com.cqu.kapok.kapoktpls.service.TruckPurchaseService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TruckPurchase)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@RestController
@RequestMapping("truckPurchase")
public class TruckPurchaseController {
    /**
     * 服务对象
     */
    @Resource
    private TruckPurchaseService truckPurchaseService;

    /**
     * 分页查询
     *
     * @param truckPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TruckPurchase>> queryByPage(TruckPurchase truckPurchase, PageRequest pageRequest) {
        return ResponseEntity.ok(this.truckPurchaseService.queryByPage(truckPurchase, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TruckPurchase> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.truckPurchaseService.queryById(id));
    }

    /**
     *
     * @param truckPurchase
     * @return
     */
    @PostMapping("queryByTruckPurchase")
    public DataResult<List<TruckPurchase>> queryByTruckPurchase(TruckPurchase truckPurchase){
        return this.truckPurchaseService.queryByTruck(truckPurchase);
    }

    /**
     * 新增数据
     *
     * @param truckPurchase 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TruckPurchase> add(TruckPurchase truckPurchase) {
        return ResponseEntity.ok(this.truckPurchaseService.insert(truckPurchase));
    }

    /**
     * 编辑数据
     *
     * @param truckPurchase 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TruckPurchase> edit(TruckPurchase truckPurchase) {
        return ResponseEntity.ok(this.truckPurchaseService.update(truckPurchase));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.truckPurchaseService.deleteById(id));
    }

}

