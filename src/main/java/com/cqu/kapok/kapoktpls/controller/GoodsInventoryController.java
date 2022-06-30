package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.GoodsDTO;
import com.cqu.kapok.kapoktpls.dto.GoodsInventoryDTO;
import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.entity.GoodsInventory;
import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.service.AddressService;
import com.cqu.kapok.kapoktpls.service.GoodsInventoryService;
import com.cqu.kapok.kapoktpls.service.GoodsService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.CertificateVo;
import com.cqu.kapok.kapoktpls.vo.GoodsInventoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (GoodsInventory)表控制层
 *
 * @author makejava
 * @since 2022-06-28 17:21:08
 */
@RestController
@RequestMapping("goodsInventory")
public class GoodsInventoryController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsInventoryService goodsInventoryService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private AddressService addressService;
    /**
     * 分页查询
     *
     * @param goodsInventory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<GoodsInventory>> queryByPage(GoodsInventory goodsInventory, PageRequest pageRequest) {
        return ResponseEntity.ok(this.goodsInventoryService.queryByPage(goodsInventory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<GoodsInventory> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.goodsInventoryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goodsInventoryVo 实体
     * @return 新增结果
     */
    @PostMapping("addGoodsInventory")
    public DataResult add(@RequestBody GoodsInventoryVo goodsInventoryVo) {
        GoodsInventory goodsInventory = new GoodsInventory();
        BeanUtils.copyProperties(goodsInventoryVo,goodsInventory);

        Goods goods = new Goods();
        Address address = new Address();

        goods.setGoodsName(goodsInventoryVo.getGoodsName());
        System.out.println(goodsInventoryVo.getGoodsName());
        address.setAddressContent(goodsInventoryVo.getAddressContent());
        System.out.println(goodsInventoryVo.getAddressContent());

        List<Goods> goodss = this.goodsService.queryByGoods(goods);
        List<Address> addresses = this.addressService.queryByAddress(address);
        if(goodss.size() != 0){
            goodsInventory.setGoodsId(goodss.get(0).getGoodsId());
        }else{
            //插入操作
            goods.setGoodsId(6666);
            Goods goods1 = this.goodsService.insert(goods);
            goodsInventory.setGoodsId(goods1.getGoodsId());
        }

        if(addresses.size() != 0){
            goodsInventory.setAddressId(addresses.get(0).getAddressId());
        }else{
            //插入操作
            address.setAddressId(6666);
            Address address1 = this.addressService.insert(address);
            goodsInventory.setAddressId(address1.getAddressId());
        }

        return DataResult.successByData(this.goodsInventoryService.insert(goodsInventory));
    }

    /**
     * 编辑数据
     *
     * @param goodsInventoryVo 实体
     * @return 编辑结果
     */
    @PostMapping("editGoodsInventory")
    public DataResult edit(@RequestBody GoodsInventoryVo goodsInventoryVo) {
        GoodsInventory goodsInventory = new GoodsInventory();
        BeanUtils.copyProperties(goodsInventoryVo,goodsInventory);

        Goods goods = new Goods();
        Address address = new Address();

        goods.setGoodsName(goodsInventoryVo.getGoodsName());
        System.out.println(goodsInventoryVo.getGoodsName());
        address.setAddressContent(goodsInventoryVo.getAddressContent());
        System.out.println(goodsInventoryVo.getAddressContent());

        List<Goods> goodss = this.goodsService.queryByGoods(goods);
        List<Address> addresses = this.addressService.queryByAddress(address);
        if(goodss.size() != 0){
            goodsInventory.setGoodsId(goodss.get(0).getGoodsId());
        }else{
            //插入操作
            goods.setGoodsId(6666);
            Goods goods1 = this.goodsService.insert(goods);
            goodsInventory.setGoodsId(goods1.getGoodsId());
        }

        if(addresses.size() != 0){
            goodsInventory.setAddressId(addresses.get(0).getAddressId());
        }else{
            //插入操作
            address.setAddressId(6666);
            Address address1 = this.addressService.insert(address);
            goodsInventory.setAddressId(address1.getAddressId());
        }

        return DataResult.successByData(this.goodsInventoryService.update(goodsInventory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteGoodsInventory")
    public DataResult deleteById(Integer id) {
        boolean b = this.goodsInventoryService.deleteById(id);
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    @PostMapping("queryByGoodsInventory")
    DataResult queryByGoods(@RequestBody GoodsInventoryDTO goodsInventoryDTO){
        goodsInventoryDTO.setPage((goodsInventoryDTO.getPage() - 1) * goodsInventoryDTO.getLimit());
        List<GoodsInventory> goodsInventorys =this.goodsInventoryService.queryAll(goodsInventoryDTO);
        GoodsInventory goodsInventory = new GoodsInventory();
        BeanUtils.copyProperties(goodsInventoryDTO,goodsInventory);
        Long total = this.goodsInventoryService.getGoodsByConditionCount(goodsInventory);

        Goods goods = new Goods();
        ArrayList<GoodsInventoryVo> goodsInventoryVos = new ArrayList<>();
        for(GoodsInventory goodsInventory1: goodsInventorys){
            goods.setGoodsId(goodsInventory1.getGoodsId());
            List<Goods> goodss = this.goodsService.queryByGoods(goods);
            //货物名称
            String goodsName = goodss.get(0).getGoodsName();
            GoodsInventoryVo goodsInventoryVo = new GoodsInventoryVo();
            BeanUtils.copyProperties(goodsInventory1,goodsInventoryVo);
            goodsInventoryVo.setGoodsName(goodsName);


            //地址名称
            Address address = this.addressService.queryById(goodsInventory1.getAddressId());
            String addressContent = address.getAddressContent();
            goodsInventoryVo.setAddressContent(addressContent);
            goodsInventoryVos.add(goodsInventoryVo);
        }
        return DataResult.successByTotalData(goodsInventoryVos, total);
    }

}

