package com.example.daihocproject.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseDialog<VB extends ViewDataBinding> extends Dialog {
    private VB mViewBinding;

    public BaseDialog(Context context) {
        super(context);
    }

    private <T extends ViewDataBinding> T setBindingContentView(@LayoutRes int layoutRes) {
        return DataBindingUtil.inflate(LayoutInflater.from(getContext()), layoutRes, null, false);
    }

    protected VB getViewBinding() {
        return mViewBinding;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutResourceId();
        if (layoutId > 0) {
            mViewBinding = setBindingContentView(layoutId);
            setContentView(mViewBinding.getRoot());
        }
    }

    @LayoutRes
    protected abstract int getLayoutResourceId();
}
