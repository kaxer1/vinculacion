package com.core.arnuv.request;

import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class LoginRequest {
    @Comment("serial telefono")
    private String serial;

    @Comment("Username")
    private String username;

    @Comment("Password")
    private String password;
}
