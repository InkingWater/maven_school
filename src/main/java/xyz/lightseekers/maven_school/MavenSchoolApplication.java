package xyz.lightseekers.maven_school;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScans({
    @MapperScan("xyz.lightseekers.maven_school.mapper")
})
public class MavenSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavenSchoolApplication.class, args);
    }

}
