package designpattern.jun.com.designpattern.Strategy;

import android.util.Log;

/**
 * @Description 公共汽车出行
 * @Creator TigerChain（创建者）
 */
public class TravelByBus implements ITravelStrategy{

    @Override
    public String travelMethod() {
        Log.e("出行方式---","坐大巴") ;
        return "出行方式---坐大巴" ;
    }
}
