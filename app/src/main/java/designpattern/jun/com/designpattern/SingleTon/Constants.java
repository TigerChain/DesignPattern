package designpattern.jun.com.designpattern.SingleTon;

/**
 * @Description 一些常量
 * @Creator TigerChain（创建者）
 */
public class Constants {
    /**懒汉式标志*/
    public static final int LAZYSTYLE     = 0x0001 ;
    /**线程安全懒汉式标志*/
    public static final int SAFELAZYSTYLE = 0x0002 ;
    /**饿汉式标志*/
    public static final int HUNGRYMAN     = 0x0003 ;
    /**线程安全饿汉式标志*/
    public static final int SAFEHUNGRYMAN = 0x0004 ;
}
