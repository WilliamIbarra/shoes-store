package com.udacity.shoestore.ui.welcome.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

private lateinit var mBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        mBinding.lifecycleOwner = this

        onClickListeners()

        // Inflate the layout for this fragment
        return mBinding.root
    }


    //This listeners make the navigation to on boarding screen

    private fun onClickListeners() {


        mBinding.sigInButton.setOnClickListener {

            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment()
            )
        }

        mBinding.signUpButton.setOnClickListener {

            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment()
            )
        }
    }

}
