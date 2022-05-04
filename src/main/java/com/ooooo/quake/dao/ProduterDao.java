package com.ooooo.quake.dao;

import com.ooooo.quake.model.Produter;
import org.springframework.stereotype.Service;

@Service
public interface ProduterDao {

    /**
     * 根据skuId查询OfferId
     * @param skuId
     * @return
     */
    Produter skuIdToOfferId(String skuId);
}
