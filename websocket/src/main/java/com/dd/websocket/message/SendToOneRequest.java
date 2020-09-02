package com.dd.websocket.message;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 发送给指定人的 私聊消息
 */

@Accessors(chain = true)
@Getter
@Setter
public class SendToOneRequest implements Message {


    public static final String TYPE = "SEND_TO_ONE_REQUEST";

    /**
     * 发送给的用户
     */
    private String toUser;
    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;


}
