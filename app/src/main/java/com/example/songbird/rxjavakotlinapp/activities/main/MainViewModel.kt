package com.example.songbird.rxjavakotlinapp.activities.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.songbird.rxjavakotlinapp.data.RepoModel
import com.example.songbird.rxjavakotlinapp.models.Repository

class MainViewModel : ViewModel() {
    val isLoading = ObservableField<Boolean>(false)

    //This method also works
    //val repositories = ObservableField<List<Repository>>(ArrayList<Repository>())
    //Alternate way of Observing data. LiveData is Life Cycle aware
    var repositories = MutableLiveData<List<Repository>>()

    var repoModel = RepoModel()

    fun loadRepositories() {
        isLoading.set(true)
        repoModel.refreshData(object : RepoModel.OnDataReadyCallback {
            override fun onDataReady(data: List<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }

}
