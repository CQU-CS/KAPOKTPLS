package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.GoodsSaleDTO;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.entity.GoodsSale;
import com.cqu.kapok.kapoktpls.service.GoodsSaleService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodsSale)表控制层
 *
 * @author makejava
 * @since 2022-06-28 21:18:44
 */
@RestController
@RequestMapping("goodsSale")
public class GoodsSaleController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsSaleService goodsSaleService;

    /**
     * 分页查询
     *
     * @param goodsSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<GoodsSale>> queryByPage(GoodsSale goodsSale, PageRequest pageRequest) {
        return ResponseEntity.ok(this.goodsSaleService.queryByPage(goodsSale, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<GoodsSale> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.goodsSaleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goodsSale 实体
     * @return 新增结果
     */
    @PostMapping("addGoodsSale")
    public ResponseEntity<GoodsSale> add(GoodsSale goodsSale) {
        return ResponseEntity.ok(this.goodsSaleService.insert(goodsSale));
    }

    /**
     * 编辑数据
     *
     * @param goodsSale 实体
     * @return 编辑结果
     */
    @PutMapping("editGoodsSale")
    public ResponseEntity<GoodsSale> edit(GoodsSale goodsSale) {
        return ResponseEntity.ok(this.goodsSaleService.update(goodsSale));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("deleteGoodsSale")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.goodsSaleService.deleteById(id));
    }

    @PostMapping("queryByGoodsSale")
    DataResult queryByGoods(@RequestBody GoodsSaleDTO goodsSaleDTO){
        goodsSaleDTO.setPage((goodsSaleDTO.getPage() - 1) * goodsSaleDTO.getLimit());
        List<GoodsSale> goodsSales =this.goodsSaleService.queryAll(goodsSaleDTO);
        GoodsSale goodsSale = new GoodsSale();
        BeanUtils.copyProperties(goodsSaleDTO,goodsSale);
        Long total = this.goodsSaleService.getGoodsSaleByConditionCount(goodsSale);
        return DataResult.successByTotalData(goodsSales, total);
    }

}

