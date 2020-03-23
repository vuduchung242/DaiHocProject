package com.example.daihocproject.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.daihocproject.R;
import com.example.daihocproject.base.BaseFragment;
import com.example.daihocproject.databinding.FragmentOptionBinding;

public class OptionFragment extends BaseFragment<FragmentOptionBinding> {

    @Override
    protected int layoutRes() {
        return R.layout.fragment_option;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentOptionBinding binding = getViewBinding();
        binding.setOptionFragment(this);
    }
}
