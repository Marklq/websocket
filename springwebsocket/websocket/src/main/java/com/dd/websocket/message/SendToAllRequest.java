package com.dd.websocket.message;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 发送给所有人的消息
 */

@Accessors(chain = true)
@Getter
@Setter
public class SendToAllRequest implements Message {


    public static final String TYPE = "SEND_TO_ALL_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;


}
