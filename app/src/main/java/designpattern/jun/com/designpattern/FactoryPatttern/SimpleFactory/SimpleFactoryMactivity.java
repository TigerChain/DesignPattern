package designpattern.jun.com.designpattern.FactoryPatttern.SimpleFactory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import designpattern.jun.com.designpattern.R;

/**
 * @Description 简单工厂界面
 * @Creator TigerChain（创建者）
 */
public class SimpleFactoryMactivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_create_apple,btn_create_orange ,single_button;
    private TextView tv_show_result ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_activity);

        initView();
    }

    private void initView() {
        btn_create_apple = this.findViewById(R.id.btn_create_apple) ;
        btn_create_orange = this.findViewById(R.id.btn_create_orange) ;
        tv_show_result = this.findViewById(R.id.tv_show_result) ;


        btn_create_orange.setOnClickListener(this);
        btn_create_apple.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_create_apple:
                //对使用者来说，屏蔽了具体的细节
                IJuice appleJuice = JuiceFactory.createJuice(JuiceFactory.APPLE) ;
                tv_show_result.setText(appleJuice.getName());
                break ;
            case R.id.btn_create_orange:
                IJuice orangeJuice = JuiceFactory.createJuice(JuiceFactory.ORANGE) ;
                tv_show_result.setText(orangeJuice.getName());


                break ;
            default:
                break ;
        }

    }


}
