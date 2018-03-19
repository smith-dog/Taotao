package com.taotao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPageHelper {
    @Test
    public void testPageHelper() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring容器中获得Mapper的代理对象
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
        PageHelper.startPage(2, 10);
        List<TbItem> list = mapper.selectTbItemByMinLimitPrice(1000L);
        for(TbItem tbItem : list) {
            System.out.println(tbItem);
        }
        }
         /* //执行查询，并分页
    TbItemExample example = new TbItemExample();
    //分页处理
		PageHelper.startPage(2, 10);
    List<TbItem> list = mapper.selectByExample(example);
    //取商品列表
		for (TbItem tbItem : list) {
        System.out.println(tbItem.getTitle());

    //取分页信息
    PageInfo<TbItem> pageInfo = new PageInfo<>(list);
    long total = pageInfo.getTotal();
		System.out.println("共有商品："+ total);*/

}
