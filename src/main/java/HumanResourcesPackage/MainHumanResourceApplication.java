package HumanResourcesPackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"HumanResourcesPackage", "com.company.common.aop"})
public class MainHumanResourceApplication {

  public   static void main(String[] args) {
        SpringApplication.run(MainHumanResourceApplication.class, args);

    }
}

