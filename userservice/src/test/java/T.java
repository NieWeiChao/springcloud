import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

/**
 * TODO: 这里需要写注释
 */

public class T {

    @Test
    public void test(){
        int a = 3;
        a |= 2;
        assertThat("哈哈",0,lessThan(-1));
    }
}
