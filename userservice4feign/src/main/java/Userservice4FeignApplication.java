import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/user")
@EnableEurekaClient
@EnableFeignClients(basePackages="site.wattsnwc")
@ComponentScan("site.wattsnwc")
public class Userservice4FeignApplication {
//    @LoadBalanced
//    @Bean
//    public RestTemplate newRest(){
//        return new RestTemplate();
//    }

    @RequestMapping("/detail")
    public String Detail(){
        return "## Detail information333about : User ";
    }
    public static void main(String[] args) {
        SpringApplication.run(Userservice4FeignApplication.class, args);
    }
}