package site.wattsnwc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 这里需要写注释
 */
@RestController
@RequestMapping("/userserver")
public class CallOrgServerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/callOrg")
    public String call(){
        return restTemplate.getForObject("http://orgservice/orgserver/call",String.class);
    }
}
