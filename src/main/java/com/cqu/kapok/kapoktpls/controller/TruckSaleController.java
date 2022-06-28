package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.TruckRepairRecord;
import com.cqu.kapok.kapoktpls.entity.TruckSale;
import com.cqu.kapok.kapoktpls.service.TruckSaleService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TruckSale)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@RestController
@RequestMapping("truckSale")
public class TruckSaleController {
    /**
     * 服务对象
     */
    @Resource
    private TruckSaleService truckSaleService;

    /**
     * 分页查询
     *
     * @param truckSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TruckSale>> queryByPage(TruckSale truckSale, PageRequest pageRequest) {
        return ResponseEntity.ok(this.truckSaleService.queryByPage(truckSale, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TruckSale> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.truckSaleService.queryById(id));
    }

    /**
     *
     * @param truckSale
     * @return
     */
    @PostMapping("queryByTruckSale")
    public DataResult<List<TruckSale>> queryByTruckSale(TruckSale truckSale){
        return this.truckSaleService.queryByTruckSale(truckSale);
    }

    /**
     * 新增数据
     *
     * @param truckSale 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TruckSale> add(TruckSale truckSale) {
        return ResponseEntity.ok(this.truckSaleService.insert(truckSale));
    }

    /**
     * 编辑数据
     *
     * @param truckSale 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TruckSale> edit(TruckSale truckSale) {
        return ResponseEntity.ok(this.truckSaleService.update(truckSale));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.truckSaleService.deleteById(id));
    }

}

