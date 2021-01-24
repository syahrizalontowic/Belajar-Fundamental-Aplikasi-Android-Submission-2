package com.syahrizal.submissiondua.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syahrizal.submissiondua.model.repository.Repository
import com.syahrizal.submissiondua.retrofit.RetroConfig
import retrofit2.Call
import retrofit2.Response

class RepositoryViewModel : ViewModel() {

    private val listRepos : MutableLiveData<List<Repository>> = MutableLiveData()

    fun loadRepos(context : Context, username:String){
        RetroConfig.getRetrofit().getRepositoryData(username).enqueue(object : retrofit2.Callback<List<Repository>>{
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                Toast.makeText(context, "\"Periksa koneksi internet Anda Terlebih Dahulu\"", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Repository>>, response: Response<List<Repository>>) {
                listRepos.value = response.body()
            }
        })
    }


    fun getRepos(): MutableLiveData<List<Repository>> {
        return listRepos
    }
}