package cn.jenche.saas.api;

import cn.jenche.utility.id.CreateId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 16:35
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IdTest {
    @Test
    public void getIdTest() {
        Object o = CreateId.GetInstance().setCount(10).createId();

    }
}
