package com.example.medtrack.ui.MainList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.medtrack.R;
import com.example.medtrack.databinding.FragmentMainListBinding;

public class MainListFragment extends Fragment {

    private FragmentMainListBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MainListViewModel mainListViewModel =
                new ViewModelProvider(this).get(MainListViewModel.class);
        binding = FragmentMainListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMainList;
        mainListViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}