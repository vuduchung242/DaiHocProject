package com.example.daihocproject.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.daihocproject.dialog.DialogProgessBar;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public abstract class BaseFragment<VB extends ViewDataBinding> extends Fragment {
    public static final String PARENT_CONTAINER_VIEW_ID = "parent_container_view_id";
    private VB viewBinding;
    public DialogProgessBar mDialogProgess;

    public static BaseFragment newInstance(Class<? extends BaseFragment> aClass, int parentContentViewId) {
        //create bundle to put fragment info to transfer.
        Bundle bundle = new Bundle();
        bundle.putInt(PARENT_CONTAINER_VIEW_ID, parentContentViewId);

        BaseFragment fragment = null;
        try {
            fragment = aClass.newInstance();
            fragment.setArguments(bundle);
        } catch (java.lang.InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return fragment;
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected VB getViewBinding() {
        return viewBinding;
    }

    protected <T extends ViewDataBinding> T createContentView(LayoutInflater inflater,
                                                              ViewGroup parent,
                                                              @LayoutRes int layoutResourceId) {
        return DataBindingUtil.inflate(inflater, layoutResourceId, parent, false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        int layoutRes = layoutRes();
        if (layoutRes > 0) {
            viewBinding = createContentView(inflater, container, layoutRes);
            return viewBinding.getRoot();
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewBinding = null;
    }

    /**
     * back to base fragment
     */
    public void goBackToBaseFragment() {
        int entryCount = 0;
        if (getFragmentManager() != null) {
            entryCount = getFragmentManager().getBackStackEntryCount();
        }
        if (entryCount == 0) {
            return;
        }
        String name = getFragmentManager().getBackStackEntryAt(0).getName();
        getFragmentManager().popBackStack(name, POP_BACK_STACK_INCLUSIVE);

    }

    protected int containerViewId() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(PARENT_CONTAINER_VIEW_ID, -1);
        }
        return -1;
    }

    public void showDialog() {
        if (mDialogProgess == null) {
            mDialogProgess = new DialogProgessBar(getContext());
            mDialogProgess.show();
        }
    }

    public void dismissDialog() {
        if (mDialogProgess != null && mDialogProgess.isShowing()) {
            mDialogProgess.dismissDialog();
            mDialogProgess = null;
        }
    }
}
