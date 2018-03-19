package com.taotao.service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TreeNode> getItemCatList(long parentId) {
        //执行查询
        List<TbItemCat> list = tbItemCatMapper.selectTbItemCatByParentId(parentId);
        //分类列表转换成TreeNode的列表
        List<TreeNode> resultList = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            //创建一个TreeNode对象
            TreeNode node = new TreeNode(tbItemCat.getId(), tbItemCat.getName(),
                    tbItemCat.getIsParent()?"closed":"open");
            resultList.add(node);
        }

        return resultList;

    }
}
