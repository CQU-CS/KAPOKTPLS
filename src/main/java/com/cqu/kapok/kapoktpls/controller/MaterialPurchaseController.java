package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.MaterialPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialPurchase;
import com.cqu.kapok.kapoktpls.service.MaterialPurchaseService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MaterialPurchase)表控制层
 *
 * @author makejava
 * @since 2022-06-28 21:19:57
 */
@RestController
@RequestMapping("materialPurchase")
public class MaterialPurchaseController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialPurchaseService materialPurchaseService;

    /**
     * 分页查询
     *
     * @param materialPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<MaterialPurchase>> queryByPage(MaterialPurchase materialPurchase, PageRequest pageRequest) {
        return ResponseEntity.ok(this.materialPurchaseService.queryByPage(materialPurchase, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<MaterialPurchase> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.materialPurchaseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param materialPurchase 实体
     * @return 新增结果
     */
    @PostMapping("addMaterialPurchase")
    public ResponseEntity<MaterialPurchase> add(MaterialPurchase materialPurchase) {
        return ResponseEntity.ok(this.materialPurchaseService.insert(materialPurchase));
    }

    /**
     * 编辑数据
     *
     * @param materialPurchase 实体
     * @return 编辑结果
     */
    @PutMapping("editMaterialPurchase")
    public ResponseEntity<MaterialPurchase> edit(MaterialPurchase materialPurchase) {
        return ResponseEntity.ok(this.materialPurchaseService.update(materialPurchase));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("deleteMaterialPurchase")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.materialPurchaseService.deleteById(id));
    }

    @PostMapping("queryByMaterialPurchase")
    DataResult queryByGoods(@RequestBody MaterialPurchaseDTO materialPurchaseDTO){
        materialPurchaseDTO.setPage((materialPurchaseDTO.getPage() - 1) * materialPurchaseDTO.getLimit());
        List<MaterialPurchase> materialPurchases = this.materialPurchaseService.queryAll(materialPurchaseDTO);
        MaterialPurchase materialPurchase = new MaterialPurchase();
        BeanUtils.copyProperties(materialPurchaseDTO,materialPurchase);
        Long total = this.materialPurchaseService.getMaterialPurchaseByConditionCount(materialPurchase);
        return DataResult.successByTotalData(materialPurchases, total);
    }

}

