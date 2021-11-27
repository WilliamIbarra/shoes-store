package com.udacity.shoestore.ui.welcome.onboardingdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnBoardingInstructionsBinding
import com.udacity.shoestore.ui.welcome.onboarding.OnBoardingFragmentDirections


class OnBoardingInstructionsFragment : Fragment() {

    private lateinit var mBinding: FragmentOnBoardingInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_on_boarding_instructions,
            container,
            false
        )

        onClickListeners()

        mBinding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return mBinding.root
    }

    //This listeners make the navigation to home screen

    private fun onClickListeners() {


        mBinding.onBoardingInstructionsButton.setOnClickListener {

            findNavController().navigate(
                OnBoardingInstructionsFragmentDirections.actionOnBoardingInstructionsFragmentToHomeFragment(null)
            )
        }
    }


}