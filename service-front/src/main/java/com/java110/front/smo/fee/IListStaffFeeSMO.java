package com.java110.front.smo.fee;

import com.java110.core.context.IPageData;
import org.springframework.http.ResponseEntity;

public interface IListStaffFeeSMO {
    public ResponseEntity<String> list(IPageData pd);
}
