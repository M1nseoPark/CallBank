package com.minseo.callbank.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentJoin1Binding
import com.minseo.callbank.databinding.FragmentJoin2Binding
import com.minseo.callbank.view_model.UserViewModel

class Join2Fragment : Fragment() {
    private lateinit var binding: FragmentJoin2Binding
    private val sharedViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentJoin2Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_join2Fragment_to_join1Fragment)
        }

        binding.btNext.setOnClickListener {
            if (binding.etName.isEmpty()) {
                binding.etName.error = "이름을 적어주세요"
            }
            else if (binding.etTel.isEmpty()) {
                binding.etTel.error = "전화번호를 적어주세요"
            }
            else if (binding.etBirth.isEmpty()) {
                binding.etBirth.error = "생년월일을 적어주세요"
            }
            else if (binding.etBirth.toString().length != 8) {
                binding.etBirth.error = "8자리로 입력해주세요 예) 19700308"
            }
            else {
                joinUser(binding.etName.toString(), binding.etTel.toString(), binding.etBirth.toString())
                Navigation.findNavController(binding.root).navigate(R.id.action_join2Fragment_to_join3Fragment)
            }
        }
    }

    private fun joinUser(userName: String, userTel: String, userBirth: String) {
        sharedViewModel.setName(userName)
        sharedViewModel.setTel(userTel)
        sharedViewModel.setBirth(userBirth)
    }
}