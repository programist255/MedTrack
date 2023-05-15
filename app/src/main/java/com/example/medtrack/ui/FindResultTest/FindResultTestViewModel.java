package com.example.medtrack.ui.FindResultTest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FindResultTestViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public FindResultTestViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
