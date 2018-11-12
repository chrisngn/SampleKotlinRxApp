package com.example.songbird.rxjavakotlinapp.activities.main

import android.support.v7.widget.RecyclerView
import com.example.songbird.rxjavakotlinapp.databinding.RvItemRepositoryBinding
import com.example.songbird.rxjavakotlinapp.models.Repository

class RepositoryViewHolder(private var binding: RvItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    //    var repositoryHasIssues: TextView
    //    var repositoryOwner: TextView
    //    var numberOfStars: TextView
    //    var repositoryName: TextView

    fun bind(repo: Repository) {
        binding.repository = repo
        binding.executePendingBindings()
    }
}