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

    private Button btn_lazy_style_single,
            btn_lazy_style_single_mutithread,
            btn_hungryman_singleton,
            btn_hungryman_mutithread,
            btn_enum_singleton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleton_activity);
        initView() ;
    }

    private void initView() {

        btn_lazy_style_single = this.findViewById(R.id.btn_lazy_style_single) ;
        btn_lazy_style_single_mutithread = this.findViewById(R.id.btn_lazy_style_single_mutithread) ;
        btn_hungryman_singleton = this.findViewById(R.id.btn_hungryman_singleton) ;
        btn_hungryman_mutithread = this.findViewById(R.id.btn_hungryman_mutithread) ;
        btn_enum_singleton = this.findViewById(R.id.btn_enum_singleton) ;

        btn_lazy_style_single.setOnClickListener(this);
        btn_lazy_style_single_mutithread.setOnClickListener(this);
        btn_hungryman_singleton.setOnClickListener(this);
        btn_hungryman_mutithread.setOnClickListener(this);
        btn_enum_singleton.setOnClickListener(this);

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
            //饿汉式单例模式
            case R.id.btn_hungryman_singleton:
                HungryManSingleTon.getInstance() ;
                break ;
            //多线程操作饿汉式单例
            case R.id.btn_hungryman_mutithread:
                mutilThreadTest(Constants.HUNGRYMAN);
                break ;
            //枚举类单例
            case R.id.btn_enum_singleton:
                EnumSingleTon.INSTACE.doSometing();
                break ;
            // 以下几种建议大家自己动手实现，类我都写好了，光在这里调用看效果即可

            // 1、枚举类多线程
            // 2、DCL 单例
            // 3、DCL多线程
            // 4、静态内部类单例
            // 5、静态内部类多线程操作单例
            default:
                break ;
        }

    }

    /**
     * 这个测试时间可以对比出来线程安全和非安全的性能「看谁耗时少」
     * @param flag
     */
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
                        case Constants.HUNGRYMAN:
                            HungryManSingleTon.getInstance().doSomthing();
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
