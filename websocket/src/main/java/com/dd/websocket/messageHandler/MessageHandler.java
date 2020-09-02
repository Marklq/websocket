package com.dd.websocket.messageHandler;

import com.dd.websocket.message.Message;

import javax.websocket.Session;

/**
 * 消息处理器接口
 * @param <T>
 */
public interface MessageHandler<T extends Message> {


    /**
     * 执行处理消息，
     *
     * @param session 会话
     * @param message 消息
     */
    void execute(Session session, T message);


    /**
     *
     * @return 消息类型，就是每个实现类上的 TYPE静态字段
     */
    String getType();

}
