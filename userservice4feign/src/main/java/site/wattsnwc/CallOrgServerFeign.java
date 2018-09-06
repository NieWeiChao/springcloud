package site.wattsnwc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "orgservice")
public interface CallOrgServerFeign {

    @RequestMapping(value = "/orgserver/call",method = RequestMethod.GET)
    String callOrg();
}