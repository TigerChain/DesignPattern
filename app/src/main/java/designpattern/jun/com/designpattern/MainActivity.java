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
                Toast.makeText(MainActivity.this,datas.get(position),Toast.LENGTH_SHORT).show() ;
                IntentUtils.jumpTo(MainActivity.this,SimpleFactoryMactivity.class,null);
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