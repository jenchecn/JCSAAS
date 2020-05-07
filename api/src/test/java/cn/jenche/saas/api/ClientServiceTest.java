package cn.jenche.saas.api;

import cn.jenche.core.Pager;
import cn.jenche.saas.entity.ClientEntity;
import cn.jenche.saas.service.IClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/22 15:17
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClientServiceTest {
    @Autowired
    private IClientService<ClientEntity> clientService;

    @Test
    public void ClientList() {
        Object o = clientService.LIST_PAGES(new Pager<>());
    }
}
