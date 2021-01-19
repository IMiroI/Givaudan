package com.givaudanmatthieu.github.presentation.repo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.givaudanmatthieu.github.R
import com.givaudanmatthieu.github.domain.model.UserRepo

class RepoAdapter(private val context: Context) :
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

        @SuppressLint("SetTextI18n")
        fun bind(userRepo: UserRepo) {
            name.text = context.getString(R.string.name_repos) + userRepo.name
            description.text = context.getString(R.string.description_repos) + userRepo.description
            language.text = context.getString(R.string.language_repos) + userRepo.language
            forks.text = context.getString(R.string.forks_repos) + userRepo.forks.toString()
            watchers.text =
                context.getString(R.string.watchers_repos) + userRepo.watchers.toString()
            license.text = context.getString(R.string.license_repos) + userRepo.license
        }
    }

}