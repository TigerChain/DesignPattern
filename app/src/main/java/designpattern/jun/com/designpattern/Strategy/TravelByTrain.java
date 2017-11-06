package designpattern.jun.com.designpattern.Strategy;

import android.util.Log;

/**
 * @Description 火车出行
 * @Creator TigerChain（创建者）
 */
public class TravelByTrain implements ITravelStrategy {

    @Override
    public String travelMethod() {
        Log.e("出行方式---","坐火车") ;
        return "出行方式---坐火车" ;
    }
}
