package com.sun.xuedian.multiedittext.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sun.xuedian.multiedittext.R;


/**
 * Created by SUN on 2017/5/26.
 */

public class MultiEditText extends RelativeLayout implements TextWatcher{

    private ImageView btn_cancel;
    private EditText  editText;
    private boolean  isShowCancelButton = true;

    public MultiEditText(Context context) {
        super(context);
    }

    public MultiEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.multi_edit_text, this, true);
        btn_cancel = (ImageView) findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        editText = (EditText) findViewById(R.id.edit_text);
        editText.addTextChangedListener(this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MultiEditText);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; ++i){
            int attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.MultiEditText_showCancelButton:
                    isShowCancelButton = typedArray.getBoolean(attr, true);
                case R.styleable.MultiEditText_cancelButtonSrc:
                    btn_cancel.setImageResource(typedArray.getResourceId(attr, R.drawable.cancel));
                    break;
                case R.styleable.MultiEditText_cancelButtonSize:
                    LayoutParams params = (LayoutParams) btn_cancel.getLayoutParams();
                    params.width = (int) typedArray.getDimension(attr, getResources().getDimensionPixelSize(R.dimen.btnDefaultSize));
                    params.height = params.width;
                    btn_cancel.setLayoutParams(params);
                    break;
                case R.styleable.MultiEditText_hint:
                    editText.setHint(typedArray.getText(attr));
                    break;
                case R.styleable.MultiEditText_hintColor:
                    editText.setHintTextColor(typedArray.getColor(attr, Color.BLACK));
                    break;
                case R.styleable.MultiEditText_text:
                    editText.setText(typedArray.getText(attr));
                    break;
                case R.styleable.MultiEditText_textColor:
                    editText.setTextColor(typedArray.getColor(attr, Color.BLACK));
                    break;
                case R.styleable.MultiEditText_SingleLine:
                    editText.setSingleLine(typedArray.getBoolean(attr, false));
                    break;
            }

        }

    }

    public MultiEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 获取输入的文本
     * @return
     */
    public String getText(){
        return editText.getText().toString().trim();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (isShowCancelButton && !TextUtils.isEmpty(getText())){
            btn_cancel.setVisibility(VISIBLE);
        }else {
            btn_cancel.setVisibility(GONE);
        }
    }
}
