package cn.x.microservice.stock;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xqa
 * @since 2021/3/5
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.x.microservice.stock.mapper")
@Slf4j
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
        log.info("项目启动完成");
    }

}
