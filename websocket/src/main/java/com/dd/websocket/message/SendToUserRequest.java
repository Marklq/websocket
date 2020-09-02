package com.dd.websocket.message;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 服务端接受到发送消息的请求，需要转发消息给对应的人
 */

@Accessors(chain = true)
@Getter
@Setter
public class SendToUserRequest implements Message {


    public static final String TYPE = "SEND_TO_USER_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;

}
