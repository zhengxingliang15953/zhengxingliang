package com.example.demo.config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import  org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import  springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import  springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 接口文档访问地址http://localhost:8085/swagger-ui.html
 */
@ConditionalOnProperty(prefix = "hr", name = "swagger-ui-open", havingValue = "true")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("图书馆借阅系统接口文档")
                // 创建人信息
                //.contact(new Contact("郑兴樑",  "https://www.baidu.com",  "1595387183@qq.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("本项目前后端都有我一个人完成,单纯测试某几个接口报错属于正常现象，请不要惊慌")
                .build();
    }
}
