package com.ooooo.quake.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("t_user")
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = -5840404988321331116L;

    /**
     * 用户Id
     */
    @JsonProperty("userId")
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 描述
     */
    private String description;

    /**
     * 移动国家代码
     */
    private String mobileCountryCode;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 头像网址
     */
    private String avatarUrl;

    /**
     * banner 地址
     */
    private String bannerUrl;

    /**
     * 性别
     */
    private long gender;

    /**
     * 生日(默认为空，暂时未使用)
     */
    private Date birthday;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 是否删除
     */
    private long isDelete;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 第三方Guid
     */
    private String thirdPartyGuid;

    /**
     * 第三方名字
     */
    private String thirdPartyName;

    /**
     * 语言
     */
    private String language;

    /**
     * 货币
     */
    private String currency;

    /**
     * 用户Code
     */
    private String userCode;

    /**
     * 用户状态
     */
    private long userStatus;

    /**
     * 认证
     */
    private long certification;

    private long vest;

    /**
     * 店铺Id
     */
    private String shopId;

    /**
     * 权限
     */
    private String permissions;

    /**
     * 全网唯一指定名称，1月修改1次
     */
    private String handle;
}
