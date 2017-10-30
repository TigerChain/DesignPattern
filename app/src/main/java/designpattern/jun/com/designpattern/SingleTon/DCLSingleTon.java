package designpattern.jun.com.designpattern.SingleTon;

/**
 * @Description 双检锁单例模式
 * @Creator TigerChain（创建者）
 */

public class DCLSingleTon {

    private static DCLSingleTon instance ;

    private DCLSingleTon(){}

    public static DCLSingleTon getInstance(){
        if(null == instance){
            synchronized (DCLSingleTon.class){
                if(null == instance){
                    instance = new DCLSingleTon() ;
                }
            }
        }
        return instance ;
    }
}
