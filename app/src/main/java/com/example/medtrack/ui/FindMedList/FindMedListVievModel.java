package com.example.medtrack.ui.FindMedList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FindMedListVievModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public FindMedListVievModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
