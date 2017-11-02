package designpattern.jun.com.designpattern.SingleTon;

import android.util.Log;

/**
 * @Description 懒汉式单例模式「非线程安全」
 * @Creator TigerChain（创建者）
 */

public class LazyStyleSIngleTon {

    public static final String TAG = "懒汉式单例" ;

    private static LazyStyleSIngleTon instance ;

    private LazyStyleSIngleTon(){
        Log.e(TAG,"实例化一次") ;
    }

    public static LazyStyleSIngleTon getInstance(){
        if(instance == null ){
            instance = new LazyStyleSIngleTon() ;
        }

        Log.e(TAG,instance.toString()) ;
        return instance ;
    }

    /**
     * 一些其它方法
     */
    public void doSomthing() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
