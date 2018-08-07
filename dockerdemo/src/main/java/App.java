import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("site.wattsnwc")
public class App {
    @RequestMapping("/")
    public String Hello(){
        return "Hello, Spring Boot...";
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}