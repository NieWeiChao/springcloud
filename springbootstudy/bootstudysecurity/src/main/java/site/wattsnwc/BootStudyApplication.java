package site.wattsnwc;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootStudyApplication {

    private Logger logger = Logger.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(BootStudyApplication.class, args);
    }


}
