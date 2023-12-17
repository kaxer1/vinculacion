package com.core.arnuv.response;

import lombok.Data;

import java.util.Map;

@Data
public class RespuestaComun {
    public String mensaje;
    public Map<String, Object> data;
    public String codigo;
}
