package com.minseo.callbank.view.send

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentSend4Binding

class Send4Fragment : Fragment() {
    private lateinit var binding: FragmentSend4Binding
    var pickFlag: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend4Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        // 계속 버튼 클릭
        binding.btNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send4Fragment_to_send5Fragment)
        }
        // 뒤로 버튼 클릭
        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send4Fragment_to_send3Fragment)
        }

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.send4 = this
    }

    // 은행 버튼 클릭
    fun pickSinhan() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = true
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickHana() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = true
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickSuhyup() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = true
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickIbk() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = true
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickKakao() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = true
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickKb() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = true
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickNh() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = true
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickEpost() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = true
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickKfcc() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = true
        binding.btUri.isSelected = false
    }

    fun pickUri() {
        pickFlag = true
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = true
    }
}