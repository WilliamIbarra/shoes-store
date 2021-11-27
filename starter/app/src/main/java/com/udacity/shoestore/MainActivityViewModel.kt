package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoes

class MainActivityViewModel: ViewModel() {

    private val _shoes = MutableLiveData<Shoes>()
    val shoes: LiveData<Shoes>
    get() = _shoes


    private var listOfShoes = mutableListOf(
    Shoes(
    "Nike Air Presto",
    7,
    "Nike, Inc",
    "Awesome shoes designed by Nike."),
    Shoes(
    "Stan Smith Vulc Shoes",
    9,
    "Adidas AG",
    "Awesome shoes designed by Adidas AG."),
    Shoes(
    "Curry Flow 8",
    14,
    "Under Armour Inc",
    "Awesome shoes designed by Under Armour Inc."),
    Shoes(
    "Deviate NITRO",
    8,
    "Puma SE",
    "Awesome shoes designed by Puma SE."),
    Shoes(
    "Bounder - Bearko",
    14,
    "Skechers",
    "Awesome shoes designed by Skechers."),
    Shoes(
    "National Geographic Floatride Energy 3",
    7,
    "Reebok",
    "Awesome shoes designed by Reebok."),
    Shoes(
    "Fresh Foam X 860v12",
    9,
    "New Balance Athletics, Inc",
    "Awesome shoes designed by New Balance Athletics Inc.")

    )

    // The list of shoes
    private  val _shoesList = MutableLiveData<MutableList<Shoes>>()
    val shoesList: LiveData<MutableList<Shoes>>
    get() = _shoesList


    fun saveProduct(product: Shoes) {
        _shoesList.value?.add(product)
    }

    init {


        _shoesList.value = listOfShoes

       // _shoesByUser.postValue(null)

    }
}