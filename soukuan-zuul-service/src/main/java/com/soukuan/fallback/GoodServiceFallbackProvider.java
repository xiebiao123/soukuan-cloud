package com.soukuan.fallback;

import com.soukuan.util.ClientHttpResponseBuild;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @Title soukuan-good-service的回退类
 * @date 2018/4/23 22:29
 */
@Component
public class GoodServiceFallbackProvider implements FallbackProvider {

    public static final String ROUTE = "soukuan-good-service";

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
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
