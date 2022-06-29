package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import com.cqu.kapok.kapoktpls.service.CarrierService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Carrier)表控制层
 *
 * @author makejava
 * @since 2022-06-28 09:05:49
 */
@RestController
@RequestMapping("carrier")
public class CarrierController {
    /**
     * 服务对象
     */
    @Resource
    private CarrierService carrierService;

    /**
     * 分页查询
     *
     * @param carrier 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Carrier>> queryByPage(Carrier carrier, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.carrierService.queryByPage(carrier, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Carrier> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.carrierService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param carrier 实体
     * @return 新增结果
     */
    @PostMapping("addByCarrier")
    public ResponseEntity<Carrier> add(Carrier carrier) {
        return ResponseEntity.ok(this.carrierService.insert(carrier));
    }

    /**
     * 编辑数据
     *
     * @param carrier 实体
     * @return 编辑结果
     */
    @PostMapping("editByCarrier")
    public ResponseEntity<Carrier> edit(Carrier carrier) {
        return ResponseEntity.ok(this.carrierService.update(carrier));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByCarrierId")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.carrierService.deleteById(id));
    }
    /**
     * 通过CarrierDTO分页查询
     * @param carrierDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByCarrier")
    DataResult queryByCarrier(@RequestBody CarrierDTO carrierDTO){
        carrierDTO.setPage((carrierDTO.getPage() - 1) * carrierDTO.getLimit());
        List<Carrier> carriers =this.carrierService.queryAll(carrierDTO);
        Carrier carrier = new Carrier();
        BeanUtils.copyProperties(carrierDTO,carrier);
        Long total = this.carrierService.getCarrierByConditionCount(carrier);
        return DataResult.successByTotalData(carriers, total);
    }
}

