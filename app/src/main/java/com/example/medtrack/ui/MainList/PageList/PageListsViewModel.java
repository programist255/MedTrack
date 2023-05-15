package com.example.medtrack.ui.MainList.PageList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medtrack.R;

import java.io.File;

public class PageListsViewModel extends Fragment {

    public TextView textTeam;
    public TextView textDay;
    public TextView textOllText;
    public ImageView imageView;
    private String URL = "text";
    private File text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_lists_view_model, container, false);
    }
    public void jsonTranslate(){

    }
}