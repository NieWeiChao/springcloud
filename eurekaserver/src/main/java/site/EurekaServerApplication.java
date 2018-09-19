package site;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * TODO: 这里需要写注释
 */
@SpringBootApplication
@ComponentScan("site.wattsnwc")
@EnableEurekaServer
@Slf4j
public class EurekaServerApplication {
    public static void main(String[] args) throws IOException {
//        PipedReader r  = new PipedReader();
//        PipedWriter p = new PipedWriter(r);
//        p.write("hahahaha");
//        int msg = 0;
//        while ((msg = r.read()) != -1) {
//            log.info("msg={}", (char) msg);
//        }
        System.out.println((char)64333);
        log.info("12121212");
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
