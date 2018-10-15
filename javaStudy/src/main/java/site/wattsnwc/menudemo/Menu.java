package site.wattsnwc.menudemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里需要写注释
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Menu {
    private String name;

    private Long id ;

    private Long pId;

    //默认不选中
    private boolean checked = false;

    public Menu(String name, Long id, Long pId) {
        this.name = name;
        this.id = id;
        this.pId = pId;
    }

    private transient List<Menu> subs;

    public void addSubs(Menu menu){
        if(null == this.subs){
            this.subs = new ArrayList<>();
            this.subs.add(menu);
            return;
        }
        this.subs.add(menu);
    }


}
