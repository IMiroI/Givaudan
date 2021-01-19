package com.givaudanmatthieu.github.presentation.repo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.givaudanmatthieu.github.R
import com.givaudanmatthieu.github.domain.model.UserRepo

class RepoAdapter(context: Context) :
        RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    private val usersRepo: ArrayList<UserRepo> = ArrayList()

    private val inflater = LayoutInflater.from(context)

    override fun getItemCount() = usersRepo.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_repo, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(usersRepo[position])
    }

    fun setData(usersRepo: List<UserRepo>?) {
        this.usersRepo.clear()

        usersRepo?.let {
            this.usersRepo.addAll(usersRepo)
        }

        notifyDataSetChanged()

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name: TextView = view.findViewById(R.id.name)
        private val description: TextView = view.findViewById(R.id.description)
        private val language: TextView = view.findViewById(R.id.language)
        private val forks: TextView = view.findViewById(R.id.forks)
        private val watchers: TextView = view.findViewById(R.id.watchers)
        private val license: TextView = view.findViewById(R.id.license)

        fun bind(userRepo: UserRepo) {
            name.text = userRepo.name
            description.text = userRepo.description
            language.text = userRepo.language
            forks.text = userRepo.forks.toString()
            watchers.text = userRepo.watchers.toString()
            license.text = userRepo.license
        }
    }

}