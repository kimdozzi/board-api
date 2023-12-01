package com.board.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class FullstackApplication {
    public static void main(String[] args) {
        SpringApplication.run(FullstackApplication.class, args);
    }
    //==CORS=//
	/*
    * REST API를 postman 같은 툴로 테스트할 때는 CORS 문제가 생기지 않는다.
    * 하지만 리액트, 뷰와 같은 프레임웍을 사용해서 브라우저에서 API를 호출시 만일
    * 프런트서버와 백엔드 서버가 각각 존재한다면 cross domain 이슈가 발생한다.
    * 물론 운영환경에서는 rever proxy를 적용하여 프런트를 거쳐서 백엔드로 가도록
    * 설정하기 때문에 해당 사항이 없다. 또한 개발환경에서도 요즘은 package.json에서
    *  proxy 를 설정하면 CORS 문제는 생기지 않는다. 개발환경에 대비해서 main 클래스가 있는곳에 CORS 필터를 등록한다 */

    //CORS 필터
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern(CorsConfiguration.ALL);
        config.addAllowedHeader("*");
        config.addExposedHeader("Authorization");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
