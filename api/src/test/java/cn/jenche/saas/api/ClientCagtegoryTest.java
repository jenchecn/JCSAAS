package cn.jenche.saas.api;

import cn.jenche.core.Pager;
import cn.jenche.core.SystemException;
import cn.jenche.saas.entity.ClientCategoryEntity;
import cn.jenche.saas.service.IClientCategoryService;
import cn.jenche.saas.type.ClientCategoryType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 15:00
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClientCagtegoryTest {
    @Autowired
    IClientCategoryService clientCategoryService;


    @Test
    public void ListTest() throws SystemException {
        Object o = clientCategoryService.LIST_PAGES(new Pager<>());
        System.out.println(o);
        Assert.assertNotNull(o);
    }

    @Test
    public void SaveTest() throws SystemException {
        ClientCategoryType type = ClientCategoryType.V2;
        ClientCategoryEntity clientCategoryEntity = new ClientCategoryEntity();
        clientCategoryEntity.setId(String.valueOf(type.getCode()));
        clientCategoryEntity.setName(type.getName());
        clientCategoryEntity.setType(type);
        clientCategoryEntity.setAisles(new ArrayList<Integer>() {{
            add(12);
            add(12);
            add(13);
            add(14);
        }});

        clientCategoryEntity = clientCategoryService.SAVE(clientCategoryEntity);
        Assert.assertNotNull(clientCategoryEntity);
    }

    @Test
    public void UpdateTest() throws SystemException {
        ClientCategoryType type = ClientCategoryType.V1;
        ClientCategoryEntity clientCategoryEntity = new ClientCategoryEntity();
        clientCategoryEntity.setId(String.valueOf(type.getCode()));
        clientCategoryEntity.setName(type.getName());
        clientCategoryEntity.setType(type);
        clientCategoryEntity.setAisles(new ArrayList<Integer>() {{
            add(12);
            add(12);
            add(13);
            add(14);
        }});

        clientCategoryEntity = clientCategoryService.UPDATE(clientCategoryEntity);
        Assert.assertNotNull(clientCategoryEntity);
    }

    @Test
    public void DeleteTest() throws SystemException {
        ClientCategoryType type = ClientCategoryType.V2;
        clientCategoryService.DELETE(String.valueOf(type.getCode()));
    }
}
