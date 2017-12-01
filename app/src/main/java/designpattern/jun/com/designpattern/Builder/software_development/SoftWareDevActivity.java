package designpattern.jun.com.designpattern.Builder.software_development;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import designpattern.jun.com.designpattern.R;

/**
 * @Description
 * @Creator junjun（创建者）
 */
public class SoftWareDevActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttn01 ;
    private TextView tv01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.softwaredev_activity);

        initView() ;
    }

    private void initView() {
        this.buttn01 = this.findViewById(R.id.button01) ;
        this.tv01 = findViewById(R.id.tv01) ;

        this.buttn01.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button01:
                // 技术主管
                CTOBuilder ctoBuilder = new DeveloperA() ;
                // 产品经理
                PMDirector pmDirector = new PMDirector() ;
                // 产品经理让主管实现用户需求
                pmDirector.director(ctoBuilder);
                SoftWareProduct softWareProduct = pmDirector.getSoftWare() ;
                tv01.setText(
                        softWareProduct.getCaiJiXuqiu()+"\n"
                        +softWareProduct.getHuaJiaGouTu()+"\n"
                        +softWareProduct.getDaJianGuangJia()+"\n"
                        +softWareProduct.getBianXieMoKuai()+"\n"
                );
                break ;


            default:
                break ;
        }
    }
}
