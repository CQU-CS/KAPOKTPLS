package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.MaterialInventoryDTO;
import com.cqu.kapok.kapoktpls.entity.*;
import com.cqu.kapok.kapoktpls.service.AddressService;
import com.cqu.kapok.kapoktpls.service.MaterialInventoryService;
import com.cqu.kapok.kapoktpls.service.MaterialService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.MaterialInventoryVo;
import com.cqu.kapok.kapoktpls.vo.MaterialInventoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (MaterialInventory)表控制层
 *
 * @author makejava
 * @since 2022-06-28 21:19:34
 */
@RestController
@RequestMapping("materialInventory")
public class MaterialInventoryController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialInventoryService materialInventoryService;

    @Resource
    private MaterialService materialService;

    @Resource
    private AddressService addressService;

    /**
     * 分页查询
     *
     * @param materialInventory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<MaterialInventory>> queryByPage(MaterialInventory materialInventory, PageRequest pageRequest) {
        return ResponseEntity.ok(this.materialInventoryService.queryByPage(materialInventory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<MaterialInventory> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.materialInventoryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param materialInventoryVo 实体
     * @return 新增结果
     */
    @PostMapping("addMaterialInventory")
    public DataResult add(@RequestBody MaterialInventoryVo materialInventoryVo) {
        MaterialInventory materialInventory = new MaterialInventory();
        BeanUtils.copyProperties(materialInventoryVo,materialInventory);

        Material material = new Material();
        Address address = new Address();

        material.setMaterialName(materialInventoryVo.getMaterialName());
        System.out.println(materialInventoryVo.getMaterialName());
        address.setAddressContent(materialInventoryVo.getAddressContent());
        System.out.println(materialInventoryVo.getAddressContent());

        List<Material> materials = this.materialService.queryByMaterial(material);
        List<Address> addresses = this.addressService.queryByAddress(address);
        if(materials.size() != 0){
            materialInventory.setMaterialId(materials.get(0).getMaterialId());
        }else{
            //插入操作
            material.setMaterialId(6666);
            Material material1 = this.materialService.insert(material);
            materialInventory.setMaterialId(material1.getMaterialId());
        }

        if(addresses.size() != 0){
            materialInventory.setAddressId(addresses.get(0).getAddressId());
        }else{
            //插入操作
            address.setAddressId(6666);
            Address address1 = this.addressService.insert(address);
            materialInventory.setAddressId(address1.getAddressId());
        }

        return DataResult.successByData(this.materialInventoryService.insert(materialInventory));
    }

    /**
     * 编辑数据
     *
     * @param materialInventoryVo 实体
     * @return 编辑结果
     */
    @PostMapping("editMaterialInventory")
    public DataResult edit(@RequestBody MaterialInventoryVo materialInventoryVo) {
        MaterialInventory materialInventory = new MaterialInventory();
        BeanUtils.copyProperties(materialInventoryVo,materialInventory);

        Material material = new Material();
        Address address = new Address();

        material.setMaterialName(materialInventoryVo.getMaterialName());
        System.out.println(materialInventoryVo.getMaterialName());
        address.setAddressContent(materialInventoryVo.getAddressContent());
        System.out.println(materialInventoryVo.getAddressContent());

        List<Material> materials = this.materialService.queryByMaterial(material);
        List<Address> addresses = this.addressService.queryByAddress(address);
        if(materials.size() != 0){
            materialInventory.setMaterialId(materials.get(0).getMaterialId());
        }else{
            //插入操作
            material.setMaterialId(6666);
            Material material1 = this.materialService.insert(material);
            materialInventory.setMaterialId(material1.getMaterialId());
        }

        if(addresses.size() != 0){
            materialInventory.setAddressId(addresses.get(0).getAddressId());
        }else{
            //插入操作
            address.setAddressId(6666);
            Address address1 = this.addressService.insert(address);
            materialInventory.setAddressId(address1.getAddressId());
        }

        return DataResult.successByData(this.materialInventoryService.update(materialInventory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteMaterialInventory")
    public DataResult deleteById(Integer id) {
        boolean b = this.materialInventoryService.deleteById(id);
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    @PostMapping("queryByMaterialInventory")
    DataResult queryByMaterial(@RequestBody MaterialInventoryDTO materialInventoryDTO){
        materialInventoryDTO.setPage((materialInventoryDTO.getPage() - 1) * materialInventoryDTO.getLimit());
        List<MaterialInventory> materialInventorys = this.materialInventoryService.queryAll(materialInventoryDTO);
        MaterialInventory materialInventory = new MaterialInventory();
        BeanUtils.copyProperties(materialInventoryDTO,materialInventory);
        Long total = this.materialInventoryService.getMaterialInventoryByConditionCount(materialInventory);

        Material material = new Material();
        ArrayList<MaterialInventoryVo> materialInventoryVos = new ArrayList<>();
        for(MaterialInventory materialInventory1: materialInventorys){
            material.setMaterialId(materialInventory1.getMaterialId());
            List<Material> materials = this.materialService.queryByMaterial(material);
            //物资名称
            String materialName = materials.get(0).getMaterialName();
            MaterialInventoryVo materialInventoryVo = new MaterialInventoryVo();
            BeanUtils.copyProperties(materialInventory1,materialInventoryVo);
            materialInventoryVo.setMaterialName(materialName);


            //地址名称
            Address address = this.addressService.queryById(materialInventory1.getAddressId());
            String addressContent = address.getAddressContent();
            materialInventoryVo.setAddressContent(addressContent);
            materialInventoryVos.add(materialInventoryVo);
        }
        return DataResult.successByTotalData(materialInventoryVos, total);
    }
}

