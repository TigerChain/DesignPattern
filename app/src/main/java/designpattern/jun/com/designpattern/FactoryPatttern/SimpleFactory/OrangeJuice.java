
package designpattern.jun.com.designpattern.FactoryPatttern.SimpleFactory ;
import android.util.Log;


/**
 * @Description 具体的产品桔子汁
 * @Creator TigerChain（创建者）
 */
public class OrangeJuice implements IJuice {

    public static final String TAG = "OrangeJuice" ;

    @Override
    public String getName() {
        Log.e(TAG,"我是桔子汁") ;
        return "我是桔子汁";
    }
}
