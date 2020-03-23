package com.example.daihocproject.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.daihocproject.R;
import com.example.daihocproject.adapter.FragPracticeAdapter;
import com.example.daihocproject.base.BaseFragment;
import com.example.daihocproject.databinding.FragmentPracticeBinding;
import com.example.daihocproject.model.SpacesItemDecoration;

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        String[] subjectName = {"Toán", "Vật Lý", "Hóa Học", "Tiếng Anh", "Ngữ Văn", "Lịch Sử", "Địa Lý", "Sinh Học", "GDCD"};
        String[] subjectIcon = {"ic_calculator", "ic_physics", "ic_chemistry", "ic_english", "ic_literature"
                , "ic_history", "ic_geography", "ic_biology", "ic_gdcd"};
        binding.rcPractice.setLayoutManager(gridLayoutManager);
        binding.rcPractice.setItemAnimator(new DefaultItemAnimator());
        binding.rcPractice.setAdapter(new FragPracticeAdapter(subjectName, subjectIcon));
        binding.rcPractice.addItemDecoration(new SpacesItemDecoration(30, 3, true));
    }
}
