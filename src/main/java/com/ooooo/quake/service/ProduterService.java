package com.ooooo.quake.service;

import com.ooooo.quake.model.Produter;

public interface ProduterService {

    /**
     * 根据skuId 获取 offerId
     * @param skuId
     * @return offerId
     */
    Produter skuIdToOfferId(String skuId);
}
