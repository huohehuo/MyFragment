package lins.com.myfragment.twofragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import lins.com.myfragment.R;

/**
 * home1
 * 
 * @author andye
 * 
 */
public class Home21 extends Fragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.index_1, null);
		init(v);

		return v;
	}

	private void init(View v) {

		// headerIV = (ImageView) v.findViewById(R.id.person2_header_iv);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// case R.id.person2_shopping: // ��ť����
		// break;

		default:
			break;
		}
	}

}
