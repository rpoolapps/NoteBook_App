package com.ravisingh.androidnotebook.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Notebook(val title: String, val description: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}