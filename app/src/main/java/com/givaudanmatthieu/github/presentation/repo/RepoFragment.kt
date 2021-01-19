package com.givaudanmatthieu.github.presentation.repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.givaudanmatthieu.github.R

class RepoFragment : Fragment() {

    private lateinit var number_repo: TextView
    private lateinit var progressBarRepo: ProgressBar
    private lateinit var recyclerViewRepo: RecyclerView


    private val viewModel: RepoViewModel by viewModels()

    private lateinit var adapter: RepoAdapter

    companion object {
        private const val KEY_LOGIN = "key_login"

        fun newInstance(login: String): RepoFragment {
            val bundle = Bundle()
            bundle.putString(KEY_LOGIN, login)

            val fragment = RepoFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_repo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        number_repo = view.findViewById(R.id.number_repo)
        progressBarRepo = view.findViewById(R.id.progress_bar_repo)
        recyclerViewRepo = view.findViewById(R.id.recycler_view_repo)

        adapter = RepoAdapter(requireContext())
        recyclerViewRepo.adapter = adapter

        viewModel.state.observe(viewLifecycleOwner, ::updateState)

        arguments?.getString(KEY_LOGIN)?.let {
            viewModel.getUserRepo(it)
        }
    }

    private fun updateState(state: RepoState) {
        when (state) {
            is RepoState.ErrorState -> {
                progressBarRepo.isVisible = false
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                adapter.setData(null)
            }
            is RepoState.LoadingState -> {
                progressBarRepo.isVisible = true
                adapter.setData(null)
            }
            is RepoState.SuccessState -> {
                progressBarRepo.isVisible = false
                adapter.setData(state.repos)
            }
        }
    }


}