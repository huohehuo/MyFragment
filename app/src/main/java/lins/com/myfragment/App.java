package lins.com.myfragment;

import android.app.Application;
import android.content.Context;

/**
 * Created by LINS on 2017/3/7.
 */

public class App extends Application{
    private static Context context;
    private static App app = new App();
    public static App getInstance(){
        return app;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
    // 用于给需要Context的方法提供context，可直接写LinsApp.getContext()即可获取到当前context上下文
    public static Context getContext() {
        return context;
    }
}
