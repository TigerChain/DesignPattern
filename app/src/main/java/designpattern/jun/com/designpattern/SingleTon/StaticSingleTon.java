package designpattern.jun.com.designpattern.SingleTon;

/**
 * @Description 静态方法单例模式
 * @Creator TigerChain（创建者）
 */

public class StaticSingleTon {

    private StaticSingleTon(){}



    /**
     * 静态内部类 实现了线程安全，并且是延时初始化
     */
    private static class SingleTonHolder{
        private static final StaticSingleTon instance = new StaticSingleTon() ;
    }

    /**
     * 调用此方法时候才会实例化
     * @return
     */

    public static StaticSingleTon getInstance(){
        return SingleTonHolder.instance ;
    }

}
