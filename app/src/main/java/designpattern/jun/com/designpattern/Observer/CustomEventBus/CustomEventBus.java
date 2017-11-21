package designpattern.jun.com.designpattern.Observer.CustomEventBus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description 被观察者
 * @Creator TigerChain（创建者）
 */
public class CustomEventBus implements IEventBus{

    // 观察者是任意的对象
    private Object object ;

    // 采用线程安全的懒汉式单例
    private static CustomEventBus instance ;
    private CustomEventBus(){}
    public static CustomEventBus getInstance(){
        if(instance ==null){
            synchronized (CustomEventBus.class){
                if(instance == null){
                    instance = new CustomEventBus() ;
                }
            }
        }
        return instance ;
    }


    @Override
    public void register(Object object) {
        this.object = object ;
    }

    @Override
    public void unRegister(Object object) {

    }

    @Override
    public void post(String str) {

        try {
            //使用反射得到类
            Class clazz = object.getClass() ;
            //取得反射得到类中的 onEvent 方法
            Method method = clazz.getMethod("onEvent",String.class) ;
            //执行 onEvent 方法
            method.invoke(object,str) ;

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
