package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.service.MaterialSaleService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MaterialSale)表控制层
 *
 * @author makejava
 * @since 2022-06-28 09:40:15
 */
@RestController
@RequestMapping("materialSale")
public class MaterialSaleController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialSaleService materialSaleService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("queryByPage")
    public DataResult queryByPage(@RequestParam Integer page,@RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        MaterialSale materialSale = new MaterialSale();
        return DataResult.successByData(this.materialSaleService.queryByPage(materialSale, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<MaterialSale> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.materialSaleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param materialSale 实体
     * @return 新增结果
     */
    @PostMapping
    public DataResult add(@RequestBody MaterialSale materialSale) {
        return DataResult.successByData(this.materialSaleService.insert(materialSale));
    }

    /**
     * 编辑数据
     *
     * @param materialSale 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult edit(@RequestBody MaterialSale materialSale) {
        return DataResult.successByData(this.materialSaleService.update(materialSale));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult deleteById(Integer id) {
        return DataResult.successByData(this.materialSaleService.deleteById(id));
    }

    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody MaterialSale materialSale) {
        return DataResult.successByData(this.materialSaleService.getByCondition(materialSale));
    }

}

