package cn.myfreecloud.shop.basic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 基础分页参数
 */
@Data
public class BasicPage {

    @NotNull
    @ApiModelProperty(value = "当前页码")
    private Integer pageIndex;

    @NotNull
    @ApiModelProperty(value = "分页大小")
    private Integer pageSize;
}
