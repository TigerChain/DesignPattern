package designpattern.jun.com.designpattern.Strategy;

/**
 * @Description 出行的上下文
 * @Creator junjun（创建者）
 */
public class TravelContext {

    private ITravelStrategy iTravelStrategy ;

    public TravelContext(ITravelStrategy iTravelStrategy){
        this.iTravelStrategy = iTravelStrategy ;
    }

    /***
     * 出行，这里为了演示所以把结果返回了
     */
    public String travle(){
        return iTravelStrategy.travelMethod();
    }

}
