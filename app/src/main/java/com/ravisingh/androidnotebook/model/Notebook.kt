package com.ravisingh.androidnotebook.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Notebook(
    var title: String,
    var description: String?,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
) : Parcelable


