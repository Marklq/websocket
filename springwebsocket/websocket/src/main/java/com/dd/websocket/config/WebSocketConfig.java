package com.dd.websocket.config;

import com.dd.websocket.springwebsocket.DemoWebSocketShakeInterceptor;
import com.dd.websocket.springwebsocket.DemoWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@ComponentScan("com.dd.websocket")
@EnableWebSocket//开启spring websocket 注解
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * 实现 WebSocketConfigurer 接口，自定义 WebSocket 的配置。
     * #registerWebSocketHandlers(registry) 方法，
     * 配置 WebSocket 处理器、拦截器，以及允许跨域。
     *
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this.webSocketHandler(), "/") // 配置处理器
                .addInterceptors(new DemoWebSocketShakeInterceptor()) // 配置拦截器
                .setAllowedOrigins("*"); // 解决跨域问题
    }

    @Bean
    public DemoWebSocketHandler webSocketHandler() {
        return new DemoWebSocketHandler();
    }

    @Bean
    public DemoWebSocketShakeInterceptor webSocketShakeInterceptor() {
        return new DemoWebSocketShakeInterceptor();
    }

}
