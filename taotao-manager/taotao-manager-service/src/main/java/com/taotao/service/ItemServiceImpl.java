package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public TbItem getItemById(long ItemId) {
        return tbItemMapper.selectByPrimaryKey(ItemId);
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<TbItem> tbItemsList = tbItemMapper.selectAllTbItem();
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(tbItemsList);
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemsList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
