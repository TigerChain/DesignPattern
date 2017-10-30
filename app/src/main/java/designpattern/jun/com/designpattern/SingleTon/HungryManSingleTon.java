package designpattern.jun.com.designpattern.SingleTon;

/**
 * @Description 饿汉式 单例模式
 * @Creator TigerChain（创建者）
 */

public class HungryManSingleTon {

    private static HungryManSingleTon instance = new HungryManSingleTon();

    private HungryManSingleTon(){}

    public static HungryManSingleTon getInstance(){
        return instance ;
    }

}
