package lins.com.myfragment.twofragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import lins.com.myfragment.R;
import lins.com.myfragment.onefragment.childfragment.oneFragment;
import lins.com.myfragment.onefragment.childfragment.threeFragment;
import lins.com.myfragment.onefragment.childfragment.twoFragment;

public class TwoActivity extends FragmentActivity{

    private Fragment fragmentOne,fragmentTwo,fragmentThr;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        initFragment();

//        fragmentOne = new oneFragment();
//        fragmentTransaction.add(R.id.content,fragmentOne);
//        fragmentTransaction.commit();
        findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentOne !=null){
                    fragmentTransaction.remove(fragmentOne);
                    fragmentOne = new oneFragment();
                    fragmentTransaction.add(R.id.content,fragmentOne);
                    fragmentTransaction.hide(fragmentTwo);
                    fragmentTransaction.hide(fragmentThr);
                    fragmentTransaction.commit();

                }
            }
        });
        findViewById(R.id.btn2_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentTwo !=null){
                    fragmentTransaction.remove(fragmentTwo);
                    fragmentTwo = new twoFragment();
                    fragmentTransaction.add(R.id.content,fragmentTwo);
                    fragmentTransaction.hide(fragmentOne);
                    fragmentTransaction.hide(fragmentThr);
                    fragmentTransaction.commit();

                }
            }
        });
    }



    private void initFragment(){
//        fragmentOne = new oneFragment();
//        fragmentTwo = new twoFragment();
//        fragmentThr = new threeFragment();

        if (fragmentOne==null) {
            fragmentOne=new oneFragment();
            fragmentTransaction.add(R.id.content, fragmentOne);
        }
        if (fragmentTwo==null) {
            fragmentTwo=new twoFragment();
            fragmentTransaction.add(R.id.content, fragmentTwo);
        }
        if (fragmentThr==null) {
            fragmentThr=new threeFragment();
            fragmentTransaction.add(R.id.content, fragmentThr);
        }
    }
    public void showMenuOne() {
        if (fragmentOne == null) {
            fragmentOne = new oneFragment();
        }
        fragmentTransaction.add(R.id.content, fragmentOne);
    }
    public void showMenuTwo() {
        if (fragmentTwo == null) {
            fragmentTwo = new twoFragment();
        }
        fragmentTransaction.add(R.id.content, fragmentTwo);
    }
    public void showMenuThr() {
        if (fragmentThr == null) {
            fragmentThr = new threeFragment();
        }
        fragmentTransaction.add(R.id.content, fragmentThr);
    }

//    @Override
//    public void onClick(View v) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        FragmentTransaction fragmentTransaction = fragmentManager
//                .beginTransaction();
//
//        if (fragmentOne==null) {
//            fragmentOne=new oneFragment();
//            fragmentTransaction.add(R.id.content, fragmentOne);
//
//        }
//
//        if (fragmentTwo==null) {
//            fragmentTwo=new twoFragment();
//            fragmentTransaction.add(R.id.content, fragmentTwo);
//
//        }
//        if (fragmentThr==null) {
//            fragmentThr=new threeFragment();
//            fragmentTransaction.add(R.id.content, fragmentThr);
//
//        }
//        switch (v.getId()){
//            case R.id.btn_two:
//                Log.e("aaa","aaaaa");
//                Toast.makeText(TwoActivity.this, "1", Toast.LENGTH_SHORT).show();
//                if (fragmentOne !=null){
//                    fragmentTransaction.remove(fragmentOne);
//                    fragmentOne = new oneFragment();
//                    fragmentTransaction.add(R.id.content,fragmentOne);
//                    fragmentTransaction.hide(fragmentTwo);
//                    fragmentTransaction.hide(fragmentThr);
//                }
//                //showMenuOne();
//
//
//                break;
//            case R.id.btn2_two:
//                Toast.makeText(TwoActivity.this, "2", Toast.LENGTH_SHORT).show();
//                if (fragmentTwo !=null){
//                    fragmentTransaction.remove(fragmentTwo);
//                    fragmentTwo = new twoFragment();
//                    fragmentTransaction.add(R.id.content,fragmentTwo);
//                    fragmentTransaction.hide(fragmentOne);
//                    fragmentTransaction.hide(fragmentThr);
//                }
//
//                break;
//            case R.id.btn3_two:
//                Toast.makeText(TwoActivity.this, "3", Toast.LENGTH_SHORT).show();
//                showMenuThr();
//                fragmentTransaction.hide(fragmentTwo);
//                fragmentTransaction.hide(fragmentOne);
//        }
//        fragmentTransaction.commit();
//    }
    public static void openOne(Context context){
        context.startActivity(new Intent(context,TwoActivity.class));
    }
}
