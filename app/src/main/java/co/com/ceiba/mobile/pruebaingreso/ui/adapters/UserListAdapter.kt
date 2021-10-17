package co.com.ceiba.mobile.pruebaingreso.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebaingreso.R
import co.com.ceiba.mobile.pruebaingreso.data.model.User
import co.com.ceiba.mobile.pruebaingreso.ui.view.PostActivity

class UserListAdapter (private val users: List<User>, private val context: Context): RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    class UserViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val tvName: TextView = view.findViewById(R.id.name)
        val tvEmail: TextView = view.findViewById(R.id.email)
        val tvPhone: TextView = view.findViewById(R.id.phone)
        val btnViewPost:Button = view.findViewById(R.id.btn_view_post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = users[position]
        val id = currentItem.id
        val name = currentItem.name
        val email = currentItem.email
        val phone = currentItem.phone
        holder.tvName.text = name
        holder.tvPhone.text = phone
        holder.tvEmail.text = email
        holder.btnViewPost.setOnClickListener(){
            val intent = Intent(context, PostActivity::class.java)
            intent.putExtra("userId", id)
            intent.putExtra("userName", name)
            intent.putExtra("userEmail", email)
            intent.putExtra("userPhone", phone)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}




