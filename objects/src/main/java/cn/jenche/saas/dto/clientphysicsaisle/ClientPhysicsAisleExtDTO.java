package cn.jenche.saas.dto.clientphysicsaisle;

import cn.jenche.saas.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/7/23 12:01
 * @Description:
 */
@Data
@ApiModel(value = "物理货道扩展DTO")
public class ClientPhysicsAisleExtDTO extends BaseEntity {
    @ApiModelProperty("货道号码")
    private int aisleNumber;

    @ApiModelProperty("商品Id")
    private String goodsId;
    /**
     * 折扣
     * <p>
     * 填写打折数字，以百分比表示。
     * eg: 10 = 10%
     * 100（正常） - 10（折扣） = 90（支付）
     * </p>
     */
    @ApiModelProperty(value = "折扣", example = "0")
    private int discount = 0;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存量", example = "0")
    private int inventory = 0;

    /**
     * 货道是否可用
     * <p>默认可用</p>
     */
    @ApiModelProperty(value = "货道是否可用", example = "true")
    private boolean status = true;
}
