package com.java110.goods.bmo.storeOrder;
import com.java110.po.storeOrder.StoreOrderPo;
import org.springframework.http.ResponseEntity;

public interface IDeleteStoreOrderBMO {


    /**
     * 修改购物车
     * add by wuxw
     * @param storeOrderPo
     * @return
     */
    ResponseEntity<String> delete(StoreOrderPo storeOrderPo);


}
