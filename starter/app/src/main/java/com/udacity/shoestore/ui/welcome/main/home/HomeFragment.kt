package com.udacity.shoestore.ui.welcome.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.databinding.LayoutProductBinding
import com.udacity.shoestore.models.Shoes


class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var mViewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mViewModel = activity.run {
            ViewModelProvider(this@HomeFragment).get(MainActivityViewModel::class.java)
        }

        // Inflate view and obtain an instance of the binding class
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )



        mBinding.lifecycleOwner = this

        getProductsList()

        setOnClickListeners()

        // Inflate the layout for this fragment
        return mBinding.root

    }

    private fun getProductsList() {
        mViewModel.shoesList.observe(viewLifecycleOwner, { shoes ->

            shoes.forEach{
                addView(it)
            }

        })
    }

    private fun addView(shoes: Shoes) {

        var newShoesBinding: LayoutProductBinding =
            DataBindingUtil.inflate(
                requireActivity().layoutInflater,
                R.layout.layout_product,
                mBinding.homeProductList,
                false)

        newShoesBinding.shoes = shoes

        mBinding.homeProductList.addView(newShoesBinding.root)


    }

    private fun setOnClickListeners() {
        mBinding.homeAddNewProductBtn.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToProductDetailFragment()
            )
        }
    }

}