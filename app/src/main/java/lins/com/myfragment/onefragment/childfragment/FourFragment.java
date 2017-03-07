package lins.com.myfragment.onefragment.childfragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lins.com.myfragment.R;
import lins.com.myfragment.databinding.FragmentOneFourBinding;
import lins.com.myfragment.databinding.FragmentOneTwoBinding;

/**
 * Created by LINS on 2017/3/7.
 */
public class FourFragment extends Fragment {
    public static final String TAG = "live_fragment";
    private FragmentOneFourBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one_four,container,false);
        return binding.getRoot();
    }
}
