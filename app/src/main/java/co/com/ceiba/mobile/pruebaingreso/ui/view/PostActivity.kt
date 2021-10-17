package co.com.ceiba.mobile.pruebaingreso.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.com.ceiba.mobile.pruebaingreso.R
import co.com.ceiba.mobile.pruebaingreso.databinding.ActivityPostBinding
import co.com.ceiba.mobile.pruebaingreso.ui.adapters.PostListAdapter
import co.com.ceiba.mobile.pruebaingreso.ui.viewmodel.PostListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private val  postViewModel: PostListViewModel by viewModels()
    private lateinit var tvUserName:TextView
    private lateinit var tvUserPhone:TextView
    private lateinit var tvUserEmail:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postViewModel.getUserPosts(intent.getIntExtra("userId", 0))
        postViewModel.posts.observe(this, {
            binding.recyclerViewPostsResults.layoutManager = LinearLayoutManager(this)
            binding.recyclerViewPostsResults.adapter = PostListAdapter(it)
        })
        setupUserInfo()
    }

    private fun setupUserInfo(){
        tvUserName = findViewById(R.id.name)
        tvUserEmail = findViewById(R.id.email)
        tvUserPhone = findViewById(R.id.phone)
        tvUserName.text =  intent.getStringExtra("userName")
        tvUserEmail.text = intent.getStringExtra("userEmail")
        tvUserPhone.text = intent.getStringExtra("userPhone")
    }
}