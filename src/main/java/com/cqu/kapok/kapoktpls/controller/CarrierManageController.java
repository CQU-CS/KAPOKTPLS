package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.CarrierDTO;
import com.cqu.kapok.kapoktpls.dto.CarrierManageDTO;
import com.cqu.kapok.kapoktpls.entity.Carrier;
import com.cqu.kapok.kapoktpls.entity.CarrierManage;
import com.cqu.kapok.kapoktpls.service.CarrierManageService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CarrierManage)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:46:00
 */
@RestController
@RequestMapping("carrierManage")
public class CarrierManageController {
    /**
     * 服务对象
     */
    @Resource
    private CarrierManageService carrierManageService;

    /**
     * 分页查询
     *
     * @param carrierManage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CarrierManage>> queryByPage(CarrierManage carrierManage, PageRequest pageRequest) {
        return ResponseEntity.ok(this.carrierManageService.queryByPage(carrierManage, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CarrierManage> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.carrierManageService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param carrierManage 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CarrierManage> add(CarrierManage carrierManage) {
        return ResponseEntity.ok(this.carrierManageService.insert(carrierManage));
    }

    /**
     * 编辑数据
     *
     * @param carrierManage 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CarrierManage> edit(CarrierManage carrierManage) {
        return ResponseEntity.ok(this.carrierManageService.update(carrierManage));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.carrierManageService.deleteById(id));
    }

    @PostMapping("queryByCarrierManage")
    DataResult queryByCarrierManage(@RequestBody CarrierManageDTO carrierManageDTO){
        carrierManageDTO.setPage((carrierManageDTO.getPage() - 1) * carrierManageDTO.getLimit());
        List<CarrierManage> carrierManages =this.carrierManageService.queryAll(carrierManageDTO);
        CarrierManage carrierManage = new CarrierManage();
        BeanUtils.copyProperties(carrierManageDTO,carrierManage);
        Long total = this.carrierManageService.getCarrierMangeByConditionCount(carrierManage);
        return DataResult.successByTotalData(carrierManages, total);
    }

}

