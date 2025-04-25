package com.example.rejibstore.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.rejibstore.Domain.BannerModel;
import com.example.rejibstore.Domain.CategoryModel;
import com.example.rejibstore.Domain.ItemsModel;
import com.example.rejibstore.Repository.MainRepository;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private final MainRepository repository = new MainRepository();
    public LiveData<ArrayList<CategoryModel>> loadCategory() {
        return repository.loadCategory();
    }
    public LiveData<ArrayList<BannerModel>> loadBanner() {
        return repository.loadBanner();
    }
    public LiveData<ArrayList<ItemsModel>> loadPopular() {
        return repository.loadPopular();
    }
}
