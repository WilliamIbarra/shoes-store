package com.udacity.shoestore.ui.welcome.main.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentProductDetailBinding
import com.udacity.shoestore.models.Shoes


class ProductDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentProductDetailBinding

    // Get a reference to the ViewModel scoped to its Activity
    private val mViewModel by activityViewModels<MainActivityViewModel>()

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

        mBinding.viewModel = mViewModel

        setOnClickListeners()

        // Inflate the layout for this fragment
        return mBinding.root
    }

    private fun setOnClickListeners() {

        mBinding.saveProduct.setOnClickListener {
            // Save the new product detail
            //newShoes?.let { shoes ->
            validateAndSave()
            // }

        }

    }

    private fun validateAndSave() {

        if (!validate(mBinding.productNameLyt, getString(R.string.txt_enter_a_name))) return

        if (!validate(mBinding.productCompanyLyt, getString(R.string.txt_enter_a_company))) return

        if (!validate(mBinding.productDetailLyt, getString(R.string.txt_enter_a_detail))) return

        if (!validate(mBinding.productSizeLyt, getString(R.string.txt_enter_a_size))) return

        save()

    }

    private fun validate(lyt: TextInputLayout, error: String): Boolean {
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
        with(mViewModel) {
            saveProduct(

                Shoes(
                    name = name,
                    company = company,
                    size = size,
                    description = description
                )


            )

            cleanData()

        }

        findNavController().popBackStack()
    }


}