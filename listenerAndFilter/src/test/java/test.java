import com.FilterDemo.autoLogin.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class test {
    @Test
    public void tests() {
        HashMap hashMap = new HashMap();
        hashMap.put("name",null);
        Object name = hashMap.get("name");
        System.out.println(name);
    }
}
