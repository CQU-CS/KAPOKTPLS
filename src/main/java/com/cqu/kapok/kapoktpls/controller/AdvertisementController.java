package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.AccountDTO;
import com.cqu.kapok.kapoktpls.dto.AdvertisementDTO;
import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.entity.Advertisement;
import com.cqu.kapok.kapoktpls.service.AdvertisementService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Advertisement)表控制层
 *
 * @author makejava
 * @since 2022-06-28 08:56:08
 */
@RestController
@RequestMapping("advertisement")
public class AdvertisementController {
    /**
     * 服务对象
     */
    @Resource
    private AdvertisementService advertisementService;

    /**
     * 分页查询
     *
     * @param advertisement 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Advertisement>> queryByPage(Advertisement advertisement, PageRequest pageRequest) {
        return ResponseEntity.ok(this.advertisementService.queryByPage(advertisement, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public DataResult queryById(@PathVariable("id") Integer id) {
        return DataResult.successByData(this.advertisementService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param advertisement 实体
     * @return 新增结果
     */
    @PostMapping("addByAdvertisement")
    public DataResult add(@RequestBody Advertisement advertisement) {
        return DataResult.successByData(this.advertisementService.insert(advertisement));
    }

    /**
     * 编辑数据
     *
     * @param advertisement 实体
     * @return 编辑结果
     */
    @PostMapping("editByAdvertisement")
    public DataResult edit(@RequestBody Advertisement advertisement) {
        return DataResult.successByData(this.advertisementService.update(advertisement));
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
            boolean b = this.advertisementService.deleteById(id);
        } catch (Exception e) {
            System.out.println("异常");
            return DataResult.errByErrCode(Code.ADVERTISEMENT_DELETE_ERROR);
        }
        System.out.println("正常");
        return DataResult.errByErrCode(Code.SUCCESS);
    }


    /**
     * 根据实体类查询
     * @param advertisement
     * @return
     */
    @PostMapping("queryByAdvertisement")
    public DataResult queryByAdvertisement(Advertisement advertisement){
        return  DataResult.successByData(this.advertisementService.queryByAdvertisement(advertisement));
    }

    
    /**
     * 通过AdvertisementDTO分页查询
     * @param advertisementDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByAdvertisementDTO")
    DataResult queryByAdvertisementDTO(@RequestBody AdvertisementDTO advertisementDTO){
        advertisementDTO.setPage((advertisementDTO.getPage() - 1) * advertisementDTO.getLimit());
        List<Advertisement> advertisements =this.advertisementService.queryByAdvertisementDTO(advertisementDTO);
        Advertisement advertisement = new Advertisement();
        BeanUtils.copyProperties(advertisementDTO,advertisement);
        Long total = this.advertisementService.getAdvertisementByConditionCount(advertisement);
        return DataResult.successByTotalData(advertisements, total);
    }

}

