package designpattern.jun.com.designpattern.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @Description Intent 工具类
 * @Creator TigerChain（创建者）
 */
public class IntentUtils {

    public static void jumpTo(Activity context,Class<?> clazz,Bundle bundle){

        Intent intent = new Intent(context,clazz) ;
        if(bundle !=null){
            intent.putExtras(bundle) ;
        }

        context.startActivity(intent);
    }
}
