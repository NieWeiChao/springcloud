import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
@EnableHystrixDashboard
@ComponentScan("site.wattsnwc")
public class DashboardserviceApplication {
    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }
    public static void main(String[] args) {
        SpringApplication.run(DashboardserviceApplication.class, args);
    }
}