package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.AddressDTO;
import com.cqu.kapok.kapoktpls.dto.BuildingDTO;
import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.entity.Advertisement;
import com.cqu.kapok.kapoktpls.entity.Building;
import com.cqu.kapok.kapoktpls.service.AddressService;
import com.cqu.kapok.kapoktpls.service.BuildingService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
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
 * (Building)表控制层
 *
 * @author makejava
 * @since 2022-06-28 08:56:47
 */
@RestController
@RequestMapping("building")
public class BuildingController {
    /**
     * 服务对象
     */
    @Resource
    private BuildingService buildingService;

    @Resource
    private AddressService addressService;

    /**
     * 分页查询
     *
     * @param building 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Building>> queryByPage(Building building, PageRequest pageRequest) {
        return ResponseEntity.ok(this.buildingService.queryByPage(building, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public DataResult queryById(@PathVariable("id") Integer id) {
        return DataResult.successByData(this.buildingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param buildingVo 实体
     * @return 新增结果
     */
    @PostMapping("addByBuilding")
    public DataResult add(@RequestBody BuildingVo buildingVo) {

        Building building = new Building();
        BeanUtils.copyProperties(buildingVo, building);
        Address address = new Address();
        if(buildingVo.getAddressContent()!=null){
            address.setAddressContent(buildingVo.getAddressContent());
            List<Address> addresses = this.addressService.queryByAddress(address);
            if (addresses.size() == 0) {
                address.setAddressLevel(1);
                Address insert = this.addressService.insert(address);
                building.setAddressId(insert.getAddressId());
            } else {
                for (Address address1 : addresses) {
                    building.setAddressId(address1.getAddressId());
                }
            }
        }
        return DataResult.successByData(this.buildingService.insert(building));
    }

    /**
     * 编辑数据
     *
     * @param buildingVo 实体
     * @return 编辑结果
     */
    @PostMapping("editByBuilding")
    public DataResult edit(@RequestBody BuildingVo buildingVo) {

        Building building = new Building();
        BeanUtils.copyProperties(buildingVo, building);
        Address address = new Address();
        if(buildingVo.getAddressContent()!=null){
            address.setAddressContent(buildingVo.getAddressContent());
            List<Address> addresses = this.addressService.queryByAddress(address);
            if (addresses.size() == 0) {
                address.setAddressLevel(1);
                Address insert = this.addressService.insert(address);
                building.setAddressId(insert.getAddressId());
            } else {
                for (Address address1 : addresses) {
                    building.setAddressId(address1.getAddressId());
                }
            }
        }
        return DataResult.successByData(this.buildingService.update(building));
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
            boolean b = this.buildingService.deleteById(id);
        } catch (Exception e) {
            System.out.println("异常");
            return DataResult.errByErrCode(Code.BUILDING_DELETE_ERROR);
        }
        System.out.println("正常");
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 根据实体类查询
     * @param building
     * @return
     */
    @PostMapping("queryByBuilding")
    public DataResult queryByBuilding(@RequestBody Building building){
        return DataResult.successByDatas(this.buildingService.queryByBuilding(building));
    }

    /**
     * 通过BuildingDTO分页查询
     * @param buildingDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByBuildingDTO")
    DataResult queryByBuildingDTO(@RequestBody BuildingDTO buildingDTO){
        List<BuildingVo> buildingVos = new ArrayList<>();
        //1.获取主要数据
        buildingDTO.setPage((buildingDTO.getPage() - 1) * buildingDTO.getLimit());
        List<Building> buildings =this.buildingService.queryByBuildingDTO(buildingDTO);
        Building building = new Building();
        BeanUtils.copyProperties(buildingDTO,building);
        Long total = this.buildingService.getBuildingByConditionCount(building);
        //添加次要数据
        for(Building building1:buildings){
            String addressContent = this.addressService.queryById(building1.getAddressId()).getAddressContent();
            BuildingVo buildingVo = new BuildingVo();
            BeanUtils.copyProperties(building1,buildingVo);
            buildingVo.setAddressContent(addressContent);
            buildingVos.add(buildingVo);
        }
        return DataResult.successByTotalData(buildingVos, total);
    }

}

