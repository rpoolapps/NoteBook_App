package com.ravisingh.androidnotebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.ravisingh.androidnotebook.R
import com.ravisingh.androidnotebook.model.Notebook
import com.ravisingh.androidnotebook.viewmodel.NoteBookViewModel


class EditFragment : Fragment() {

    lateinit var navController: NavController

    lateinit var viewModel: NoteBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[NoteBookViewModel::class.java]
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        val notebook: Notebook = requireArguments().get("note_book") as Notebook

        val title = view.findViewById<TextInputEditText>(R.id.edit_title)
        val desc = view.findViewById<TextInputEditText>(R.id.edit_description)

        title.setText(notebook.title.toString())
        desc.setText(notebook.description.toString())

        val button = view.findViewById<ImageView>(R.id.save_instance)

        button.setOnClickListener {
            notebook.title = title.text?.trim().toString()
            notebook.description = desc.text?.trim().toString()

            updateNoteBook(notebook)
        }
    }

    fun updateNoteBook(noteBook: Notebook) {

        if (noteBook.title.trim().isEmpty()) {
            Toast.makeText(requireContext(), "Title must not be empty", Toast.LENGTH_SHORT).show()
            return
        }
        context?.let { viewModel.insert(it, noteBook) }
        navController.navigate(R.id.action_editFragment_to_mainFragment)
    }

}