package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
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

    /**
     * 展示商品列表功能接口
     * 应该放到taotao-common工程中，和其他系统共用。
     * @param page  显示的页码
     * @param rows 每页显示的记录数
     * @return 创建一个pojo表示返回值。应该包含total、rows两个属性。
     */
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page,rows);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        //返回处理结果
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }
}
