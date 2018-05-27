package com.sun.xuedian.multiedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sun.xuedian.multiedittext.utils.ToastUtils;
import com.sun.xuedian.multiedittext.widget.MultiEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.multiEditText)
    MultiEditText editText;
    @OnClick(R.id.btn_getText)
    public void getText(){
        ToastUtils.showToast(this, editText.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

}
