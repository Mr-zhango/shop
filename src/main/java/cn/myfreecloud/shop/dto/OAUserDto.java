package cn.myfreecloud.shop.dto;

import lombok.Data;

/**
 * @author: zhangyang
 * @date: 2019/7/6 10:14
 * @description:
 */
@Data
public class OAUserDto {

    private static final long serialVersionUID = 6463991575280234948L;

    private String realName;
    private String jobCode;
    private String userType;
    private String userId;
    private String email;
    private String username;
}
