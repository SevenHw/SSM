package com.seven.core.knife4j;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger配置
 */
@Configuration
@EnableSwagger2WebMvc
@EnableKnife4j
public class Knife4jConfig {
    /**
     * 后台API分组
     *
     * @return
     */
    @Bean(value = "appApi")
    public Docket appApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("SSM")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.seven.matlab"))
                .paths(PathSelectors.any())
                .build()
//                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
        return docket;
    }

    /**
     * 获取token鉴权
     * @return
     */
/*    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("Token", "token", "header"));
        return apiKeys;
    }*/

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                // 包含login、healthy的不加Token验证
                .forPaths(PathSelectors.regex("^((?!login).)*$")
                        .and(PathSelectors.regex("^((?!healthy).)*$"))).build());
        return securityContexts;
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Token", authorizationScopes));
        return securityReferences;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SSM")
                .description("SEVEN")
                .contact(new Contact("SSM", "", null))
                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0")
                .build();
    }

}
