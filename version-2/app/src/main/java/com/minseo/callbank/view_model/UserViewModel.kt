package com.minseo.callbank.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.minseo.callbank.R

class UserViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val pwdCheck = MutableLiveData<String>()
    val name = MutableLiveData<String>("")
    val tel = MutableLiveData<String>("")
    val birth = MutableLiveData<String>("")

    val pro_name = MutableLiveData<String>("")
    val pro_tel = MutableLiveData<String>("")

    val idError = MutableLiveData<String?>()
    val pwdError = MutableLiveData<String?>()


    fun setIdPwd() {
        Log.d("id", id.value.toString())
        Log.d("password", password.value.toString())
        Log.d("pwdCheck", pwdCheck.value.toString())

        if (id.value == null)
            idError.value = "이메일을 적어주세요"
        else if (!id.value!!.contains("@"))
            idError.value = "이메일 형식이 잘못 되었습니다"
        else if (password.value == null)
            pwdError.value = "비밀번호를 적어주세요"
        else if (pwdCheck.value == null)
            pwdError.value = "비밀번호를 적어주세요"
        else if (!password.value.equals(pwdCheck.value))
            pwdError.value = "비밀번호가 같지 않아요"
        else {
            idError.value = null
            pwdError.value = null
        }
    }

    fun setName(userName: String) {
        name.value = userName
    }
    fun setTel(userTel: String) {
        tel.value = userTel
    }
    fun setBirth(userBirth: String) {
        birth.value = userBirth
    }
    fun setProName(userProName: String) {
        pro_name.value = userProName
    }
    fun setProTel(userProTel: String) {
        pro_tel.value = userProTel
    }


    fun createUser() : Boolean {
        var result = true
        auth.createUserWithEmailAndPassword(id.toString(), password.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val database = Firebase.database
                    val myRef = database.getReference("User")
                    myRef.child(id.toString()).child("name").setValue(name)
                    myRef.child(id.toString()).child("tel").setValue(tel)
                    myRef.child(id.toString()).child("birth").setValue(birth)
                    myRef.child(id.toString()).child("pro_name").setValue(pro_name)
                    myRef.child(id.toString()).child("pro_tel").setValue(pro_tel)
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