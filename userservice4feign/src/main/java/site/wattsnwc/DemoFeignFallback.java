package site.wattsnwc;

import org.springframework.stereotype.Component;

@Component
public class DemoFeignFallback implements CallOrgServerFeign {

	@Override public String callOrg() {
		return "fail error";
	}
}
