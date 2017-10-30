package designpattern.jun.com.designpattern.SingleTon;

/**
 * @Description 懒汉式单例模式
 * @Creator TigerChain（创建者）
 */

public class LazyStyleSIngleTon {

    private static LazyStyleSIngleTon instance ;

    private LazyStyleSIngleTon(){}

    public static LazyStyleSIngleTon getInstance(){
        if(instance == null ){
            instance = new LazyStyleSIngleTon() ;
        }
        return instance ;
    }
}
