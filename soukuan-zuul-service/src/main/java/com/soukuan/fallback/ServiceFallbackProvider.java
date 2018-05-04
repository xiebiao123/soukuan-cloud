package com.soukuan.fallback;

import com.soukuan.util.ClientHttpResponseBuild;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @Title 统一的FallbackProvider的回退类
 * @date 2018/4/23 22:29
 */
@Slf4j
@Component
public class ServiceFallbackProvider implements FallbackProvider {

    /**
     *  *代表所有服务名,可以替换成具体的服务名
     */
    public static final String ROUTE = "*";

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        if (cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
            log.info("Excption {}",reason);
        }
        return ClientHttpResponseBuild.fallbackResponse(ROUTE);
    }

    @Override
    public String getRoute() {
        return ROUTE;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return ClientHttpResponseBuild.fallbackResponse(ROUTE);
    }

}
