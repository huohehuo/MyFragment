package lins.com.myfragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import lins.com.myfragment.databinding.ActivityMainBinding;
import lins.com.myfragment.fourfragment.FourActivity;
import lins.com.myfragment.onefragment.OneActivity;
import lins.com.myfragment.thrfragment.ThrActivity;
import lins.com.myfragment.twofragment.TwoActivity;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OneActivity.openOne(MainActivity.this);
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwoActivity.openOne(MainActivity.this);
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(App.getContext(),ThrActivity.class));
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(App.getContext(),FourActivity.class));
            }
        });
    }


}
