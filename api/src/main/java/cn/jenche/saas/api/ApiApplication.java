package cn.jenche.saas.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 18:29
 * @Description:
 */
@SpringBootApplication
@ComponentScans({
        @ComponentScan(value = "cn.jenche.core"),
        @ComponentScan(value = "cn.jenche.saas.service"),
        @ComponentScan(value = "cn.jenche.saas.dao")

})
public class ApiApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
