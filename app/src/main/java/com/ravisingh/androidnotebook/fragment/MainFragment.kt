package com.ravisingh.androidnotebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ravisingh.androidnotebook.R
import com.ravisingh.androidnotebook.adapters.ClickHandler
import com.ravisingh.androidnotebook.adapters.MyAdapter
import com.ravisingh.androidnotebook.model.Notebook
import com.ravisingh.androidnotebook.viewmodel.NoteBookViewModel


class MainFragment : Fragment(), ClickHandler {

    lateinit var navController: NavController
    var adapter = MyAdapter(this)
    val viewModel by activityViewModels<NoteBookViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)

        val floatingButton = view.findViewById<FloatingActionButton>(R.id.add_notebook)
        floatingButton.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_addFragment)
        }

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        context?.let { viewModel.getAllNotebooks(it) }


        viewModel.notebookList.observe(viewLifecycleOwner) {
            adapter.setContentList(it)
            recycler.also { recycler ->
                recycler.adapter = adapter
            }
        }

    }

    override fun handleLongClick(noteBook: Notebook) {
        AlertDialog.Builder(requireContext()).setMessage("Are You Sure?")
            .setPositiveButton("Ok") { _, _ ->
                context?.let { viewModel.delete(it, noteBook) }
            }
            .setNegativeButton("Cancel") { _, _ -> }.show()
    }

    override fun handleClick(noteBook: Notebook) {
        val bundle = bundleOf("note_book" to noteBook)
        navController.navigate(R.id.action_mainFragment_to_editFragment, bundle)
    }
}