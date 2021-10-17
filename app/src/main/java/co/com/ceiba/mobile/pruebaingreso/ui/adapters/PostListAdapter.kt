package co.com.ceiba.mobile.pruebaingreso.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebaingreso.R
import co.com.ceiba.mobile.pruebaingreso.data.model.Post
import co.com.ceiba.mobile.pruebaingreso.data.model.User

class PostListAdapter(private val users: List<Post>): RecyclerView.Adapter<PostListAdapter.PostViewHolder>() {

    class PostViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val tvTitle: TextView = view.findViewById(R.id.title)
        val tvBody: TextView = view.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = users[position]
        holder.tvTitle.text = currentItem.title
        holder.tvBody.text = currentItem.body
    }

    override fun getItemCount(): Int {
        return users.size
    }
}


