package com.thread.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: L-JiaHui
 * @date: 2020/11/29/20:07
 * @description: ip监控 黑白名单设置
 */
public class RequestOriginParserDefinition implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

    @Configuration
    public static class SentinelConfig {

        @PostConstruct
        public void init() {
            //将自定义的阈值提示加载到应用中
            //黑白名单
            WebCallbackManager.setRequestOriginParser(new RequestOriginParserDefinition());
        }
    }
}
