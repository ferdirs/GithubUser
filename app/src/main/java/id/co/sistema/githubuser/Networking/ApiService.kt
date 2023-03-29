package id.co.sistema.githubuser.Networking

import androidx.viewbinding.BuildConfig
import id.co.sistema.githubuser.Networking.ApiService.Companion.API_TOKEN
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("users")
    @Headers("Content-Type: application/json")
    suspend fun getListUsersAsync(): ArrayList<ItemsItem>

    companion object{
       const val API_TOKEN = id.co.sistema.githubuser.BuildConfig.TOKEN_API
    }

}