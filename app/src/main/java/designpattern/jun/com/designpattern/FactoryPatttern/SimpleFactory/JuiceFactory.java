package designpattern.jun.com.designpattern.FactoryPatttern.SimpleFactory;

/**
 * @Description  果汁机---工厂
 * @Creator junjun（创建者）
 */
public class JuiceFactory {

    public static final String APPLE = "apple" ;
    public static final String ORANGE = "orange" ;

    /**
     * 根据名称来生产不同的果汁
     * @param name
     * @return
     */
    public static IJuice createJuice(String name){


        IJuice iJuice = null;

        if(name.equals(APPLE)){
            iJuice = new AppleJuice() ;
        }else if(name.equals(ORANGE)){
            iJuice = new OrangeJuice() ;
        }

        return iJuice ;
    }
}
