package com.dd.websocket.message;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 用户认证相应
 */
@Accessors(chain = true)
@Getter
@Setter
public class AuthResponse implements Message {

    public static final String TYPE = "AUTH_RESPONSE";

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应提示
     */
    private String message;

    public AuthResponse setCode(Integer code) {
        this.code = code;
        return this;
    }
}
