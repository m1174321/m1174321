package com.fh.book.book.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration    // 配置注解，自动在本类上下文加载一些环境变量信息
@EnableSwagger2   // 使swagger2生效
public class Swagger {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) //api的标题、描述、版本等信息
                .groupName("express-material-api") //接口模块名称
                .select()   // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors
                        .basePackage("com.best.oasis.settlement.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("物料系统RESTful API")
                .termsOfServiceUrl("http://localhost:9000/")
                .description("此API提供接口调用")
                .license("License Version 1.0")
                .version("1.0").build();
    }

}
