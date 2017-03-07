package lins.com.myfragment.onefragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;

import lins.com.myfragment.R;
import lins.com.myfragment.onefragment.childfragment.oneFragment;
import lins.com.myfragment.onefragment.childfragment.twoFragment;
import lins.com.myfragment.onefragment.childfragment.threeFragment;
import lins.com.myfragment.onefragment.childfragment.FourFragment;

public class OneActivity extends BaseActivity {
    private View activityRootView;
    //屏幕高度
    private int screenHeight = 0;
    //软件盘弹起后所占高度阀值  
    private int keyHeight    = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        //获取屏幕高度  
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        keyHeight = screenHeight / 3;
        StatusBarUtil.StatusBarLightMode(this);
        activityRootView = findViewById(R.id.main_root_view);

        findViewById(R.id.ivShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //中间的按钮
            }
        });
        FragmentTabHostEx mTabHost = (FragmentTabHostEx) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        MainTab[] mainTabs = MainTab.values();
        for (int i = 0; i < mainTabs.length; ++i) {
            MainTab mainTab = mainTabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(mainTab.getTag());

            View indicatorView = getLayoutInflater().inflate(R.layout.tab_indicator, null);
            if (i == 2) {
                mTabHost.setNoTabChangedTag(mainTab.getTag());
            }
            ImageView ivTabIcon = (ImageView) indicatorView.findViewById(R.id.ivTabIcon);
            ivTabIcon.setImageDrawable(getResources().getDrawable(mainTab.getResIcon()));

            tab.setIndicator(indicatorView);
            mTabHost.addTab(tab, mainTab.getClz(), null);
        }
    }


    private enum MainTab {

        LIVE(0, threeFragment.TAG, R.drawable.home_selected,
                threeFragment.class),

        COLLEGE(1, twoFragment.TAG, R.drawable.langya,
                twoFragment.class),

        START(2, "none", R.drawable.circle,
                null),

        RANKING(3, oneFragment.TAG, R.drawable.circle,
                oneFragment.class),

        ME(4, FourFragment.TAG, R.drawable.me,
                FourFragment.class);

        private int      idx;
        private String   tag;
        private int      resIcon;
        private Class<?> clz;

        MainTab(int idx, String tag, int resIcon, Class<?> clz) {
            this.idx = idx;
            this.tag = tag;
            this.resIcon = resIcon;
            this.clz = clz;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getResIcon() {
            return resIcon;
        }

        public void setResIcon(int resIcon) {
            this.resIcon = resIcon;
        }

        public Class<?> getClz() {
            return clz;
        }

        public void setClz(Class<?> clz) {
            this.clz = clz;
        }
    }

    /**
     * clear focus on touch outside
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
//                    v.clearFocus();
                    v.setFocusableInTouchMode(false);
                    v.setFocusable(false);
                    v.setFocusableInTouchMode(true);
                    v.setFocusable(true);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public static void openOne(Context context){
        context.startActivity(new Intent(context,OneActivity.class));
    }
}

