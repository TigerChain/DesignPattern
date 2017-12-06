package designpattern.jun.com.designpattern.TemplateMethod;

import android.view.View;
import android.widget.Toast;


import designpattern.jun.com.designpattern.R;

/**
 * @Description
 * @Creator junjun（创建者）
 */
public class MyActivity extends TemplateMethodActivity {


    @Override
    protected void init() {


        initTitleBar("左边", "右边", "中间文字", new LeftButtonClickListener() {
            @Override
            public void leftButtonClick(View view) {
                Toast.makeText(MyActivity.this,"左边",Toast.LENGTH_SHORT).show();
            }
        }, new RightButtonClickListener() {
            @Override
            public void rightButtonClick(View view) {
                Toast.makeText(MyActivity.this,"右边",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.my_activity;
    }
}
