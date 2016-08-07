package cmt.app.method;

import android.content.Context;
import android.os.Looper;
import android.util.Log;

/**
 * Created by caimt on 16/8/7.
 */
public class Utils {
    public static long start() {
        return System.currentTimeMillis();

    }

    public static long time = 0;

    public static void end(long l, Context context) {
        String longtime="";
        String methodName = null;
        StackTraceElement[] elementArray = new Throwable().getStackTrace();
        if (null != elementArray && elementArray.length > 1) {
            StackTraceElement element = elementArray[1];
            methodName = element.getMethodName();
            long end = System.currentTimeMillis() - l;
            if (end>=500){
                longtime="严重耗时";
            }
            if (Looper.myLooper() == Looper.getMainLooper()){
                time += end;
            }
            Log.d("计时-" + (Looper.myLooper() == Looper.getMainLooper() ? "主线程-" : "子线程-") + longtime+"-" +
                    context.getClass().getSimpleName() + ":" + methodName, String.valueOf(end) + "ms" + " " +
                    " 已经持续耗时" + String.valueOf(time) + "ms   ");
        }
    }

}
