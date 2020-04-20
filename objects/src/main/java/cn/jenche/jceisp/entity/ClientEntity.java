package cn.jenche.jceisp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:23
 * @Description:
 */

@Data
@Document(collection = "client")
public class ClientEntity {
    @Id
    private String id;
}
