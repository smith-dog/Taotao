package com.taotao.service;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
    TbItem getItemById(long ItemId);

    EUDataGridResult getItemList(int page,int rows);
}
