package com.udacity.shoestore.ui.welcome.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {
    private lateinit var mBinding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Initialize the binding in a more concise way
        mBinding = FragmentOnBoardingBinding.inflate(
            inflater,
            container,
            false
        )

        onClickListeners()

        mBinding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return mBinding.root
    }

    //This listeners make the navigation to on boarding instructions

    private fun onClickListeners() {


        mBinding.onBoardingInstructionsButton.setOnClickListener {

            findNavController().navigate(
                OnBoardingFragmentDirections.actionOnBoardingFragmentToOnBoardingInstructionsFragment()
            )
        }
    }

}