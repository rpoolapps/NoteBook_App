package com.ravisingh.androidnotebook.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.ravisingh.androidnotebook.model.Notebook
import com.ravisingh.androidnotebook.repository.NoteBookRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteBookViewModel(val context: Context) : ViewModel() {

    val repo = NoteBookRepo()
    val notebookList:LiveData<List<Notebook>> = repo.getAllNotebooks(context).asLiveData()

    fun insert(context: Context, notebook: Notebook) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.insert(context, notebook)
            }
        }
    }

    fun delete(context: Context, notebook: Notebook) {
        viewModelScope.launch {
             withContext(Dispatchers.IO) {
                repo.delete(context, notebook)
            }

        }
    }




}