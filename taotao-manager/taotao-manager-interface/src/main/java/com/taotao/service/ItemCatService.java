package com.taotao.service;

import com.taotao.pojo.TreeNode;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemCatService {
    List<TreeNode> getItemCatList(long parentId);
}
