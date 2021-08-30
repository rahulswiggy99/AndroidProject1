package com.example.application2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.application2.Model.Post

class Adapter(private val context:Context,private var postList:ArrayList<Post>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.each_row,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = postList[position]
        holder.id.text = post.id.toString()
        holder.title.text = post.title
    }

    override fun getItemCount(): Int = postList.size

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val id:TextView = itemView.findViewById(R.id.id)
        val title:TextView = itemView.findViewById(R.id.title)
    }
    fun setData(postList: ArrayList<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }
}