package com.example.medtrack.ui.FindMedList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.medtrack.ui.MainList.MainListViewModel;
import com.example.medtrack.R;
import com.example.medtrack.databinding.FragmentFIndResultTestBinding;
import com.example.medtrack.databinding.FragmentFindMedListBinding;
import com.example.medtrack.databinding.FragmentMainListBinding;
import com.example.medtrack.databinding.FragmentFindMedListBinding;

public class FindMedListFragment extends Fragment {

    private FragmentFindMedListBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FindMedListVievModel homeViewModel =
                new ViewModelProvider(this).get(FindMedListVievModel.class);
        binding = FragmentFindMedListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFindMedList;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}