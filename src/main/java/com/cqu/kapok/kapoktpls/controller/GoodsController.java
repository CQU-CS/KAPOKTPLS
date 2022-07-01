package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.EcdDTO;
import com.cqu.kapok.kapoktpls.dto.GoodsDTO;
import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.entity.Ecd;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.service.GoodsService;
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
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2022-06-28 15:04:47
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    /**
     * 分页查询
     *
     * @param goods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Goods>> queryByPage(Goods goods, PageRequest pageRequest) {
        return ResponseEntity.ok(this.goodsService.queryByPage(goods, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public  DataResult queryById(@PathVariable("id") Integer id) {
        return DataResult.successByData(this.goodsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goods 实体
     * @return 新增结果
     */
    @PostMapping("addByGoods")
    public DataResult add(@RequestBody  Goods goods) {
        Goods insert = this.goodsService.insert(goods);
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 编辑数据
     *
     * @param goods 实体
     * @return 编辑结果
     */
    @PostMapping("editByGoods")
    public DataResult edit(@RequestBody Goods goods) {
        Goods update = this.goodsService.update(goods);
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByGoodsId")
    public DataResult deleteById(Integer id) {
        try {
            boolean b = this.goodsService.deleteById(id);
        } catch (Exception e) {
            return DataResult.errByErrCode(Code.GOODS_DELETE_ERROR);
        }
        return DataResult.errByErrCode(Code.SUCCESS);
    }
    /**
     * 根据实体类查询
     * @param goods
     * @return
     */
    @PostMapping("queryByGoods")
    public DataResult queryByGoods(Goods goods){
        return DataResult.successByDatas(this.goodsService.queryByGoods(goods));
    }
    /**
     * 通过GoodsDTO分页查询
     * @param goodsDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByGoodsDTO")
    DataResult queryByGoodsDTO(@RequestBody GoodsDTO goodsDTO){
        goodsDTO.setPage((goodsDTO.getPage() - 1) * goodsDTO.getLimit());
        List<Goods> goods =this.goodsService.queryAll(goodsDTO);
        Goods goods1 = new Goods();
        BeanUtils.copyProperties(goodsDTO,goods1);
        Long total = this.goodsService.getGoodsByConditionCount(goods1);
        return DataResult.successByTotalData(goods, total);
    }
}

