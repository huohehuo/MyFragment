package lins.com.myfragment.onefragment;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TabHost;

//import com.live36g.tv.App;
//import com.live36g.tv.R;
//import com.live36g.tv.User;
//import com.live36g.tv.bean.PushUrlBean;
//import com.live36g.tv.service.MySubscribe;
//import com.live36g.tv.ui.show.ShowActivity;

import java.util.ArrayList;
import java.util.List;

import lins.com.myfragment.R;

/**
 * Created by aid on 9/6/16.
 */
public class FragmentTabHostEx extends FragmentTabHost {

    private String  mCurrentTag;
    private String  mNoTabChangedTag;
    private Context mContext;
    int selectedTab = 0;
    static List<TabObj> tabObjs = new ArrayList<>();

    static {
        tabObjs.add(new TabObj(0, R.drawable.home, R.drawable.home_selected));
        tabObjs.add(new TabObj(1, R.drawable.langya, R.drawable.college_selected));
        tabObjs.add(new TabObj(2, 0, 0));
        tabObjs.add(new TabObj(3, R.drawable.circle, R.drawable.circle_selected));
        tabObjs.add(new TabObj(4, R.drawable.me, R.drawable.mine_selected));
    }

    public FragmentTabHostEx(Context context) {
        super(context);
        this.mContext = context;
    }

    public FragmentTabHostEx(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    @Override
    public void onTabChanged(String tabId) {
        updateTab(this);
        if (tabId.equals(mNoTabChangedTag)) {
            setCurrentTabByTag(mCurrentTag);
//            if (!User.getCertify().equals("0")) {
//                return;
//            }
//            App.getService().getPushUrl(new MySubscribe<PushUrlBean>() {
//                @Override
//                public void onNext(PushUrlBean pushUrlBean) {
//                    ShowActivity.start(mContext, pushUrlBean.getData().getPush_stream_url(), pushUrlBean.getData().getRoom_id());
//                }
//            });
        } else {
            super.onTabChanged(tabId);
            mCurrentTag = tabId;
        }
    }

    public void setNoTabChangedTag(String tag) {
        this.mNoTabChangedTag = tag;
    }

    /**
     * 更新Tab标签的颜色
     *
     * @param tabHost
     */
    private void updateTab(final TabHost tabHost) {
        if (tabHost.getCurrentTab() == selectedTab) {
            return;
        }
        int selectedIndex = tabHost.getCurrentTab();
        ((ImageView) tabHost.getTabWidget().getChildAt(selectedTab).findViewById(R.id.ivTabIcon)).setImageResource(tabObjs.get(selectedTab).getUnSelectedRes());
        selectedTab = selectedIndex;
        ((ImageView) tabHost.getTabWidget().getChildAt(selectedIndex).findViewById(R.id.ivTabIcon)).setImageResource(tabObjs.get(selectedIndex).getSelectedRes());
//        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
//            View view = tabHost.getTabWidget().getChildAt(i);
//            if (tabHost.getCurrentTab() == i && selectedTab != i) {//选中
//                switch (i) {
//                    case 0:
//                        view.setBackgroundResource();
//                        break;
//                    case 1:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                }
//                view.setBackgroundColor(Color.parseColor("#67B8AA"));
//            } else {//不选中
//                view.setBackgroundColor(Color.parseColor("#3f4a57"));
//            }
//        }
    }

    static class TabObj {
        int index;
        int unSelectedRes;
        int selectedRes;

        TabObj(int index, int unSelectedRes, int selectedRes) {
            this.index = index;
            this.unSelectedRes = unSelectedRes;
            this.selectedRes = selectedRes;
        }

        public int getIndex() {
            return index;
        }

        int getUnSelectedRes() {
            return unSelectedRes;
        }

        int getSelectedRes() {
            return selectedRes;
        }
    }
}
