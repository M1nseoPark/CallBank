package com.minseo.callbank.view.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentJoin3Binding
import com.minseo.callbank.view_model.UserViewModel

class Join3Fragment : Fragment() {
    private lateinit var binding: FragmentJoin3Binding
    private val sharedViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentJoin3Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        binding.btPass.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_join3Fragment_to_join4Fragment)
        }

        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_join3Fragment_to_join2Fragment)
        }

        binding.btNext.setOnClickListener {
            if (binding.etProName.isEmpty()) {
                binding.etProName.error = "수신인의 이름을 적어주세요"
            }
            else if (binding.etProTel.isEmpty()) {
                binding.etProTel.error = "수신인의 전화번호를 적어주세요"
            }
            else {
                joinUser(binding.etProName.toString(), binding.etProTel.toString())
                var result = sharedViewModel.createUser()
                Log.d("result", result.toString())
                Navigation.findNavController(binding.root).navigate(R.id.action_join3Fragment_to_join4Fragment)
            }
        }
    }

    private fun joinUser(userProName: String, userProTel: String) {
        sharedViewModel.setProName(userProName)
        sharedViewModel.setProTel(userProTel)
    }
}