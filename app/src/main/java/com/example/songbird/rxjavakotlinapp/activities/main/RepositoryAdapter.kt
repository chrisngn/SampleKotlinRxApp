package com.example.songbird.rxjavakotlinapp.activities.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.songbird.rxjavakotlinapp.R
import com.example.songbird.rxjavakotlinapp.databinding.RvItemRepositoryBinding
import com.example.songbird.rxjavakotlinapp.models.Repository

class RepositoryAdapter(var repos: List<Repository>) : RecyclerView.Adapter<RepositoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RepositoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.rv_item_repository, parent, false)
        val binding = RvItemRepositoryBinding.inflate(inflater, parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) =
            holder.bind(repos[position])
}
