package cn.jenche.saas.dto.clientphysicsaisle;

import cn.jenche.saas.BaseEntity;
import cn.jenche.saas.dto.GoodsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/7/23 17:51
 * @Description:
 */
@Data
@ApiModel(value = "物理货道扩展商品DTO")
public class ClientPhysicsAisleExtGoodsDTO extends BaseEntity {
    @ApiModelProperty(value = "终端Id")
    private String clientId;

    @ApiModelProperty("货道号码")
    private int aisleNumber;
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

    @ApiModelProperty(value = "折扣后售价", example = "0.00")
    private double salePrice = 0;
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

    @ApiModelProperty(value = "商品DTO")
    private GoodsDTO goodsDTO;
}
