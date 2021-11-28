package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoes(var name: String, var size: String, var company: String, var description: String) : Parcelable {
    override fun toString(): String {
        return size
    }
}