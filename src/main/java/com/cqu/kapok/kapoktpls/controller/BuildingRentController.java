package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.BuildingDTO;
import com.cqu.kapok.kapoktpls.dto.BuildingRentDTO;
import com.cqu.kapok.kapoktpls.entity.Building;
import com.cqu.kapok.kapoktpls.entity.BuildingRent;
import com.cqu.kapok.kapoktpls.service.AddressService;
import com.cqu.kapok.kapoktpls.service.BuildingRentService;
import com.cqu.kapok.kapoktpls.service.BuildingService;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.BuildingRentVo;
import com.cqu.kapok.kapoktpls.vo.BuildingVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (BuildingRent)表控制层
 *
 * @author makejava
 * @since 2022-06-28 08:57:04
 */
@RestController
@RequestMapping("buildingRent")
public class BuildingRentController {
    /**
     * 服务对象
     */
    @Resource
    private BuildingRentService buildingRentService;

    @Resource
    private CompanyService companyService;

    @Resource
    private BuildingService buildingService;

    @Resource
    private AddressService addressService;

    /**
     * 分页查询
     *
     * @param buildingRent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BuildingRent>> queryByPage(BuildingRent buildingRent, PageRequest pageRequest) {
        return ResponseEntity.ok(this.buildingRentService.queryByPage(buildingRent, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public DataResult queryById(@PathVariable("id") Integer id) {
        return DataResult.successByData(this.buildingRentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param buildingRent 实体
     * @return 新增结果
     */
    @PostMapping("addByBuildingRent")
    public DataResult add(@RequestBody BuildingRent buildingRent) {
        return DataResult.successByData(this.buildingRentService.insert(buildingRent));
    }

    /**
     * 编辑数据
     *
     * @param buildingRent 实体
     * @return 编辑结果
     */
    @PostMapping("editByBuildingRent")
    public DataResult edit(@RequestBody BuildingRent buildingRent) {
        return DataResult.successByData(this.buildingRentService.update(buildingRent));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(Integer id) {
        try {
            boolean b = this.buildingRentService.deleteById(id);
        } catch (Exception e) {
            System.out.println("异常");
            return DataResult.errByErrCode(Code.BUILDINGRENT_DELETE_ERROR);
        }
        System.out.println("正常");
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 根据实体类查询
     * @param buildingRent
     * @return
     */
    @PostMapping("queryByBuildingRent")
    public DataResult queryByBuildingRent(BuildingRent buildingRent){
        return DataResult.successByData(this.buildingRentService.queryByBuildingRent(buildingRent));
    }

    /**
     * 通过BuildingRentDTO分页查询
     * @param buildingRentDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByBuildingRentDTO")
    DataResult queryByBuildingRentDTO(@RequestBody BuildingRentDTO buildingRentDTO){

        List<BuildingRentVo> buildingRentVos = new ArrayList<>();
        //1.获取主要数据
        buildingRentDTO.setPage((buildingRentDTO.getPage() - 1) * buildingRentDTO.getLimit());
        List<BuildingRent> buildingRents =this.buildingRentService.queryByBuildingRentDTO(buildingRentDTO);
        BuildingRent buildingRent = new BuildingRent();
        BeanUtils.copyProperties(buildingRentDTO,buildingRent);
        Long total = this.buildingRentService.getBuildingRentByConditionCount(buildingRent);
        //添加次要数据
        for(BuildingRent buildingRent1:buildingRents){
            String companyName = this.companyService.queryById(buildingRent1.getCompanyId()).getCompanyName();
            Building building = this.buildingService.queryById(buildingRent1.getBuildingId());
            String buildingType = building.getBuildingType();
            String addressContent = this.addressService.queryById(building.getAddressId()).getAddressContent();
            BuildingRentVo buildingRentVo = new BuildingRentVo();
            BeanUtils.copyProperties(buildingRent1,buildingRentVo);
            buildingRentVo.setBuildingType(buildingType);
            buildingRentVo.setCompanyName(companyName);
            buildingRentVo.setAddressContent(addressContent);
            buildingRentVos.add(buildingRentVo);
        }

        return DataResult.successByTotalData(buildingRentVos, total);
    }

}

