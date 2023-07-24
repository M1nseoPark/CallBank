package com.minseo.callbank.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentLoginBinding
import com.minseo.callbank.databinding.FragmentMainBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentLoginBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        binding.btSignin.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_join1Fragment)
        }
    }
}