package com.java110.goods.bmo.groupBuyProductSpec.impl;

import com.java110.core.annotation.Java110Transactional;
import com.java110.goods.bmo.groupBuyProductSpec.IUpdateGroupBuyProductSpecBMO;
import com.java110.intf.goods.IGroupBuyProductSpecInnerServiceSMO;
import com.java110.po.groupBuyProductSpec.GroupBuyProductSpecPo;
import com.java110.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("updateGroupBuyProductSpecBMOImpl")
public class UpdateGroupBuyProductSpecBMOImpl implements IUpdateGroupBuyProductSpecBMO {

    @Autowired
    private IGroupBuyProductSpecInnerServiceSMO groupBuyProductSpecInnerServiceSMOImpl;

    /**
     * @param groupBuyProductSpecPo
     * @return 订单服务能够接受的报文
     */
    @Java110Transactional
    public ResponseEntity<String> update(GroupBuyProductSpecPo groupBuyProductSpecPo) {

        int flag = groupBuyProductSpecInnerServiceSMOImpl.updateGroupBuyProductSpec(groupBuyProductSpecPo);

        if (flag > 0) {
            return ResultVo.createResponseEntity(ResultVo.CODE_OK, "保存成功");
        }

        return ResultVo.createResponseEntity(ResultVo.CODE_ERROR, "保存失败");
    }

}
