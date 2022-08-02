package com.ravisingh.androidnotebook.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Notebook(var title: String, var description: String?) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}