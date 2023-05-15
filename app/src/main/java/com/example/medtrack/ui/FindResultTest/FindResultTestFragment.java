package com.example.medtrack.ui.FindResultTest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.medtrack.databinding.FragmentFIndResultTestBinding;

public class FindResultTestFragment extends Fragment {

    private FragmentFIndResultTestBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FindResultTestViewModel homeViewModel =
                new ViewModelProvider(this).get(FindResultTestViewModel.class);
        binding = FragmentFIndResultTestBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFindResultTest;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}