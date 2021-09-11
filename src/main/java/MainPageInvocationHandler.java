import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MainPageInvocationHandler implements InvocationHandler {

    private MainPage mainPage;

    public MainPageInvocationHandler(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.isAnnotationPresent(Selector.class)){
            Selector sel = method.getAnnotation(Selector.class);
            return sel.xpath().toString();
        }
        else
            return null;
    }
}
