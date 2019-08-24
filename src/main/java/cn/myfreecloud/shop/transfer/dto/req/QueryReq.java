package cn.myfreecloud.shop.transfer.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class QueryReq {


    @ApiModelProperty(value = "当前页码")
    private Integer pageNum;

    @NotNull
    @ApiModelProperty(value = "分页大小")
    private Integer pageSize;
}
