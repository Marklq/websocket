package com.dd.websocket.messageHandler;

import com.dd.websocket.message.SendResponse;
import com.dd.websocket.message.SendToAllRequest;
import com.dd.websocket.message.SendToUserRequest;
import com.dd.websocket.util.WebSocketUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;

@Component
public class SendToAllHandler implements MessageHandler<SendToAllRequest> {
    @Override
    public void execute(WebSocketSession session, SendToAllRequest message) {
        // 这里，假装直接成功
        SendResponse sendResponse = new SendResponse().setMsgId(message.getMsgId()).setCode(0);
        WebSocketUtil.send(session, SendResponse.TYPE, sendResponse);

        // 创建转发的消息
        SendToUserRequest sendToUserRequest = new SendToUserRequest().setMsgId(message.getMsgId())
                .setContent(message.getContent());
        // 广播发送
        WebSocketUtil.broadcast(SendToUserRequest.TYPE, sendToUserRequest);

    }

    @Override
    public String getType() {
        return SendToAllRequest.TYPE;
    }
}
