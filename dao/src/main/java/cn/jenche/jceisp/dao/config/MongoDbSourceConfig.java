package cn.jenche.jceisp.dao.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 19:15
 * @Description:
 */
@Slf4j
@Configuration
@EnableMongoRepositories(value = "cn.jenche.jceisp.dao.mongodb")
public class MongoDbSourceConfig {
}
