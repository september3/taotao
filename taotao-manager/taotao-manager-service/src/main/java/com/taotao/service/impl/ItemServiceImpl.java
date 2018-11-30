package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品查询Service
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    TbItemMapper tbItemMapper;

    @Override
    public TbItem getItemById(Long itemId) {
        //根据主键进行查询
//        TbItem item = tbItemMapper.selectByPrimaryKey(itemId);

        //根据查询条件进行查询
        TbItemExample example = new TbItemExample();
        //创建查询条件
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        //查询结果返回并且保存
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //判断List是否为空
        TbItem item = null;
        if(list != null && list.size() > 0){
             item = list.get(0);

        }
        return item;
    }
}
