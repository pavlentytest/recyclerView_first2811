package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.*

class MyAdapter(val list: List<Book>, val context: Context) : RecyclerView.Adapter<MyAdapter.MyView>(){

    class MyView(view: View) : RecyclerView.ViewHolder(view) {
        val bookName = view.findViewById<TextView>(R.id.bookName)
        val bookYear = view.findViewById<TextView>(R.id.bookYear)
        val bookImage = view.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return MyView(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bookName.text = list.get(position).name
        holder.bookYear.text = list.get(position).year.toString()
        Picasso.get().load(list.get(position).image).into(holder.bookImage)
        holder.itemView.setOnClickListener {
            Snackbar.make(holder.itemView.findViewById(R.id.layout),"N $position",Snackbar.LENGTH_LONG).show()
        }

    }
}