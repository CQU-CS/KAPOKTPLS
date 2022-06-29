package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.BuildingDTO;
import com.cqu.kapok.kapoktpls.dto.BuildingRentDTO;
import com.cqu.kapok.kapoktpls.entity.Building;
import com.cqu.kapok.kapoktpls.entity.BuildingRent;
import com.cqu.kapok.kapoktpls.service.BuildingRentService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public ResponseEntity<BuildingRent> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.buildingRentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param buildingRent 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BuildingRent> add(BuildingRent buildingRent) {
        return ResponseEntity.ok(this.buildingRentService.insert(buildingRent));
    }

    /**
     * 编辑数据
     *
     * @param buildingRent 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BuildingRent> edit(BuildingRent buildingRent) {
        return ResponseEntity.ok(this.buildingRentService.update(buildingRent));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.buildingRentService.deleteById(id));
    }

    /**
     * 根据实体类查询
     * @param buildingRent
     * @return
     */
    @PostMapping("queryByBuildingRent")
    public DataResult<List<BuildingRent>> queryByBuildingRent(BuildingRent buildingRent){
        return DataResult.successByDatas(this.buildingRentService.queryByBuildingRent(buildingRent));
    }

    /**
     * 通过BuildingRentDTO分页查询
     * @param buildingRentDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByBuildingRentDTO")
    DataResult queryByBuildingRentDTO(@RequestBody BuildingRentDTO buildingRentDTO){
        buildingRentDTO.setPage((buildingRentDTO.getPage() - 1) * buildingRentDTO.getLimit());
        List<BuildingRent> buildingRents =this.buildingRentService.queryByBuildingRentDTO(buildingRentDTO);
        BuildingRent buildingRent = new BuildingRent();
        BeanUtils.copyProperties(buildingRentDTO,buildingRent);
        Long total = this.buildingRentService.getBuildingRentByConditionCount(buildingRent);
        return DataResult.successByTotalData(buildingRents, total);
    }

}

