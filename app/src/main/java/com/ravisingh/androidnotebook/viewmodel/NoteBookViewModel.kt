package com.ravisingh.androidnotebook.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravisingh.androidnotebook.model.Notebook
import com.ravisingh.androidnotebook.repository.NoteBookRepo
import kotlinx.coroutines.launch

class NoteBookViewModel : ViewModel() {

    val repo = NoteBookRepo()
    val notebookList = MutableLiveData<List<Notebook>>()

    fun insert(context: Context, notebook: Notebook) {
        viewModelScope.launch {
            repo.insert(context, notebook)
        }
    }

    fun delete(context: Context, notebook: Notebook) {
        viewModelScope.launch {
            repo.delete(context, notebook)
            notebookList.value = repo.getAllNotebooks(context)  // Load data again
        }
    }



    fun getAllNotebooks(context: Context){
        viewModelScope.launch {
            notebookList.value=  repo.getAllNotebooks(context)
        }
    }


}