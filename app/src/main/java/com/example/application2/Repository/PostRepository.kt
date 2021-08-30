package com.example.application2.Repository

import com.example.application2.Model.Post
import com.example.application2.Network.RetrofitBuilder
import javax.inject.Inject

class PostRepository @Inject constructor(){

    suspend fun getPost():List<Post> = RetrofitBuilder.api.getPost()
}