package co.com.ceiba.mobile.pruebaingreso.ui.viewmodel

import androidx.lifecycle.*
import co.com.ceiba.mobile.pruebaingreso.data.model.Post
import co.com.ceiba.mobile.pruebaingreso.domain.GetUserPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val getUserPostsUseCase: GetUserPostsUseCase
): ViewModel() {
    val posts = MutableLiveData<List<Post>>()


    fun getUserPosts(id:Int){
        viewModelScope.launch {
            posts.postValue(getUserPostsUseCase.invoke(id))
        }
    }
}