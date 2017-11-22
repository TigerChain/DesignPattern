package designpattern.jun.com.designpattern.Observer.CustomEventBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import designpattern.jun.com.designpattern.R;

/**
 * @Description
 * @Creator TigerChain（创建者）
 */
public class CustomBusActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_send_event ;
    private TextView tv_recive_message ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_custombus);

        initView() ;
        // 注册，这里的 CustomBusActivity 就是观察者
        CustomEventBus.getInstance().register(this);
    }

    private void initView() {
        this.btn_send_event = this.findViewById(R.id.btn_send_event) ;
        this.tv_recive_message = this.findViewById(R.id.tv_recive_message) ;
        this.btn_send_event.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send_event:
                CustomEventBus.getInstance().post("发送一条信息");
                break ;
            default:
                break ;
        }
    }

    // 这里只实现了以当前线程简单的 eventbus 如果要切换线程那么就使用线程间通信 Handler + 线程检查即可
    // 观察者收到通知显示
    public void onEvent(String string){
        Toast.makeText(CustomBusActivity.this,string,Toast.LENGTH_SHORT).show();
        tv_recive_message.setText("收到信息："+string);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CustomEventBus.getInstance().unRegister(this);
    }
}
