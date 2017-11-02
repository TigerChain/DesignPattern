package designpattern.jun.com.designpattern.SingleTon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.CountDownLatch;

import designpattern.jun.com.designpattern.R;
import designpattern.jun.com.designpattern.utils.ThreadCountDown;

/**
 * @Description 单例的显示界面
 * @Creator TigerChain（创建者）
 */
public class SingleTonActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_lazy_style_single,btn_lazy_style_single_mutithread ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleton_activity);

        initView() ;
    }

    private void initView() {

        btn_lazy_style_single = this.findViewById(R.id.btn_lazy_style_single) ;
        btn_lazy_style_single_mutithread = this.findViewById(R.id.btn_lazy_style_single_mutithread) ;

        btn_lazy_style_single.setOnClickListener(this);
        btn_lazy_style_single_mutithread.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            //非线程安全的懒汉式单例
            case R.id.btn_lazy_style_single:
                LazyStyleSIngleTon.getInstance() ;
                break ;
            //线程安全的懒汉式单例
            case R.id.btn_lazy_style_single_mutithread:
                mutilThreadTest(Constants.SAFELAZYSTYLE);
                break ;
            default:
                break ;
        }

    }

    private void mutilThreadTest(final int flag) {
        // 这里来500个线程是为了统计时间
        int threadNum = 500 ;

        CountDownLatch startGate = new CountDownLatch(1) ;

        CountDownLatch endGate = new CountDownLatch(threadNum) ;

        try {
            new ThreadCountDown(startGate, endGate, threadNum, new ThreadCountDown.CallBackListener() {
                @Override
                public void callback() {
                    switch (flag){
                        case Constants.LAZYSTYLE:
                            LazyStyleSIngleTon.getInstance().doSomthing();
                            break ;
                        case Constants.SAFELAZYSTYLE:
                            SafeLazyStyleSingleTon.getInstance().doSomthing();
                            break ;
                        default:
                            break ;
                    }
                }
            }).timeTask() ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
