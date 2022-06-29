package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.GoodsPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.GoodsPurchase;
import com.cqu.kapok.kapoktpls.entity.GoodsPurchase;
import com.cqu.kapok.kapoktpls.service.GoodsPurchaseService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodsPurchase)表控制层
 *
 * @author makejava
 * @since 2022-06-28 21:11:50
 */
@RestController
@RequestMapping("goodsPurchase")
public class GoodsPurchaseController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsPurchaseService goodsPurchaseService;

    /**
     * 分页查询
     *
     * @param goodsPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<GoodsPurchase>> queryByPage(GoodsPurchase goodsPurchase, PageRequest pageRequest) {
        return ResponseEntity.ok(this.goodsPurchaseService.queryByPage(goodsPurchase, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<GoodsPurchase> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.goodsPurchaseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goodsPurchase 实体
     * @return 新增结果
     */
    @PostMapping("addGoodsPurchase")
    public ResponseEntity<GoodsPurchase> add(GoodsPurchase goodsPurchase) {
        return ResponseEntity.ok(this.goodsPurchaseService.insert(goodsPurchase));
    }

    /**
     * 编辑数据
     *
     * @param goodsPurchase 实体
     * @return 编辑结果
     */
    @PutMapping("editGoodsPurchase")
    public ResponseEntity<GoodsPurchase> edit(GoodsPurchase goodsPurchase) {
        return ResponseEntity.ok(this.goodsPurchaseService.update(goodsPurchase));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("deleteGoodsPurchase")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.goodsPurchaseService.deleteById(id));
    }


    @PostMapping("queryByGoodsPurchase")
    DataResult queryByGoods(@RequestBody GoodsPurchaseDTO goodsPurchaseDTO){
        goodsPurchaseDTO.setPage((goodsPurchaseDTO.getPage() - 1) * goodsPurchaseDTO.getLimit());
        List<GoodsPurchase> goodsPurchases =this.goodsPurchaseService.queryAll(goodsPurchaseDTO);
        GoodsPurchase goodsPurchase = new GoodsPurchase();
        BeanUtils.copyProperties(goodsPurchaseDTO,goodsPurchase);
        Long total = this.goodsPurchaseService.getGoodsPurchaseByConditionCount(goodsPurchase);
        return DataResult.successByTotalData(goodsPurchases, total);
    }
}

