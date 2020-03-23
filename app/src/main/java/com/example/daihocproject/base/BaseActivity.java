package com.example.daihocproject.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.daihocproject.dialog.DialogProgessBar;

public abstract class BaseActivity <VB extends ViewDataBinding> extends AppCompatActivity {
    public DialogProgessBar mDialogProgess;
    /**
     * View Binding
     */
    private VB mViewBinding;

    /**
     * Log TAG
     */
    private static final String TAG = "activity";

    /**
     * set content view
     *
     * @param layoutRes layout Resource
     * @param <T>       object exend ViewDataBinding
     * @return view data binding
     */
    private <T extends ViewDataBinding> T setBindingContentView(@LayoutRes int layoutRes) {
        return DataBindingUtil.setContentView(this, layoutRes);
    }

    /**
     * get View Binding
     *
     * @return view binding
     */
    protected VB getViewBinding() {
        return mViewBinding;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutResourceId();
        if (layoutId > 0) {
            mViewBinding = setBindingContentView(layoutId);
        }
    }

    /**
     * get Layout Resource
     *
     * @return int
     */
    @LayoutRes
    protected abstract int getLayoutResourceId();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewBinding = null;
    }

    public void finishActivity() {
        finish();
    }

    public void showDialog() {
        if(mDialogProgess == null) {
            mDialogProgess = new DialogProgessBar(this);
            mDialogProgess.show();
        }
    }

    public void dismissDialog() {
        if(mDialogProgess != null && mDialogProgess.isShowing()) {
            mDialogProgess.dismissDialog();
            mDialogProgess = null;
        }
    }
}
