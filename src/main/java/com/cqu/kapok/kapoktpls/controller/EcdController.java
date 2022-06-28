package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.CompanyDTO;
import com.cqu.kapok.kapoktpls.dto.EcdDTO;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.entity.Ecd;
import com.cqu.kapok.kapoktpls.service.EcdService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Ecd)表控制层
 *
 * @author makejava
 * @since 2022-06-28 14:49:09
 */
@RestController
@RequestMapping("ecd")
public class EcdController {
    /**
     * 服务对象
     */
    @Resource
    private EcdService ecdService;

    /**
     * 分页查询
     *
     * @param ecd 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Ecd>> queryByPage(Ecd ecd, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ecdService.queryByPage(ecd, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Ecd> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.ecdService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ecd 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Ecd> add(Ecd ecd) {
        return ResponseEntity.ok(this.ecdService.insert(ecd));
    }

    /**
     * 编辑数据
     *
     * @param ecd 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Ecd> edit(Ecd ecd) {
        return ResponseEntity.ok(this.ecdService.update(ecd));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.ecdService.deleteById(id));
    }
    @PostMapping("queryByEcd")
    DataResult queryByEcd(@RequestBody EcdDTO ecdDTO){
        ecdDTO.setPage((ecdDTO.getPage() - 1) * ecdDTO.getLimit());
        List<Ecd> ecds =this.ecdService.queryAll(ecdDTO);
        Ecd ecd = new Ecd();
        BeanUtils.copyProperties(ecdDTO,ecd);
        Long total = this.ecdService.getEcdByConditionCount(ecd);
        return DataResult.successByTotalData(ecds, total);
    }
}

