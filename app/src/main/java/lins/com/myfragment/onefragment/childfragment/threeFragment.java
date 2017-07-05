package lins.com.myfragment.onefragment.childfragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lins.com.myfragment.R;
import lins.com.myfragment.databinding.FragmentOneThrBinding;
import lins.com.myfragment.onefragment.OneActivity;

/**
 * Created by LINS on 2017/3/7.
 */

public class ThreeFragment extends BaseFragment {
    public static final String TAG = "three_fragment";
    private FragmentOneThrBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        OneActivity activity = (OneActivity)getActivity();
//        activity.changeContent(OneActivity.MainTab.LIVE);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one_thr,container,false);
        Log.e("dsd","ThreeFragment");
        return binding.getRoot();
    }

    @Override
    protected String getFragmentName() {
        return TAG;
    }
}
