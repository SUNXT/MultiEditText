package com.sun.xuedian.multiedittext.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by SUN on 2017/5/26.
 */

public class ToastUtils {

    public static void showToast(Context context, String tip){
        Toast.makeText(context, tip, Toast.LENGTH_SHORT).show();
    }
}
