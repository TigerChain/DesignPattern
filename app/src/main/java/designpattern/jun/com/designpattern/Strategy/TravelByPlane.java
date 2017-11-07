package designpattern.jun.com.designpattern.Strategy;

import android.util.Log;

/**
 * @Description 飞机出行
 * @Creator TigerChain（创建者）
 */
public class TravelByPlane implements ITravelStrategy {
    @Override
    public String travelMethod() {

        Log.e("出行方式---","坐飞机") ;
        return "出行方式---坐飞机" ;
    }
}
