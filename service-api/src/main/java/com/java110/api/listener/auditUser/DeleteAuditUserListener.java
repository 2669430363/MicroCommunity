package com.java110.api.listener.auditUser;

import com.alibaba.fastjson.JSONObject;
import com.java110.api.bmo.auditUser.IAuditUserBMO;
import com.java110.api.listener.AbstractServiceApiPlusListener;
import com.java110.utils.util.Assert;
import com.java110.core.context.DataFlowContext;
import com.java110.core.event.service.api.ServiceDataFlowEvent;

import com.java110.core.annotation.Java110Listener;
import com.java110.utils.constant.ServiceCodeAuditUserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

/**
 * 保存小区侦听
 * add by wuxw 2019-06-30
 */
@Java110Listener("deleteAuditUserListener")
public class DeleteAuditUserListener extends AbstractServiceApiPlusListener {

    @Autowired
    private IAuditUserBMO auditUserBMOImpl;
    @Override
    protected void validate(ServiceDataFlowEvent event, JSONObject reqJson) {
        //Assert.hasKeyAndValue(reqJson, "xxx", "xxx");
        Assert.hasKeyAndValue(reqJson, "storeId", "必填，请填写商户ID");
        Assert.hasKeyAndValue(reqJson, "auditUserId", "审核ID不能为空");

    }

    @Override
    protected void doSoService(ServiceDataFlowEvent event, DataFlowContext context, JSONObject reqJson) {

        auditUserBMOImpl.deleteAuditUser(reqJson, context);
    }

    @Override
    public String getServiceCode() {
        return ServiceCodeAuditUserConstant.DELETE_AUDITUSER;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public int getOrder() {
        return DEFAULT_ORDER;
    }




}
