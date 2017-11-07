package designpattern.jun.com.designpattern.Strategy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import designpattern.jun.com.designpattern.R;

/**
 * @Description 策略模式的界面
 * @Creator TigerChain（创建者）
 */
public class StrategyActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btn_select_method ;
    private TextView tv_travel_result ;

    private String[] travels= {"坐飞机","坐火车","坐大巴"} ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_strategy);

        initView() ;
    }

    private void initView() {
        btn_select_method = this.findViewById(R.id.btn_select_method) ;
        tv_travel_result = this.findViewById(R.id.tv_travel_result) ;

        btn_select_method.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_select_method:
                AlertDialog.Builder builder = new AlertDialog.Builder(StrategyActivity.this) ;
                builder.setItems(travels, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 以下就是各个策略
                        switch (which){
                            case 0:
                                ITravelStrategy iTravelStrategy = new TravelByPlane() ;
                                TravelContext travelContext = new TravelContext(iTravelStrategy) ;
                                tv_travel_result.setText(travelContext.travle());
                                break ;
                            case 1:
                                ITravelStrategy travelByTrain = new TravelByTrain() ;
                                TravelContext travelContext1 = new TravelContext(travelByTrain) ;
                                tv_travel_result.setText(travelContext1.travle());
                                break ;
                            case 2:
                                ITravelStrategy travelByBus = new TravelByBus() ;
                                TravelContext travelContext2 = new TravelContext(travelByBus) ;
                                tv_travel_result.setText(travelContext2.travle());
                                break ;
                            default:
                                break ;
                        }
                    }
                }) ;
                AlertDialog dialog = builder.create() ;
                dialog.show();

                break ;
            default:
                break ;
        }
    }
}
