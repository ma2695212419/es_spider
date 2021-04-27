package co.laomag.es_spider.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.*.*"})
@MapperScan(value = {"co"})
public class EsSpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsSpiderApplication.class, args);
    }

}
