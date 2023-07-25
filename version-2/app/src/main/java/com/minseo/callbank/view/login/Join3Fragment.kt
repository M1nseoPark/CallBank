package com.minseo.callbank.view.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentJoin3Binding
import com.minseo.callbank.view_model.UserViewModel

class Join3Fragment : Fragment() {
    private lateinit var binding: FragmentJoin3Binding
    private val sharedViewModel: UserViewModel by activityViewModels()
    private lateinit var auth: FirebaseAuth

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
            var result = createUser()
            Log.d("result", result.toString())
            Navigation.findNavController(binding.root).navigate(R.id.action_join3Fragment_to_join4Fragment)
        }

        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_join3Fragment_to_join2Fragment)
        }

        binding.btNext.setOnClickListener {
            var pass = false
            sharedViewModel.setProNameTel(binding.etProName.editText?.text.toString(), binding.etProTel.editText?.text.toString())

            sharedViewModel.flag.observe(viewLifecycleOwner) {
                if (it)
                    pass = true
                else {
                    sharedViewModel.proNameError.observe(viewLifecycleOwner) {
                        binding.etProName.error = it
                    }
                    sharedViewModel.proTelError.observe(viewLifecycleOwner) {
                        binding.etProTel.error = it
                    }
                }
            }

            if (pass) {
                var result = createUser()
                Log.d("result", result.toString())
                Navigation.findNavController(binding.root).navigate(R.id.action_join3Fragment_to_join4Fragment)
            }
        }
    }

    fun createUser() : Boolean {
        var result = true
        auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(sharedViewModel.id.value.toString(), sharedViewModel.password.value.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val database = Firebase.database
                    val myRef = database.getReference("user")
                    myRef.child(sharedViewModel.id.value.toString()).child("name").setValue(sharedViewModel.name.value)
                    myRef.child(sharedViewModel.id.value.toString()).child("tel").setValue(sharedViewModel.tel.value)
                    myRef.child(sharedViewModel.id.value.toString()).child("birth").setValue(sharedViewModel.birth.value)
                    myRef.child(sharedViewModel.id.value.toString()).child("pro_name").setValue(sharedViewModel.pro_name.value)
                    myRef.child(sharedViewModel.id.value.toString()).child("pro_tel").setValue(sharedViewModel.pro_tel.value)
                }
                else {
                    result = false
                }
            }
            .addOnFailureListener {
                result = false
            }

        return result
    }
}