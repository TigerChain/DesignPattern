package designpattern.jun.com.designpattern.Proxy.AIDL;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import designpattern.jun.com.designpattern.CustomAIDL;
import designpattern.jun.com.designpattern.R;

/**
 * @Description AIDL 远程代理模式
 * @Creator TigerChain（创建者）
 */
public class AidlActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_bind_service, btn_test_method ;
    private CustomAIDL customAIDL ;

    private boolean isServerStarted ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.aidl_activity);
        initView() ;
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            customAIDL = CustomAIDL.Stub.asInterface(service) ;

            Log.e("service:","onServiceConnected") ;
            isServerStarted = true ;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            customAIDL = null ;
            Log.e("service:","onServiceDisconnected") ;
            isServerStarted = false ;

        }
    } ;

    private void initView() {
        btn_bind_service = this.findViewById(R.id.btn_bind_service) ;
        btn_test_method = this.findViewById(R.id.btn_test_method) ;

        btn_bind_service.setOnClickListener(this);
        btn_test_method.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bind_service:
                bindService(new Intent(AidlActivity.this,AIDLRemoteService.class),serviceConnection, Context.BIND_AUTO_CREATE) ;
                break ;
            case R.id.btn_test_method:
                if(!isServerStarted){
                    Toast.makeText(AidlActivity.this,"请先绑定服务先",Toast.LENGTH_SHORT).show();
                    return ;
                }
                try {
                    String str = customAIDL.getStr();
                    Toast.makeText(AidlActivity.this,str,Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();

                }
                break ;
            default:
                break ;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
