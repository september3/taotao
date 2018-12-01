package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ItemController {


    @Autowired
    ItemService itemService;

    /**
     * 商品查询测试
     * @param itemId
     * @return
     */
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable("itemId") Long itemId){
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

    /**
     * 展示商品列表功能
     *  接收两个参数：page、rows
     *  调用Service查询商品列表。
     *  返回：EasyUIDataGridResult（json数据），需要使用@ResponseBody
     * @param page  显示的页码
     * @param rows 每页展示的记录数
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult  getItemList(Integer page,Integer rows){
        EasyUIDataGridResult result = itemService.getItemList(page,rows);
        return result;
    }



}
