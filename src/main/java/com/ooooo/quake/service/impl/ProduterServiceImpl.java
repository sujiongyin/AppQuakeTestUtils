package com.ooooo.quake.service.impl;

import com.ooooo.quake.dao.ProduterDao;
import com.ooooo.quake.model.Produter;
import com.ooooo.quake.service.ProduterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProduterServiceImpl implements ProduterService {

    @Autowired
    private ProduterDao produterDao;

    /**
     * 根据skuId查询 OfferId
     * @param skuId
     * @return
     */
    @Override
    public Produter skuIdToOfferId(String skuId) {
        log.info("========:"+skuId);
        return produterDao.skuIdToOfferId(skuId);
    }
}
