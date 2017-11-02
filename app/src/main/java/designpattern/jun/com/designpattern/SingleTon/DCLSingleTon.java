package designpattern.jun.com.designpattern.SingleTon;

/**
 * @Description 双检锁单例模式
 * @Creator TigerChain（创建者）
 */

public class DCLSingleTon  {

    private static DCLSingleTon instance ;

    private DCLSingleTon(){}

    public static DCLSingleTon getInstance(){
        //第一次检查
        if(null == instance){
            synchronized (DCLSingleTon.class){
                // 第二次检查
                if(null == instance){
                    instance = new DCLSingleTon() ;
                }
            }
        }
        return instance ;
    }

}
