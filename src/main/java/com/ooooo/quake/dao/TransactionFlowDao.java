package com.ooooo.quake.dao;

import com.ooooo.quake.model.TransactionFlow;
import org.springframework.stereotype.Service;

@Service
public interface TransactionFlowDao {

    /**
     * 根据referOrderId 查询数据
     *
     * @param referOrderId
     * @return
     */
    TransactionFlow queryByReferOrderId(String referOrderId);



}
