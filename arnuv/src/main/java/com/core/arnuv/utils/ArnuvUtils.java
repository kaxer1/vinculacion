package com.core.arnuv.utils;

import org.springframework.http.HttpHeaders;

public class ArnuvUtils {

    public static HttpHeaders validaRegeneracionToken() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("token", "kldjsfdsfjlksdj");
        return responseHeaders;
    }
}
