package site.wattsnwc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里需要写注释
 */
@RestController
@RequestMapping("/orgserver")
public class OrgServer {
    @Value("${server.port}")
    String port;
    @RequestMapping("/call")
    public String call(){
        return "call result from " + port;
    }
}
