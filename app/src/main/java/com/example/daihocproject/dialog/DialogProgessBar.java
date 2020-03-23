package com.example.daihocproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

import com.example.daihocproject.R;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;

public class DialogProgessBar extends Dialog {

    public DialogProgessBar(Context context) {
        super(context);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.setCancelable(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_progess_bar);
        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.spin_kit);
        Sprite circle = new Circle();
        mProgressBar.setIndeterminateDrawable(circle);
    }

    public void dismissDialog() {
        if (this != null && this.isShowing())
            this.dismiss();
    }
}

