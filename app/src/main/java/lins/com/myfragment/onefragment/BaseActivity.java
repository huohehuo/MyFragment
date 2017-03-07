package lins.com.myfragment.onefragment;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.githang.statusbar.StatusBarCompat;

import lins.com.myfragment.R;

/**
 * Created by LINS on 2017/3/7.
 */

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onStart() {
        super.onStart();
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.theme), false);
    }
    public void hideSoftKeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
