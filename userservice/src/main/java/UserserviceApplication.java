import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/user")
@EnableEurekaClient
@ComponentScan("site.wattsnwc")
public class UserserviceApplication {
    @LoadBalanced
    @Bean
    public RestTemplate newRest(){
        return new RestTemplate();
    }

    @RequestMapping("/detail")
    public String Detail(){
        return "## Detail information about : User ";
    }
    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }
}