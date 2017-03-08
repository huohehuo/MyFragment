package lins.com.myfragment.twofragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import lins.com.myfragment.R;


//利用RadioGroup来切换fragment，注意用的Fragment包是android.app.Fragment包不是v4包，v4测试行不通，暂不懂
public class TwoActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private Fragment fragmentOne, fragmentTwo, fragmentThr;
    RadioGroup radioGroup;

    private FragmentManager fragmentManager;
    //private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        init();
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //initFragment();

        fragmentOne = new Home21();
        fragmentTransaction.add(R.id.content, fragmentOne);
        fragmentTransaction.commit();

    }

    private void init() {
        radioGroup = (RadioGroup) findViewById(R.id.group_all);
        radioGroup.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        if (fragmentOne == null) {
            fragmentOne = new Home21();
            fragmentTransaction.add(R.id.content, fragmentOne);
        }

        if (fragmentTwo == null) {
            fragmentTwo = new Home22();
            fragmentTransaction.add(R.id.content, fragmentTwo);

        }
        if (fragmentThr == null) {
            fragmentThr = new Home23();
            fragmentTransaction.add(R.id.content, fragmentThr);
        }
        switch (checkedId) {
            case R.id.one_radiobt:
                Log.e("aaa", "aaaaa");
                Toast.makeText(TwoActivity.this, "1", Toast.LENGTH_SHORT).show();
                if (fragmentOne != null) {
                    fragmentTransaction.remove(fragmentOne);
                    fragmentOne = new Home21();
                    fragmentTransaction.add(R.id.content, fragmentOne);
                    fragmentTransaction.hide(fragmentTwo);
                    fragmentTransaction.hide(fragmentThr);
                }
                break;
            case R.id.two_radiobt:
                Toast.makeText(TwoActivity.this, "2", Toast.LENGTH_SHORT).show();
                if (fragmentTwo != null) {
                    fragmentTransaction.remove(fragmentTwo);
                    fragmentTwo = new Home22();
                    fragmentTransaction.add(R.id.content, fragmentTwo);
                    fragmentTransaction.hide(fragmentOne);
                    fragmentTransaction.hide(fragmentThr);
                }

                break;
            case R.id.thr_radiobt:
                Toast.makeText(TwoActivity.this, "3", Toast.LENGTH_SHORT).show();
                if (fragmentThr != null) {
                    fragmentTransaction.remove(fragmentThr);
                    fragmentThr = new Home23();
                    fragmentTransaction.add(R.id.content, fragmentThr);
                    fragmentTransaction.hide(fragmentTwo);
                    fragmentTransaction.hide(fragmentOne);
                }
        }
        fragmentTransaction.commit();
    }


    public static void openOne(Context context) {
        context.startActivity(new Intent(context, TwoActivity.class));
    }
}
