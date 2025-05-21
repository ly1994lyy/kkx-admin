package org.kkx.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                // 配置接口文档基本信息
                .info(this.getApiInfo())
                ;
    }

    private Info getApiInfo() {
        return new Info()
                // 配置文档标题
                .title("卡卡西admin")
                // 配置文档描述
                .description("卡卡西admin接口文档")
                // 配置作者信息
                .contact(new Contact().name("前端卡卡西").email("1141730852@qq.com"))
                // 配置版本号
                .version("1.0");
    }

}