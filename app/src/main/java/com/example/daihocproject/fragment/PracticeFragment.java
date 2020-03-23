package com.example.daihocproject.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.daihocproject.R;
import com.example.daihocproject.base.BaseFragment;
import com.example.daihocproject.databinding.FragmentPracticeBinding;

public class PracticeFragment extends BaseFragment<FragmentPracticeBinding> {

    @Override
    protected int layoutRes() {
        return R.layout.fragment_practice;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentPracticeBinding binding = getViewBinding();
        binding.setPracticeFragment(this);
    }
}
