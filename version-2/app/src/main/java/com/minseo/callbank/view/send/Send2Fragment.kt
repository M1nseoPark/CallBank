package com.minseo.callbank.view.send

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentSend1Binding
import com.minseo.callbank.databinding.FragmentSend2Binding

class Send2Fragment : Fragment() {
    private lateinit var binding: FragmentSend2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend2Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding.btNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send2Fragment_to_send3Fragment)
        }

        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send2Fragment_to_send1Fragment)
        }

        return fragmentBinding.root
    }
}