package com.sun.xuedian.multiedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.graphics.Typeface.MONOSPACE;
import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_MASK_CLASS;
import static android.text.InputType.TYPE_MASK_VARIATION;
import static android.text.InputType.TYPE_NUMBER_VARIATION_PASSWORD;
import static android.text.InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD;


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
            if (attr == R.styleable.MultiEditText_showCancelButton) {
                isShowCancelButton = typedArray.getBoolean(attr, true);

                btn_cancel.setImageResource(typedArray.getResourceId(attr, R.drawable.cancel));

            } else if (attr == R.styleable.MultiEditText_cancelButtonSrc) {
                btn_cancel.setImageResource(typedArray.getResourceId(attr, R.drawable.cancel));

            } else if (attr == R.styleable.MultiEditText_cancelButtonSize) {
                LayoutParams params = (LayoutParams) btn_cancel.getLayoutParams();
                params.width = (int) typedArray.getDimension(attr, getResources().getDimensionPixelSize(R.dimen.btnDefaultSize));
                params.height = params.width;
                btn_cancel.setLayoutParams(params);

            } else if (attr == R.styleable.MultiEditText_hint) {
                editText.setHint(typedArray.getText(attr));

            } else if (attr == R.styleable.MultiEditText_hintColor) {
                editText.setHintTextColor(typedArray.getColor(attr, Color.BLACK));

            } else if (attr == R.styleable.MultiEditText_text) {
                editText.setText(typedArray.getText(attr));

            } else if (attr == R.styleable.MultiEditText_textColor) {
                editText.setTextColor(typedArray.getColor(attr, Color.BLACK));

            } else if (attr == R.styleable.MultiEditText_SingleLine) {
                editText.setSingleLine(typedArray.getBoolean(attr, false));

            } else if (attr == R.styleable.MultiEditText_inputPassword) {
                if (typedArray.getBoolean(attr, false)) {
                    editText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | TYPE_CLASS_TEXT);
                    InputFilter inputFilter = new InputFilter() {
                        @Override
                        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                            StringBuilder builder = new StringBuilder(source);
                            return builder.toString().replace(" ", "");
                        }
                    };
                    editText.setFilters(new InputFilter[]{inputFilter});
                }

            } else if (attr == R.styleable.MultiEditText_inputNumber) {
                if (typedArray.getBoolean(attr, false)) {
                    editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                }

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

    public void setFilters(InputFilter[] inputFilters){
        editText.setFilters(inputFilters);
    }

}
