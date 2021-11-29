package com.udacity.shoestore.ui.welcome.main.home

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.databinding.LayoutProductBinding
import com.udacity.shoestore.models.Shoes


class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    // Get a reference to the ViewModel scoped to its Activity
    private val mViewModel by activityViewModels<MainActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        mViewModel = activity.run {
//            ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
//        }

        // Inflate view and obtain an instance of the binding class
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )



        mBinding.lifecycleOwner = this

        getProductsList()

        setObservers()

        setOnClickListeners()

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return mBinding.root

    }

    private fun setObservers() {

    }

    private fun getProductsList() {
        mViewModel.shoesList.observe(viewLifecycleOwner, { shoes ->

            shoes.forEach{
                addView(it)
            }

        })
    }

    private fun addView(shoes: Shoes) {

        val newShoesBinding: LayoutProductBinding =
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> logout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
    }

}