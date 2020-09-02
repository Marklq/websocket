package com.dd.websocket.message;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 用户认证成功之后，会通知加入群聊
 */

@Accessors(chain = true)
@Getter
@Setter
public class UserJoinNoticeRequest implements Message {
    public static final String TYPE = "USER_JOIN_NOTICE_REQUEST";

    /**
     * 昵称
     */
    private String nickname;

}
