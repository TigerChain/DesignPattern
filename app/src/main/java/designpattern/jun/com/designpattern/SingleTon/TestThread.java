package designpattern.jun.com.designpattern.SingleTon;


import designpattern.jun.com.designpattern.utils.ThreadCountDown;

/**
 * @Description 线程测试类
 * @Creator TigerChain（创建者）
 */
public class TestThread extends Thread{

    public TestThread(ThreadCountDown.TimingWork timingWork) {
        super(timingWork);
    }
}
