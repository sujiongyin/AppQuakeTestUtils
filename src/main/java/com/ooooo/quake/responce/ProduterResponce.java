package com.ooooo.quake.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduterResponce implements Serializable {

    private static final long serialVersionUID = 8925294436413797595L;
    /**
     * 商家自定义sku唯一编号 offerId
     */
    private String offerId;

}
