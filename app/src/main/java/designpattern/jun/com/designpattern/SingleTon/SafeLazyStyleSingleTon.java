package designpattern.jun.com.designpattern.SingleTon;

import android.util.Log;


/**
 * @Description 线程安全的懒汉单例模式
 * @Creator TigerChain（创建者）
 */

public class SafeLazyStyleSingleTon  {

    public static final String TAG = "线程安全的懒汉式单例" ;

    private static  SafeLazyStyleSingleTon instance ;

    private SafeLazyStyleSingleTon(){
        Log.e(TAG,"实例化一次") ;
    }

    public static synchronized SafeLazyStyleSingleTon getInstance(){
        if(null == instance){
            instance = new SafeLazyStyleSingleTon();
        }
        Log.e(TAG,instance.toString()) ;
        return  instance ;
    }




    public void doSomthing() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
