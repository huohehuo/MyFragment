package lins.com.myfragment.fourfragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lins.com.myfragment.R;
import lins.com.myfragment.thrfragment.ThrActivity;

/*    利用FragmentTabHost作为父布局的fragment页面处理方式
    切换由Viewpager来填充*/

public class FourActivity extends AppCompatActivity {
    private FragmentTabHost mTabHost;
    private ViewPager mViewPager;
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }
    private void init() {
        initView();//初始化fragment
        initEvent();//初始化Tab和Viewpager的监听
    }


    //填充fragment需要的资源
    private Class mClass[] = {HomeFragment.class, ReportFragment.class, MessageFragment.class, MineFragment.class};
    private Fragment mFragment[] = {new HomeFragment(), new ReportFragment(), new MessageFragment(), new MineFragment()};
    //设置并填充fragment，设置viewpager
    private void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mFragmentList = new ArrayList<Fragment>();

        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);
        //设置每个Tab对应的Fragment
        for (int i = 0; i < mFragment.length; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTitles[i]).setIndicator(getTabView(i));
            mTabHost.addTab(tabSpec, mClass[i], null);
            mFragmentList.add(mFragment[i]);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);
        }

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
    }

    //设置Tab的资源
    private String mTitles[] = {"首页", "报表", "消息", "我的"};
    private int mImages[] = {R.drawable.tab_home,R.drawable.tab_report,
            R.drawable.tab_message,R.drawable.tab_mine};
    //设置并获取Tab的item
    private View getTabView(int index) {
        //获取每个tab的图标和文字item
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item, null);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView title = (TextView) view.findViewById(R.id.title);
        image.setImageResource(mImages[index]);//设置Tab图标
        title.setText(mTitles[index]);//设置Tab标题
        return view;
    }

    private void initEvent() {
        //Tab的变化监听
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                mViewPager.setCurrentItem(mTabHost.getCurrentTab());//Tab变化时ViewPager的联动
            }
        });
        //ViewPager的变化监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                mTabHost.setCurrentTab(position);//ViewPager变化时Tab的联动
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
}
