package com.ravisingh.androidnotebook.repository

import android.content.Context
import com.ravisingh.androidnotebook.model.Notebook
import com.ravisingh.androidnotebook.room.NoteBookDatabase

class NoteBookRepo  {

    fun insert(context:Context,notebook: Notebook){
        NoteBookDatabase.get(context).getNoteBookDao().insert(notebook)
    }

     fun delete(context:Context,notebook: Notebook){
        NoteBookDatabase.get(context).getNoteBookDao().delete(notebook)
    }

    fun getAllNotebooks(context:Context) = NoteBookDatabase.get(context).getNoteBookDao().getAllNoteBook()


}