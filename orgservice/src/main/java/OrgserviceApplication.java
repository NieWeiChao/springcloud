import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/org")
@EnableEurekaClient
@ComponentScan("site.wattsnwc")
public class OrgserviceApplication {
    @Value("${demo.word:default-value}")
    String strDemoWord;
    @RequestMapping("/detail")
    public String Detail(){
        return "## The detail information about: Organization : with demo word: "+strDemoWord;
    }

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
    public static void main(String[] args) {
        SpringApplication.run(OrgserviceApplication.class, args);
    }
}