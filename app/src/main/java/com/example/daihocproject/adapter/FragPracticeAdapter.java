package com.example.daihocproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daihocproject.R;
import com.example.daihocproject.databinding.ItemFragmentPracticeBinding;

public class FragPracticeAdapter extends RecyclerView.Adapter<FragPracticeAdapter.FragPracticeViewHolder> {
    private String[] subjectName;
    private String[] subjectIcon;
    private Context context;

    public FragPracticeAdapter(String[] subjectName, String[] subjectIcon) {
        this.subjectName = subjectName;
        this.subjectIcon = subjectIcon;
    }

    @NonNull
    @Override
    public FragPracticeAdapter.FragPracticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        ItemFragmentPracticeBinding rowView = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_fragment_practice, parent, false);
        return new FragPracticeViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull FragPracticeAdapter.FragPracticeViewHolder holder, int position) {
        holder.setBinding(position);
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class FragPracticeViewHolder extends RecyclerView.ViewHolder {
        private ItemFragmentPracticeBinding mBinding;

        public FragPracticeViewHolder(@NonNull ItemFragmentPracticeBinding itemView) {
            super(itemView.getRoot());
            this.mBinding = itemView;
            mBinding.setItem(this);
        }

        public void setBinding(final int pos) {
            mBinding.nameItemPractice.setText(subjectName[pos]);
            mBinding.iconItemPractice.setImageResource(context.getResources().getIdentifier("drawable/" + subjectIcon[pos], null, context.getPackageName()));
        }
    }
}
