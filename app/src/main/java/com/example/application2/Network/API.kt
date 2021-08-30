package com.example.application2.Network

import com.example.application2.Model.Post
import retrofit2.http.GET

interface API {
    @GET("posts")
    suspend fun getPost(): List<Post>
}