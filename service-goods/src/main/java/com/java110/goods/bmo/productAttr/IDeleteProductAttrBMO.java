package com.java110.goods.bmo.productAttr;
import com.java110.po.productAttr.ProductAttrPo;
import org.springframework.http.ResponseEntity;

public interface IDeleteProductAttrBMO {


    /**
     * 修改产品属性
     * add by wuxw
     * @param productAttrPo
     * @return
     */
    ResponseEntity<String> delete(ProductAttrPo productAttrPo);


}
