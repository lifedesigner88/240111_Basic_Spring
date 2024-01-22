package com.encore.basic.servletjsp;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


// http://localhost:8080/swagger-ui/ 접속할 때 마지막 / 중요
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select() // 어떤 컨트롤러 또는 어떤 api 를 포함시킬지 선택
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())  // 모든 컨트롤러
//                .paths(PathSelectors.ant("/rest/**")) // ** 하위폴더까지
                .build();
    }
// 로그인 기능을 없애려면 jwt, session 등의 별도 설정 필요
}
