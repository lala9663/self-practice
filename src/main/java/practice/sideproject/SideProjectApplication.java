package practice.sideproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"practice.sideproject.mapper"})
public class SideProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SideProjectApplication.class, args);
    }

}
