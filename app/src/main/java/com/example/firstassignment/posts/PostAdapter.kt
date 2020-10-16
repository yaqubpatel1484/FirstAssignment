package com.example.firstassignment.posts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstassignment.R
import com.example.firstassignment.data.PostData
import kotlinx.android.synthetic.main.item_view_post.view.*

class PostAdapter (private val context: Context?, private val list: ArrayList<PostData>) :
    RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    companion object {
        lateinit var onItemClickListener: OnItemClickListener
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_post, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val model = list[position]
        context?.let {
            holder.setData(context, model)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var model: PostData? = null
        init {
            itemView.setOnClickListener(View.OnClickListener {
                model?.let { model ->
                    onItemClickListener.onClick(model)
                }
            })
        }

        fun setData(context: Context?, model: PostData) {

            itemView.itemView_id.text = "Id: ${model.id}"
            itemView.itemView_title.text = "Title:${model.title}"
            itemView.itemView_author.text = "Year:${model.author}"
            itemView.itemView_body.text = "Genre:${model.body}"

            context?.let { Glide.with(it).load(model.imageUrl).into(itemView.itemView_image) }

            this.model = model
        }
    }

    interface OnItemClickListener {
        fun onClick(model: PostData)
    }
}