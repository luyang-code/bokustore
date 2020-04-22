package com.tsc.graduateproj.bokubookstore.config;

import org.apache.catalina.Context;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * 解除使用的内置tomcat对cookie的限制的报错，可以通过LegacyCookieProcessor进行处理
 */
@Component
public class EmbeddedTomcatConfig implements WebServerFactoryCustomizer {
    @Override
    public void customize(WebServerFactory factory) {
        ((TomcatServletWebServerFactory)factory).addContextCustomizers(new TomcatContextCustomizer() {
            @Override
            public void customize(Context context) {
                context.setCookieProcessor(new LegacyCookieProcessor());
            }
        });
    }
}
