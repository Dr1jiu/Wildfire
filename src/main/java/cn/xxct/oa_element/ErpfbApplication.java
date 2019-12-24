package cn.xxct.oa_element;

import cn.xxct.oa_element.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan("cn.xxct.oa_element.mapper,cn.xxct.oa_element.service.impl")
@SpringBootApplication
public class ErpfbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpfbApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        IdWorker idWorker = new IdWorker();
        return idWorker;
    }

}
