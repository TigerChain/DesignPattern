package designpattern.jun.com.designpattern.Observer.CustomEventBus;

/**
 * @Description 抽象出被观察者
 * @Creator TigerChain（创建者）
 */
public interface IEventBus {
    // 订阅
    void register(Object object) ;
    // 取消订阅
    void unRegister(Object object) ;
    // 发送通知
    void post(String str) ;
}
