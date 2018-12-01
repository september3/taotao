package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    TbItemCatMapper tbItemCatMapper;

    /**
     * 商品分类管理
     * @param parentId   父节点Id---接收的参数，根据parentId来查询分类列表
     * @return   返回pojo列表，pojo包含的属性放在EasyUITreeNode中
     */
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        //根据parentId查询分类列表
        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询，此时的list不是所需求的list( List<EasyUITreeNode>) ,还得进一步转换
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);

        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            //创建一个节点对象
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setState(tbItemCat.getIsParent() ? "closed" : "open");
            node.setText(tbItemCat.getName());
            //将节点对象添加到列表中
            resultList.add(node);
        }
        return resultList;
    }
}
