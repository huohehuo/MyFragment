package lins.com.myfragment.twofragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import lins.com.myfragment.R;

/**
 * home2
 * @author andye
 *
 */
public class Home22 extends Fragment implements OnClickListener {


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.index_2, null);

		return v;
	}

	@Override
	public void onClick(View v) {
	}

}
