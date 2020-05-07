package cn.jenche.saas.entity;

import cn.jenche.saas.type.ClientCategoryType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 13:11
 * @Description: 终端类别
 */

@Data
@Document(collection = "client_category")
public class ClientCategoryEntity extends BaseEntity {
    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类代码
     */
    private ClientCategoryType type;

    /**
     * 货道信息
     */
    private List<Integer> aisles;
}
