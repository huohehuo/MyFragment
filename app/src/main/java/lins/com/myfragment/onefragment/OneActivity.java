package lins.com.myfragment.onefragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import lins.com.myfragment.R;
import lins.com.myfragment.onefragment.childfragment.FourFragment;
import lins.com.myfragment.onefragment.childfragment.OneFragment;
import lins.com.myfragment.onefragment.childfragment.ThreeFragment;
import lins.com.myfragment.onefragment.childfragment.TwoFragment;

public class OneActivity extends FragmentActivity {

    FragmentTabHostEx mTabHost;
    private TabWidget mTabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        mTabHost = (FragmentTabHostEx) findViewById(android.R.id.tabhost);
        mTabs = (TabWidget)findViewById(android.R.id.tabs);

        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        MainTab[] mainTabs = MainTab.values();


        for (int i = 0; i < mainTabs.length; ++i) {
            MainTab mainTab = mainTabs[i];
            Log.e("tag",mainTab.getTag());
            TabHost.TabSpec tab = mTabHost.newTabSpec(mainTab.getTag());

            View indicatorView = getLayoutInflater().inflate(R.layout.tab_indicator, null);
//            if (i == 2) {
//                mTabHost.setNoTabChangedTag(mainTab.getTag());
//            }
            ImageView ivTabIcon = (ImageView) indicatorView.findViewById(R.id.ivTabIcon);
            ivTabIcon.setImageDrawable(getResources().getDrawable(mainTab.getResIcon()));

            TextView tvText = (TextView)indicatorView.findViewById(R.id.tvText);
            tvText.setText(getResources().getText(mainTab.getResText()));

            tab.setIndicator(indicatorView);
            mTabHost.addTab(tab, mainTab.getClz(), null);
        }
//        changeContent(MainTab.COLLEGE);
    }

//    public void changeContent(MainTab tab){
//        mTabHost.setCurrentTab(tab.getIdx());
//        mTabs.setCurrentTab(tab.getIdx());
//    }
    public enum MainTab {

        LIVE(0, ThreeFragment.TAG, R.string.app_name,R.drawable.tab_find_selector,
                ThreeFragment.class),

        COLLEGE(1, TwoFragment.TAG, R.string.app_name, R.drawable.tab_find_selector,
                TwoFragment.class),

//        START(2, "none",  R.string.app_name,R.drawable.circle,
//                null),

        RANKING(2, FourFragment.TAG,  R.string.app_name,R.drawable.tab_find_selector,
                FourFragment.class),

        ME(3, OneFragment.TAG, R.string.app_name, R.drawable.tab_find_selector,
                OneFragment.class);

        private int      idx;
        private String   tag;
        private int resText;
        private int      resIcon;
        private Class<?> clz;

        MainTab(int idx, String tag,int resText, int resIcon, Class<?> clz) {
            this.idx = idx;
            this.tag = tag;
            this.resText = resText;
            this.resIcon = resIcon;
            this.clz = clz;
        }

        public int getResText() {
            return resText;
        }

        public void setResText(int resText) {
            this.resText = resText;
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
//     * @param event
     * @return
     */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            View v = getCurrentFocus();
//            if (v instanceof EditText) {
//                Rect outRect = new Rect();
//                v.getGlobalVisibleRect(outRect);
//                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
////                    v.clearFocus();
//                    v.setFocusableInTouchMode(false);
//                    v.setFocusable(false);
//                    v.setFocusableInTouchMode(true);
//                    v.setFocusable(true);
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//                }
//            }
//        }
//        return super.dispatchTouchEvent(event);
//    }

    public static void openOne(Context context){
        context.startActivity(new Intent(context,OneActivity.class));
    }
}

