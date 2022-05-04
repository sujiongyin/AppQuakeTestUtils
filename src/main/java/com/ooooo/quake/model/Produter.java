package com.ooooo.quake.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Produter implements Serializable {

    private static final long serialVersionUID = 4181697827147883268L;

    /**
     * 主键
     */
    @TableId
    private String id;

    /**
     * 商品表id
     */
    private String productId;

    /**
     * 商品规格 例如：{"内存":"2G","颜色":"红色","尺寸":"20cm"} 冗余字段
     */
    private Object productSpecs;

    /**
     * sku售卖价格
     */
    private BigDecimal price;

    /**
     * sku折扣价格
     */
    private BigDecimal discountPrice;

    /**
     * sku成本价格
     */
    private BigDecimal costPrice;

    /**
     * sku官方指导价格
     */
    private BigDecimal guidePrice;

    /**
     * sku总库存
     */
    private Long stock;

    /**
     * sku图片
     */
    private String image;

    /**
     * 展示序号
     */
    private Integer sortOrder;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 商品逻辑删除状态 0删除 1正常
     */
    private Integer isDelete;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * sku编码
     */
    private String code;

    /**
     * 商家自定义sku唯一编号 offerId
     */
    private String skuId;

    /**
     * barCode
     */
    private String barCode;

    /**
     * 是否是小样
     */
    private Boolean isSample;

    /**
     * 是否选中sku，默认1
     */
    private Boolean isSelected;
}
