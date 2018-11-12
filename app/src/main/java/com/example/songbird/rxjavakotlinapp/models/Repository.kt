package com.example.songbird.rxjavakotlinapp.models

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.songbird.rxjavakotlinapp.BR

/**
 * Extends BaseObservable so Repository can be observed by the Data Binding library
 */
class Repository(repoName: String,
                 repoOwner: String?,
                 var numberOfStars: Int?) : BaseObservable() {

    // @get:Bindable notation allows this field to be observed
    @get:Bindable
    var repoName: String = repoName
    set(value) {
        field = value
        notifyPropertyChanged(BR.repoName)
    }

    @get:Bindable
    var repoOwner: String = repoOwner ?: ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.repoOwner)
    }

}
