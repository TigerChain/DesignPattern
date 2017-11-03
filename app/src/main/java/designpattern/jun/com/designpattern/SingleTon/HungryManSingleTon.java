package designpattern.jun.com.designpattern.SingleTon;

import android.util.Log;

/**
 * @Description 饿汉式 单例模式
 * @Creator TigerChain（创建者）
 */

public class HungryManSingleTon {

    public static final String TAG = "饿汉式单例" ;

    private static HungryManSingleTon instance = new HungryManSingleTon();

    private HungryManSingleTon(){
        Log.e(TAG,"实例化一次") ;
    }

    public static HungryManSingleTon getInstance(){
        Log.e(TAG+"地址 ",instance.toString()) ;
        return instance ;
    }

    public void doSomthing() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
