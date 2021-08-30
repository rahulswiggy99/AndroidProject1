package com.example.application2.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application2.Model.Post
import com.example.application2.Repository.PostRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel(private val postRepository: PostRepository):ViewModel() {

    val data:MutableLiveData<List<Post>> =  MutableLiveData()
    fun getPost(){
        viewModelScope.launch {
            try{
                val res = postRepository.getPost()
                data.value = res
            }catch (e:Exception){
                Log.d("main","getPost: ${e.message}")
            }
        }
    }
}