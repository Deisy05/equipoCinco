package com.cocktailapp.equipocinco.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cocktailapp.equipocinco.repository.LoginRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



/*
class LoginViewModel : ViewModel() {
    private var repository = LoginRepository()
    */
@HiltViewModel
class LoginViewModel @Inject constructor (
    private val repository: LoginRepository,
    private var firebaseAuth: FirebaseAuth
) : ViewModel() {
    //registerUser se comunica con el repository
    fun registerUser(email: String, pass: String, isRegister: (Boolean) -> Unit) {
        repository.registerUser(email, pass) { response ->
            isRegister(response)
        }
    }

    fun loginUser(email: String, pass: String, isLogin: (Boolean) -> Unit) {
        repository.loginUser(email,pass) { response ->
            isLogin(response)
        }
    }

    fun sesion(email: String?, isEnableView: (Boolean) -> Unit) {
        if (email != null) {
            isEnableView(true)
        } else {
            isEnableView(false)
        }
    }

    fun getRepository(): LoginRepository {
        return repository
    }



    
    fun logoutUser(onLogoutComplete: (Boolean, String?) -> Unit) {
        repository.logoutUseRepository(onLogoutComplete)
    }

}
