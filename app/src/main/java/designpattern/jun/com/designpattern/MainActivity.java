package designpattern.jun.com.designpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import designpattern.jun.com.designpattern.FactoryPatttern.SimpleFactory.SimpleFactoryMactivity;
import designpattern.jun.com.designpattern.Observer.CustomEventBus.CustomBusActivity;
import designpattern.jun.com.designpattern.Proxy.AIDL.AidlActivity;
import designpattern.jun.com.designpattern.SingleTon.SingleTonActivity;
import designpattern.jun.com.designpattern.Strategy.StrategyActivity;
import designpattern.jun.com.designpattern.utils.IntentUtils;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview ;

    private ArrayList<String> datas = new ArrayList<>() ;

    private HomeAdpater homeAdpater ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView() ;
        initData() ;
    }

    private void initData() {
        datas.add("简单工厂模式");
        datas.add("单例模式") ;
        datas.add("策略模式") ;
        datas.add("代理模式") ;
        datas.add("观察者模式") ;
    }

    private void initView() {
        recyclerview = this.findViewById(R.id.recyclerview) ;
        homeAdpater = new HomeAdpater() ;
        recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(homeAdpater);


        homeAdpater.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        IntentUtils.jumpTo(MainActivity.this,SimpleFactoryMactivity.class,null);
                        break ;
                    case 1:
                        IntentUtils.jumpTo(MainActivity.this,SingleTonActivity.class,null);
                        break ;
                    case 2:
                        IntentUtils.jumpTo(MainActivity.this,StrategyActivity.class,null);
                        break ;
                    case 3:
                        IntentUtils.jumpTo(MainActivity.this,AidlActivity.class,null);
                        break ;
                    case 4:
                        IntentUtils.jumpTo(MainActivity.this,CustomBusActivity.class,null);
                        break ;
                    default:
                        break;
                }

                Toast.makeText(MainActivity.this,datas.get(position),Toast.LENGTH_SHORT).show() ;

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        });
    }


    class HomeAdpater extends  RecyclerView.Adapter<HomeAdpater.HomeViewHolder>{

        private OnItemClickListener onItemClickListener ;

        public void setOnItemClickListener(OnItemClickListener onItemClickListener){
            this.onItemClickListener = onItemClickListener ;
        }


        @Override
        public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            HomeViewHolder homeViewHolder = new HomeViewHolder(
                    LayoutInflater.from(MainActivity.this).inflate(R.layout.home_list_item,parent,false)) ;


            return homeViewHolder;
        }

        @Override
        public void onBindViewHolder(final HomeViewHolder holder, int position) {
            holder.tv.setText(datas.get(position));
            if(onItemClickListener !=null){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(view,holder.getLayoutPosition());
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        onItemClickListener.onLongItemClick(view,holder.getLayoutPosition());
                        return false;
                    }
                });
            }


        }


        @Override
        public int getItemCount() {
            return datas.size();
        }


        class HomeViewHolder extends RecyclerView.ViewHolder{

            private TextView tv ;

            public HomeViewHolder(View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tv) ;
            }
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position) ;
        void onLongItemClick(View view,int position) ;
    }
}
