package co.com.ceiba.mobile.pruebaingreso.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import co.com.ceiba.mobile.pruebaingreso.R
import co.com.ceiba.mobile.pruebaingreso.ui.adapters.UserListAdapter
import co.com.ceiba.mobile.pruebaingreso.databinding.ActivityMainBinding
import co.com.ceiba.mobile.pruebaingreso.ui.viewmodel.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.text.Editable

import android.text.TextWatcher
import android.view.View
import androidx.core.view.isVisible


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val  userViewModel: UserListViewModel by viewModels()
    private lateinit var etSearch: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel.getUsers()
        userViewModel.users.observe(this, {
            binding.recyclerViewSearchResults.layoutManager = LinearLayoutManager(this)
            binding.recyclerViewSearchResults.adapter = UserListAdapter(it, this)
        })
        userViewModel.isLoading.observe(this, {
            binding.loadingDialog.root.isVisible = it
            binding.loadingDialog.dialogMessage.text = "CARGANDO USUARIOS"
        })
        setupEditTextSearch()
    }

    private fun setupEditTextSearch(){
        etSearch = findViewById(R.id.editTextSearch)
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if(s.isNotEmpty()){
                    searchUsers(s.toString())
                }
            }
        })
    }

    private fun searchUsers(input:String){
        val query = "%$input%"
        userViewModel.searchUsersByName(query).observe(this, {
            binding.recyclerViewSearchResults.adapter = UserListAdapter(it, this)
            if(it.isEmpty()){
                binding.emptyView.root.visibility = View.VISIBLE
                binding.recyclerViewSearchResults.visibility = View.GONE
            }else{
                binding.emptyView.root.visibility = View.GONE
                binding.recyclerViewSearchResults.visibility = View.VISIBLE
            }

        })
    }
}