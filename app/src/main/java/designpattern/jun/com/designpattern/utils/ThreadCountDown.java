package designpattern.jun.com.designpattern.utils;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

import designpattern.jun.com.designpattern.SingleTon.TestThread;

/**
 * @Description 统计多个线程执行完成任务的所用的时间
 * @Creator TigerChain（创建者）
 */
public class ThreadCountDown {
    private CountDownLatch startGate ;
    private CountDownLatch endGate ;

    /**线程的数量**/
    private int threadNum ;

    public ThreadCountDown(CountDownLatch startGate,CountDownLatch endGate,int threadNum,CallBackListener callBackListener){
        this.startGate = startGate ;
        this.endGate = endGate ;
        this.threadNum = threadNum ;
        this.callBackListener = callBackListener ;
    }

    public class TimingWork implements Runnable{

        @Override
        public void run() {
            try {
                startGate.await();
//                Log.e("线程获取懒汉式单例-----", LazyStyleSIngleTon.getInstance().toString()) ;
               if(callBackListener !=null){
                   //调用者自己去调用是地个单例
                   callBackListener.callback();
               }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                endGate.countDown();
            }

        }

    }


    public long timeTask() throws InterruptedException {
        for(int i=0;i<threadNum;i++){
            TestThread testThread = new TestThread(new TimingWork()) ;
            testThread.start();
        }

        long startTime = System.currentTimeMillis() ;

        startGate.countDown();

        endGate.await();

        long endTime = System.currentTimeMillis() ;

        Log.e("总用时  ",(endTime-startTime)+" ms") ;

        return endTime-startTime ;

    }


    public interface CallBackListener{
        void callback() ;
    }

    /***
     * 调用者自己去调用何种单例
     */
    private CallBackListener callBackListener ;

}
