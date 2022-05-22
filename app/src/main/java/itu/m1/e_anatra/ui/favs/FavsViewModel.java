package itu.m1.e_anatra.ui.favs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FavsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is favs fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}