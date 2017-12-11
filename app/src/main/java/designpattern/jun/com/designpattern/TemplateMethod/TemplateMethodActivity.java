package designpattern.jun.com.designpattern.TemplateMethod;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import designpattern.jun.com.designpattern.R;

/**
 * @Description 带有公共头的 Activity
 * @Creator junjun（创建者）
 */
public abstract class TemplateMethodActivity extends AppCompatActivity {

    private Button titlebar_btn_left,titlebar_btn_right ;
    private TextView titlebar_tv_center ;
    private RelativeLayout content ;

    private View titleView ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.templatemethod_activity);
        initView() ;

        setContentLayout(getLayoutResID());
        getLayoutResID() ;
        
        init() ;
    }
    // 初始化操作
    protected abstract void init();
    // 取得子布局
    protected abstract int getLayoutResID();

    private void setContentLayout(int ResId) {
        LayoutInflater.from(this).inflate(ResId, content);
    }

    private void initView(){
        titleView = this.findViewById(R.id.titleBarView) ;

        titlebar_btn_left = titleView.findViewById(R.id.titlebar_btn_left) ;
        titlebar_tv_center = titleView.findViewById(R.id.titlebar_tv_center) ;
        titlebar_btn_right = titleView.findViewById(R.id.titlebar_btn_right) ;

        content = this.findViewById(R.id.content) ;
    }

    protected void initleftButton(String str){
        if(!TextUtils.isEmpty(str)){
            titlebar_btn_left.setText(str);
            // 默认的方法是关闭 activity
            titlebar_btn_left.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    TemplateMethodActivity.this.finish();
                }
            });
        }
    }

    protected void initLeftButton(String str, final LeftButtonClickListener leftButtonClickListener){
        if(!TextUtils.isEmpty(str)){
            titlebar_btn_left.setText(str);
            if(leftButtonClickListener !=null){
                titlebar_btn_left.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        leftButtonClickListener.leftButtonClick(v);
                    }
                });
            }
        }
    }

    protected void initTitleBar(String leftText, String rightText, String centerText ,
                                final LeftButtonClickListener leftButtonClickListener,
                                final RightButtonClickListener rightButtonClickListener){
        if(!TextUtils.isEmpty(leftText)){
            titlebar_btn_left.setText(leftText);
        }
        if(!TextUtils.isEmpty(rightText)){
            titlebar_btn_right.setText(leftText);
        }
        if(!TextUtils.isEmpty(centerText)){
            titlebar_tv_center.setText(centerText);
        }

        if(leftButtonClickListener !=null){
            titlebar_btn_left.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    leftButtonClickListener.leftButtonClick(v);
                }
            });
        }

        if(rightButtonClickListener!=null){
            titlebar_btn_right.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    rightButtonClickListener.rightButtonClick(v);
                }
            });
        }
    }

    // 左边按钮监听器
    public interface LeftButtonClickListener{
        void leftButtonClick(View view ) ;
    }
    // 右边按钮的监听器
    public interface RightButtonClickListener{
        void rightButtonClick(View view) ;
    }
    // 取得子类内容界面
    public View getContentView(){
        return this.content ;
    }

}
