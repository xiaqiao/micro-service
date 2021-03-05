package cn.x.microservice.user;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xqa
 * @since 2021/3/3
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.x.microservice.user.mapper")
@Slf4j
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        log.info("项目启动完成");
    }

}
