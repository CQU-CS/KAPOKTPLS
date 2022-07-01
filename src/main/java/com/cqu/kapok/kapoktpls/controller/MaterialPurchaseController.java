package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.MaterialPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.*;
import com.cqu.kapok.kapoktpls.entity.MaterialPurchase;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.MaterialService;
import com.cqu.kapok.kapoktpls.service.MaterialPurchaseService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.MaterialPurchaseVo;
import com.cqu.kapok.kapoktpls.vo.MaterialPurchaseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private MaterialService materialService;

    @Resource
    private CompanyService companyService;
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
     * @param materialPurchaseVo 实体
     * @return 新增结果
     */
    @PostMapping("addMaterialPurchase")
    public DataResult add(@RequestBody MaterialPurchaseVo materialPurchaseVo) {
        MaterialPurchase materialPurchase = new MaterialPurchase();
        BeanUtils.copyProperties(materialPurchaseVo,materialPurchase);

        Material material = new Material();
        Company company = new Company();

        material.setMaterialName(materialPurchaseVo.getMaterialName());
        System.out.println(materialPurchaseVo.getMaterialName());
        company.setCompanyName(materialPurchaseVo.getCompanyName());
        System.out.println(materialPurchaseVo.getCompanyName());

        List<Material> materials = this.materialService.queryByMaterial(material);
        List<Company> companys = this.companyService.queryCompany(company);
        System.out.println("11111111111111111");
        if(materials.size() != 0){
            System.out.println("获取good");
            materialPurchase.setMaterialId(materials.get(0).getMaterialId());
        }else{
            //插入操作
            System.out.println("插入good");
            material.setMaterialId(6666);
            Material material1 = this.materialService.insert(material);
            materialPurchase.setMaterialId(material1.getMaterialId());
        }

        if(companys.size() != 0){
            System.out.println("获取com");
            materialPurchase.setCompanyId(companys.get(0).getCompanyId());
        }else{
            //插入操作
            System.out.println("插入com");
            company.setCompanyId(6666);
            company.setAddressId(666);
            Company company1 = this.companyService.insert(company);
            materialPurchase.setCompanyId(company1.getCompanyId());
        }

        return DataResult.successByData(this.materialPurchaseService.insert(materialPurchase));
    }

    /**
     * 编辑数据
     *
     * @param materialPurchaseVo 实体
     * @return 编辑结果
     */
    @PostMapping("editMaterialPurchase")
    public DataResult edit(@RequestBody MaterialPurchaseVo materialPurchaseVo) {
        MaterialPurchase materialPurchase = new MaterialPurchase();
        BeanUtils.copyProperties(materialPurchaseVo,materialPurchase);

        Material material = new Material();
        Company company = new Company();

        material.setMaterialName(materialPurchaseVo.getMaterialName());
        System.out.println(materialPurchaseVo.getMaterialName());
        company.setCompanyName(materialPurchaseVo.getCompanyName());
        System.out.println(materialPurchaseVo.getCompanyName());

        List<Material> materials = this.materialService.queryByMaterial(material);
        List<Company> companys = this.companyService.queryCompany(company);
        System.out.println("11111111111111111");
        if(materials.size() != 0){
            System.out.println("获取good");
            materialPurchase.setMaterialId(materials.get(0).getMaterialId());
        }else{
            //插入操作
            System.out.println("插入good");
            material.setMaterialId(6666);
            Material material1 = this.materialService.insert(material);
            materialPurchase.setMaterialId(material1.getMaterialId());
        }

        if(companys.size() != 0){
            System.out.println("获取com");
            materialPurchase.setCompanyId(companys.get(0).getCompanyId());
        }else{
            //插入操作
            System.out.println("插入com");
            company.setCompanyId(6666);
            company.setAddressId(666);
            Company company1 = this.companyService.insert(company);
            materialPurchase.setCompanyId(company1.getCompanyId());
        }

        return DataResult.successByData(this.materialPurchaseService.update(materialPurchase));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteMaterialPurchase")
    public DataResult deleteById(Integer id) {
        boolean b = this.materialPurchaseService.deleteById(id);
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    @PostMapping("queryByMaterialPurchase")
    DataResult queryByMaterial(@RequestBody MaterialPurchaseDTO materialPurchaseDTO){
        materialPurchaseDTO.setPage((materialPurchaseDTO.getPage() - 1) * materialPurchaseDTO.getLimit());
        List<MaterialPurchase> materialPurchases = this.materialPurchaseService.queryAll(materialPurchaseDTO);
        MaterialPurchase materialPurchase = new MaterialPurchase();
        BeanUtils.copyProperties(materialPurchaseDTO,materialPurchase);
        Long total = this.materialPurchaseService.getMaterialPurchaseByConditionCount(materialPurchase);

        Material material = new Material();
        ArrayList<MaterialPurchaseVo> materialPurchaseVos = new ArrayList<>();
        for(MaterialPurchase materialPurchase1: materialPurchases){
            material.setMaterialId(materialPurchase1.getMaterialId());
            List<Material> materials = this.materialService.queryByMaterial(material);
            //货物名称
            String materialName = materials.get(0).getMaterialName();
            MaterialPurchaseVo materialPurchaseVo = new MaterialPurchaseVo();
            BeanUtils.copyProperties(materialPurchase1,materialPurchaseVo);
            materialPurchaseVo.setMaterialName(materialName);


            //公司名称
            Company company = this.companyService.queryById(materialPurchase1.getCompanyId());
            String companyName = company.getCompanyName();
            materialPurchaseVo.setCompanyName(companyName);
            materialPurchaseVos.add(materialPurchaseVo);
        }
        return DataResult.successByTotalData(materialPurchaseVos, total);
    }

}

