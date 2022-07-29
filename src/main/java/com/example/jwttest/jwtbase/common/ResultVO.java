package com.example.jwttest.jwtbase.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResultVO implements Serializable {
    private static final long serialVersionUID = -5359028332240046810L;

    public static Map<String, Object> result(ResultEnum respCode, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", null);
        map.put("success",success);
        return map;
    }
    public final static Map<String, Object> result(ResultEnum respCode, String jwtToken, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jwtToken",jwtToken);
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", null);
        map.put("success",success);
        return map;
    }
}
