package com.syahrizal.submissiondua.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syahrizal.submissiondua.model.user.User
import com.syahrizal.submissiondua.retrofit.RetroConfig
import retrofit2.Call
import retrofit2.Response

class FollowViewModel : ViewModel() {

    private val listFollowers : MutableLiveData<List<User>> = MutableLiveData()
    private val listFollowing : MutableLiveData<List<User>> = MutableLiveData()

    fun loadFollowers(context: Context?, username:String, page : String){
        RetroConfig.getRetrofit().getFollowersData(username,page ).enqueue(object : retrofit2.Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(context, "Periksa Koneksi Internet Anda Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                listFollowers.value = response.body()
            }
        })
    }
    fun loadFollowing(context: Context?, username:String, page : String){
        RetroConfig.getRetrofit().getFollowingData(username, page).enqueue(object : retrofit2.Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(context, "\"Periksa Koneksi Internet Anda Terlebih Dahulu\"", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                listFollowing.value = response.body()
            }
        })
    }

    val getFollowers : LiveData<List<User>> = listFollowers
    val getFollowing : LiveData<List<User>> = listFollowing

}
