package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.BuildingDTO;
import com.cqu.kapok.kapoktpls.dto.BuildingSaleDTO;
import com.cqu.kapok.kapoktpls.entity.Building;
import com.cqu.kapok.kapoktpls.entity.BuildingSale;
import com.cqu.kapok.kapoktpls.entity.BuildingSale;
import com.cqu.kapok.kapoktpls.service.AddressService;
import com.cqu.kapok.kapoktpls.service.BuildingSaleService;
import com.cqu.kapok.kapoktpls.service.BuildingService;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.BuildingSaleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (BuildingSale)表控制层
 *
 * @author makejava
 * @since 2022-06-28 08:57:16
 */
@RestController
@RequestMapping("buildingSale")
public class BuildingSaleController {
    /**
     * 服务对象
     */
    @Resource
    private BuildingSaleService buildingSaleService;

    @Resource
    private CompanyService companyService;

    @Resource
    private BuildingService buildingService;

    @Resource
    private AddressService addressService;

    /**
     * 分页查询
     *
     * @param buildingSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BuildingSale>> queryByPage(BuildingSale buildingSale, PageRequest pageRequest) {
        return ResponseEntity.ok(this.buildingSaleService.queryByPage(buildingSale, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public DataResult queryById(@PathVariable("id") Integer id) {
        return DataResult.successByData(this.buildingSaleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param buildingSale 实体
     * @return 新增结果
     */
    @PostMapping("addByBuildingSale")
    public DataResult add(@RequestBody BuildingSale buildingSale) {
        return DataResult.successByData(this.buildingSaleService.insert(buildingSale));
    }

    /**
     * 编辑数据
     *
     * @param buildingSale 实体
     * @return 编辑结果
     */
    @PostMapping("editByBuildingSale")
    public DataResult edit(@RequestBody BuildingSale buildingSale) {
        return DataResult.successByData(this.buildingSaleService.update(buildingSale));
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
            boolean b = this.buildingSaleService.deleteById(id);
        } catch (Exception e) {
            System.out.println("异常");
            return DataResult.errByErrCode(Code.BUILDINGSALE_DELETE_ERROR);
        }
        System.out.println("正常");
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 根据实体类查询
     * @param buildingSale
     * @return
     */
    @PostMapping("queryByBuildingSale")
    public DataResult queryByBuildingSale(BuildingSale buildingSale){
        return DataResult.successByData(this.buildingSaleService.queryByBuildingSale(buildingSale));
    }

    /**
     * 通过BuildingSaleDTO分页查询
     * @param buildingSaleDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByBuildingSaleDTO")
    DataResult queryByBuildingSaleDTO(@RequestBody BuildingSaleDTO buildingSaleDTO){
        List<BuildingSaleVo> buildingSaleVos = new ArrayList<>();
        //1.获取主要数据
        buildingSaleDTO.setPage((buildingSaleDTO.getPage() - 1) * buildingSaleDTO.getLimit());
        List<BuildingSale> buildingSales =this.buildingSaleService.queryByBuildingSaleDTO(buildingSaleDTO);
        BuildingSale buildingSale = new BuildingSale();
        BeanUtils.copyProperties(buildingSaleDTO,buildingSale);
        Long total = this.buildingSaleService.getBuildingSaleByConditionCount(buildingSale);
        //添加次要数据
        for(BuildingSale buildingSale1:buildingSales){
            String companyName = this.companyService.queryById(buildingSale1.getCompanyId()).getCompanyName();
            Building building = this.buildingService.queryById(buildingSale1.getBuildingId());
            String buildingType = building.getBuildingType();
            String addressContent = this.addressService.queryById(building.getAddressId()).getAddressContent();
            BuildingSaleVo buildingSaleVo = new BuildingSaleVo();
            BeanUtils.copyProperties(buildingSale1,buildingSaleVo);
            buildingSaleVo.setBuildingType(buildingType);
            buildingSaleVo.setCompanyName(companyName);
            buildingSaleVo.setAddressContent(addressContent);
            buildingSaleVos.add(buildingSaleVo);
        }
        return DataResult.successByTotalData(buildingSaleVos, total);
    }

}

