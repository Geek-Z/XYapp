package geek_z.github.io.xyapp.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2020/1/30 0030.
 */

public class MyApplication extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
