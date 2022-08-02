package com.ravisingh.androidnotebook.adapters

import com.ravisingh.androidnotebook.model.Notebook

interface ClickHandler {

    fun handleLongClick(noteBook: Notebook)

    fun handleClick(noteBook: Notebook)
}