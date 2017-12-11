package designpattern.jun.com.designpattern.Decorator.wrapperExpandableListAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.diegocarloslima.fgelv.lib.FloatingGroupExpandableListView;
import com.diegocarloslima.fgelv.lib.WrapperExpandableListAdapter;

import designpattern.jun.com.designpattern.R;

/**
 * @Description ExpandableListView 的显示界面
 * @Creator TigerChain（创建者）
 */
public class MyExpandListViewActivity extends AppCompatActivity {

    private FloatingGroupExpandableListView floatexpandableListview ;
    private ExpandableListView expandableListview ;
    private MyAdapter myAdapter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.myexpandlistview_activity);

        initView() ;

        initAdapter() ;
    }

    private void initView() {
        floatexpandableListview = this.findViewById(R.id.floatexpandableListview) ;
        expandableListview = this.findViewById(R.id.expandableListview) ;
    }

    private void initAdapter() {
        myAdapter = new MyAdapter(this) ;
//        expandableListviewSetAdapter(myAdapter) ;
        floatexpandableListviewSetAdapter(myAdapter) ;
    }


    private void expandableListviewSetAdapter(MyAdapter myAdapter) {
        expandableListview.setAdapter(myAdapter);
        // 设置子项默认展开
        for (int i = 0; i < myAdapter.getGroupCount(); i++) {
            expandableListview.expandGroup(i);
        }
    }

    private void floatexpandableListviewSetAdapter(MyAdapter myAdapter) {
        WrapperExpandableListAdapter wrapperAdapter = new WrapperExpandableListAdapter(myAdapter) ;
        floatexpandableListview.setAdapter(wrapperAdapter);

        // 设置子项默认展开
        for (int i = 0; i < myAdapter.getGroupCount(); i++) {
            floatexpandableListview.expandGroup(i);
        }
    }
}
