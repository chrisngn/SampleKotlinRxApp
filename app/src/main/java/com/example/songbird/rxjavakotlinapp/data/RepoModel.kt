package com.example.songbird.rxjavakotlinapp.data

import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import com.example.songbird.rxjavakotlinapp.Constants
import com.example.songbird.rxjavakotlinapp.models.Repository

class RepoModel {

    fun refreshData(callback: OnDataReadyCallback) {
        Handler().postDelayed({
            val repos = ArrayList<Repository>()
            repos.add(Repository("Repo 1", "Owner 1", 111))
            repos.add(Repository("Repo 2", "Owner 2", 222))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            repos.add(Repository("Repo 3", "Owner 3", 33))
            callback.onDataReady(repos)
        }, Constants.FAKE_NETWORK_DELAY)
    }

    interface OnDataReadyCallback {
        fun onDataReady(data: List<Repository>)
    }
}