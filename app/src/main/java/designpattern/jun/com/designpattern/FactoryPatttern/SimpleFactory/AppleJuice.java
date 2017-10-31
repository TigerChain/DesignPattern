package designpattern.jun.com.designpattern.FactoryPatttern.SimpleFactory;

import android.util.Log;


/**
 * @Description 一个具体的产品--- 苹果汁
 * @Creator TigerChain（创建者）
 */
public class AppleJuice implements IJuice {

    public static final String TAG = "AppleJuice" ;

    @Override
    public String getName() {
        Log.e(TAG,"我是苹果汁") ;
        return "我是苹果汁";
    }
}
