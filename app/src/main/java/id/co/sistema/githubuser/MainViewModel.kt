package id.co.sistema.githubuser

import android.content.ClipData.Item
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.co.sistema.githubuser.Networking.ApiConfig
import id.co.sistema.githubuser.Networking.ItemsItem
import id.co.sistema.githubuser.Networking.UserResponse
import kotlinx.coroutines.*

class MainViewModel:ViewModel() {
    private var viewModelJob = Job()

    init {
        viewModelScope.launch {
            getListUser()
        }
    }

    private val _user = MutableLiveData<ArrayList<ItemsItem>?>()
    val user: LiveData<ArrayList<ItemsItem>?> = _user

    private suspend fun getListUser(){
        coroutineScope {
            val getUser = ApiConfig.getApiService().getListUsersAsync()
            try {
                _user.postValue(getUser)
            }catch (e: Exception){
                Log.e(TAG, "onFailure: ${e.message.toString()}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }



}