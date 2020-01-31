import com.WaitDecorator;
import com.impl.WaiterImpl;
import com.interfaces.Waiter;
import org.junit.Test;

public class Demo {
    @Test
    public void test(){
        Waiter waiter = new WaiterImpl();
        waiter.service();
    }

    @Test
    public void test1(){
        WaitDecorator waitDecorator = new WaitDecorator(new WaiterImpl());
        waitDecorator.service();
    }
}
