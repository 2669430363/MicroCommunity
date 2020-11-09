package com.java110.goods.bmo.storeOrder.impl;

import com.java110.core.annotation.Java110Transactional;
import com.java110.core.factory.GenerateCodeFactory;
import com.java110.goods.bmo.storeOrder.ISaveStoreOrderBMO;
import com.java110.intf.IStoreOrderInnerServiceSMO;
import com.java110.po.storeOrder.StoreOrderPo;
import com.java110.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("saveStoreOrderBMOImpl")
public class SaveStoreOrderBMOImpl implements ISaveStoreOrderBMO {

    @Autowired
    private IStoreOrderInnerServiceSMO storeOrderInnerServiceSMOImpl;

    /**
     * 添加小区信息
     *
     * @param storeOrderPo
     * @return 订单服务能够接受的报文
     */
    @Java110Transactional
    public ResponseEntity<String> save(StoreOrderPo storeOrderPo) {

        storeOrderPo.setOrderId(GenerateCodeFactory.getGeneratorId(GenerateCodeFactory.CODE_PREFIX_orderId));
        int flag = storeOrderInnerServiceSMOImpl.saveStoreOrder(storeOrderPo);

        if (flag > 0) {
            return ResultVo.createResponseEntity(ResultVo.CODE_OK, "保存成功");
        }

        return ResultVo.createResponseEntity(ResultVo.CODE_ERROR, "保存失败");
    }

}
