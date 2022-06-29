package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.AddressDTO;
import com.cqu.kapok.kapoktpls.dto.BuildingDTO;
import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.entity.Advertisement;
import com.cqu.kapok.kapoktpls.entity.Building;
import com.cqu.kapok.kapoktpls.service.BuildingService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
     * @param building 实体
     * @return 新增结果
     */
    @PostMapping
    public DataResult add(Building building) {
        return DataResult.successByData(this.buildingService.insert(building));
    }

    /**
     * 编辑数据
     *
     * @param building 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult edit(Building building) {
        return DataResult.successByData(this.buildingService.update(building));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult deleteById(Integer id) {
        return DataResult.successByData(this.buildingService.deleteById(id));
    }

    /**
     * 根据实体类查询
     * @param building
     * @return
     */
    @PostMapping("queryByBuilding")
    public DataResult<List<Building>> queryByBuilding(Building building){
        return DataResult.successByDatas(this.buildingService.queryByBuilding(building));
    }

    /**
     * 通过BuildingDTO分页查询
     * @param buildingDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByBuildingDTO")
    DataResult queryByBuildingDTO(@RequestBody BuildingDTO buildingDTO){
        buildingDTO.setPage((buildingDTO.getPage() - 1) * buildingDTO.getLimit());
        List<Building> buildings =this.buildingService.queryByBuildingDTO(buildingDTO);
        Building building = new Building();
        BeanUtils.copyProperties(buildingDTO,building);
        Long total = this.buildingService.getBuildingByConditionCount(building);
        return DataResult.successByTotalData(buildings, total);
    }

}

