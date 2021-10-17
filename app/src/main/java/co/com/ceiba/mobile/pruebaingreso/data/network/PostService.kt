package co.com.ceiba.mobile.pruebaingreso.data.network

import co.com.ceiba.mobile.pruebaingreso.data.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostService @Inject constructor(private val api: ApiClient) {

    suspend fun getUserPosts(id:Int):List<Post>{
        return withContext(Dispatchers.IO){
            val response = api.getUserPosts(id)
            response.body()?: emptyList()
        }
    }
}