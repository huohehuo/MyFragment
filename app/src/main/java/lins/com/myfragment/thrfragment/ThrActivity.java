package lins.com.myfragment.thrfragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import lins.com.myfragment.R;
import lins.com.myfragment.twofragment.TwoActivity;

/*
* 主界面：相对布局和线性布局
* 线性布局负责页面的切换
* 特点：有个光标随动效果
* */
public class ThrActivity extends FragmentActivity implements View.OnClickListener {
    private ImageView mBt1, mBt2, mBt3, mBt4;
    private ImageView mSelBg;
    private LinearLayout mTab_item_container;
    private FragmentManager mFM = null;

    LinearLayout content_container, content_container2;

    Intent m_Intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr);
        init();
        changePerson();
    }
    //控件的绑定，事件监听，
    private void init() {
        //底部选项卡布局
        mTab_item_container = (LinearLayout) findViewById(R.id.tab_item_container);

        mBt1 = (ImageView) findViewById(R.id.tab_bt_1);
        mBt2 = (ImageView) findViewById(R.id.tab_bt_2);
        mBt3 = (ImageView) findViewById(R.id.tab_bt_3);
        mBt4 = (ImageView) findViewById(R.id.tab_bt_4);

        mBt1.setOnClickListener(this);
        mBt2.setOnClickListener(this);
        mBt3.setOnClickListener(this);
        mBt4.setOnClickListener(this);

        mSelBg = (ImageView) findViewById(R.id.tab_bg_view);
        ViewGroup.LayoutParams lp = mSelBg.getLayoutParams();
        lp.width = mTab_item_container.getWidth() / 4;

        content_container = (LinearLayout) findViewById(R.id.content_container);
        content_container2 = (LinearLayout) findViewById(R.id.content_container2);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ViewGroup.LayoutParams lp = mSelBg.getLayoutParams();
        lp.width = mTab_item_container.getWidth() / 4;
    }

    private int mSelectIndex = 0;
    private View last, now;
    View v1, v2;

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.tab_bt_1:
                //底部布局的选项卡设置光标随动
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(0);
                startAnimation(last, now);//启动光标动画
                mSelectIndex = 0;
                //切换fragment
                changePerson();
                break;
            case R.id.tab_bt_2:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(1);
                startAnimation(last, now);
                mSelectIndex = 1;

                changeBussiness();
                break;
            case R.id.tab_bt_3:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(2);
                startAnimation(last, now);
                mSelectIndex = 2;

                changeMessage();
                break;
            case R.id.tab_bt_4:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(3);
                startAnimation(last, now);
                mSelectIndex = 3;

                changeSetting();
                break;
            default:
                break;
        }
    }

    //设置光标动画
    private void startAnimation(View last, View now) {
        TranslateAnimation ta = new TranslateAnimation(last.getLeft(), now.getLeft(), 0, 0);
        ta.setDuration(300);
        ta.setFillAfter(true);
        mSelBg.startAnimation(ta);
    }

    /**
     * 切换fragement
     */
    private void changePerson() {
        Fragment f = new Home1Fra();
        if (null == mFM){
            mFM = getSupportFragmentManager();
        }
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    /**
     * 切换fragement
     */
    public void changeBussiness() {
        Fragment f = new Home2Fra();
        if (null == mFM){
            mFM = getSupportFragmentManager();
        }
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    /**
     * 切换fragement
     */
    public void changeMessage() {
        Fragment f = new Home3Fra();
        if (null == mFM){
            mFM = getSupportFragmentManager();
        }
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    /**
     * 切换fragement
     */
    public void changeSetting() {
        Fragment f = new SettingFra();
        if (null == mFM){
            mFM = getSupportFragmentManager();
        }
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    private static Boolean isQuit = false;
    private Timer timer = new Timer();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isQuit == false) {
                isQuit = true;
                Toast.makeText(getBaseContext(), "再次点击确定退出软件", Toast.LENGTH_SHORT).show();
                TimerTask task = null;
                task = new TimerTask() {
                    @Override
                    public void run() {
                        isQuit = false;
                    }
                };
                timer.schedule(task, 2000);
            } else {
                finish();
            }
        } else {
        }
        return false;
    }
}
