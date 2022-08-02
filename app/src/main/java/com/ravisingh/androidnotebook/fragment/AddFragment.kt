package com.ravisingh.androidnotebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.ravisingh.androidnotebook.R
import com.ravisingh.androidnotebook.model.Notebook
import com.ravisingh.androidnotebook.viewmodel.NoteBookViewModel

class AddFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)

        val title = view.findViewById<TextInputEditText>(R.id.add_title)
        val description = view.findViewById<TextInputEditText>(R.id.add_description)

        val addFloatingActionButton = view.findViewById<FloatingActionButton>(R.id.add_notebook)

        addFloatingActionButton.setOnClickListener {

            if (title.text?.trim().toString().isEmpty()) return@setOnClickListener

            val notebook = Notebook(title.text.toString(), description.text.toString())
            saveInDB(notebook)

            navController.navigate(R.id.action_addFragment_to_mainFragment)
        }

    }

    fun saveInDB(notebook: Notebook) {
        context?.let { viewModel.insert(it, notebook) }
    }


}