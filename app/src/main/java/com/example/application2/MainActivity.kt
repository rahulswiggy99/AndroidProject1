package com.example.application2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.application2.Model.Post
import com.example.application2.Repository.PostRepository
import com.example.application2.ViewModel.PostViewModel
import com.example.application2.ViewModel.PostViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: Adapter
    private lateinit var progressBar: ProgressBar
    private lateinit var postViewModel:PostViewModel
    @Inject
    lateinit var postRepository: PostRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
        initRecyclerView()
        //val postRepository = PostRepository()
        val viewModelfactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this,viewModelfactory).get(PostViewModel::class.java) // or [PostViewModel::class.java]
        //postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        postViewModel.getPost()
        postViewModel.data.observe(this, Observer {
            postAdapter.setData(it as ArrayList<Post>)
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        })
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        postAdapter = Adapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }

}