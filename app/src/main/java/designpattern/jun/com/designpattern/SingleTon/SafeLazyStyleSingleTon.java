package designpattern.jun.com.designpattern.SingleTon;

/**
 * @Description 线程安全的懒汉单例模式
 * @Creator TigerChain（创建者）
 */

public class SafeLazyStyleSingleTon {

    private static  SafeLazyStyleSingleTon instance ;

    private SafeLazyStyleSingleTon(){}

    public static synchronized SafeLazyStyleSingleTon getInstance(){
        if(null == instance){
            instance = new SafeLazyStyleSingleTon();
        }
        return  instance ;
    }
}
