package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.MaterialSaleDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.MaterialSaleService;
import com.cqu.kapok.kapoktpls.service.MaterialService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.vo.MaterialSaleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private CompanyService companyService;

    @Resource
    private MaterialService materialService;

    /**
     * 分页查询
     * @param materialSaleDTO
     * @return
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody MaterialSaleDTO materialSaleDTO) {
        PageRequest pageRequest = PageRequest.of(materialSaleDTO.getPage()-1, materialSaleDTO.getSize());
        MaterialSale materialSale = new MaterialSale();
        BeanUtils.copyProperties(materialSaleDTO,materialSale);
        List<MaterialSaleVo> materialSaleVos = new ArrayList<>();
        List<MaterialSale> materialSales = this.materialSaleService.queryByPage(materialSale, pageRequest).getContent();
        for(MaterialSale materialSale1:materialSales) {
            MaterialSaleVo materialSaleVo = new MaterialSaleVo();
            BeanUtils.copyProperties(materialSale1,materialSaleVo);
            materialSaleVo.setMaterialName(this.materialService.queryById(materialSaleVo.getMaterialId()).getMaterialName());
            materialSaleVo.setCompanyName(this.companyService.queryById(materialSaleVo.getCompanyId()).getCompanyName());
            materialSaleVos.add(materialSaleVo);
        }
        Long total = this.materialSaleService.count(materialSale);
        return DataResult.successByTotalData(materialSaleVos,total);
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
    @PostMapping("add")
    public DataResult add(@RequestBody MaterialSale materialSale) {
        return DataResult.successByData(this.materialSaleService.insert(materialSale));
    }

    /**
     * 编辑数据
     *
     * @param materialSale 实体
     * @return 编辑结果
     */
    @PostMapping("edit")
    public DataResult edit(@RequestBody MaterialSale materialSale) {
        return DataResult.successByData(this.materialSaleService.update(materialSale));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestParam Integer id) {
        return this.materialSaleService.deleteById(id)?DataResult.succ():DataResult.err();
    }

    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody MaterialSale materialSale) {
        return DataResult.successByDatas(this.materialSaleService.getByCondition(materialSale));
    }

}

