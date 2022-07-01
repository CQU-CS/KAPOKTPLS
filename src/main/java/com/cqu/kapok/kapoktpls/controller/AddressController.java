package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.AddressDTO;
import com.cqu.kapok.kapoktpls.dto.GoodsDTO;
import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.service.AddressService;
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
 * (Address)表控制层
 *
 * @author makejava
 * @since 2022-06-25 10:01:16
 */
@RestController
@RequestMapping("address")
public class AddressController {
    /**
     * 服务对象
     */
    @Resource
    private AddressService addressService;

    /**
     * 分页查询
     *
     * @param address 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Address>> queryByPage(Address address, PageRequest pageRequest) {
        return ResponseEntity.ok(this.addressService.queryByPage(address, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public DataResult queryById(@PathVariable("id") Integer id) {
        return DataResult.successByData(this.addressService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param address 实体
     * @return 新增结果
     */
    @PostMapping("addByAddress")
    public DataResult add(@RequestBody Address address) {
        System.out.println("con:----------------"+address.getAddressContent());
        return DataResult.successByData(this.addressService.insert(address));
    }

    /**
     * 编辑数据
     *
     * @param address 实体
     * @return 编辑结果
     */
    @PostMapping("editByAddress")
    public DataResult edit(@RequestBody Address address) {
        return DataResult.successByData(this.addressService.update(address));
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
            boolean b = this.addressService.deleteById(id);
        } catch (Exception e) {
            System.out.println("异常");
            return DataResult.errByErrCode(Code.ADDRESS_DELETE_ERROR);
        }
        System.out.println("正常");
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 根据实体类查询
     * @param address
     * @return
     */
    @PostMapping("queryByAddress")
    public DataResult queryByAddress(Address address){
        return DataResult.successByData(this.addressService.queryByAddress(address));
    }

    /**
     * 通过AddressDTO分页查询
     * @param addressDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByAddressDTO")
    DataResult queryByAddressDTO(@RequestBody AddressDTO addressDTO){
        addressDTO.setPage((addressDTO.getPage() - 1) * addressDTO.getLimit());
        List<Address> addresses =this.addressService.queryByAddressDTO(addressDTO);
        Address address1 = new Address();
        BeanUtils.copyProperties(addressDTO,address1);
        Long total = this.addressService.getAddressByConditionCount(address1);
        return DataResult.successByTotalData(addresses, total);
    }

}

