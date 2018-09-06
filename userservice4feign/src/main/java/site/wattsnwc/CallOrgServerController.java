package site.wattsnwc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里需要写注释
 */
@RestController
@RequestMapping("/userserver")
public class CallOrgServerController {

    @Autowired
    private CallOrgServerFeign callOrgServerFeign;

    @RequestMapping("/callOrg")
    public String call(){
        return callOrgServerFeign.callOrg();

    }
}
