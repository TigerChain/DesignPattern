package designpattern.jun.com.designpattern.Proxy.AIDL;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import designpattern.jun.com.designpattern.CustomAIDL;

/**
 * @Description 创建一个远程服务
 * @Creator TigerChain（创建者）
 */
public class AIDLRemoteService extends Service {


    private final CustomAIDL.Stub aidl = new CustomAIDL.Stub() {
        @Override
        public String getStr() throws RemoteException {
            return " 我是远程服务返回的 HELLO ";
        }
    } ;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return aidl;
    }
}
