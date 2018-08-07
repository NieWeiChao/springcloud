package site.wattsnwc.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * TODO: 这里需要写注释
 * @author watts
 */
@Component
@Data
public class WattsProperties {

    @Value("${site.wattsnwc.name}")
    private String name;

    @Value("${site.wattsnwc.title}")
    private String title;
    @Value("${site.wattsnwc.random}")
    private String random;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
