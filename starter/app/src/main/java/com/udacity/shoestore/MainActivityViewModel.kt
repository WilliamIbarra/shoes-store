package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoes

class MainActivityViewModel: ViewModel() {

    private val _shoes = MutableLiveData<Shoes>()
    val shoes: LiveData<Shoes>
    get() = _shoes


    // The list of shoes
    private  val _shoesList = MutableLiveData<List<Shoes>>()
    val shoesList: LiveData<List<Shoes>>
    get() = _shoesList


    init {

        _shoesList.postValue(listOf(
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
        )

    }
}