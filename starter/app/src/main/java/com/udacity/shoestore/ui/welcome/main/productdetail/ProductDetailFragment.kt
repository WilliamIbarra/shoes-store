package com.udacity.shoestore.ui.welcome.main.productdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentProductDetailBinding
import com.udacity.shoestore.models.Shoes


class ProductDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentProductDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_product_detail,
            container,
            false
        )

        mBinding.lifecycleOwner = this

        setOnClickListeners()

        // Inflate the layout for this fragment
        return mBinding.root
    }

    private fun setOnClickListeners() {

        mBinding.saveProduct.setOnClickListener {
            // Save the new product detail
            validateAndSave()
        }

    }

    private fun validateAndSave() {

        if (!validate(mBinding.productNameLyt, getString(R.string.txt_enter_a_name))) return

        if(!validate(mBinding.productCompanyLyt, getString(R.string.txt_enter_a_company))) return

        if (!validate(mBinding.productDetailLyt, getString(R.string.txt_enter_a_detail))) return

        if (!validate(mBinding.productSizeLyt, getString(R.string.txt_enter_a_size))) return

        save()

    }

    private fun validate(lyt: TextInputLayout, error: String) : Boolean {
        return if (lyt.editText?.text.isNullOrEmpty()) {

            lyt.error = error
            lyt.requestFocus()

            false
        } else {
            lyt.error = null
            true
        }
    }

    private fun save() {

        val shoes =  Shoes(
            name = mBinding.productNameTxt.text.toString(),
            company = mBinding.productCompanyTxt.text.toString(),
            description = mBinding.productDetailTxt.text.toString(),
            size = mBinding.productSizeTxt.text.toString().toInt()
        )

findNavController().navigate(
    ProductDetailFragmentDirections.actionProductDetailFragmentToHomeFragment(shoes)
)
    }


}