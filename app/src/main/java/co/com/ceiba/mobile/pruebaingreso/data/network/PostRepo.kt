package co.com.ceiba.mobile.pruebaingreso.data.network

import co.com.ceiba.mobile.pruebaingreso.data.model.Post
import javax.inject.Inject

class PostRepo @Inject constructor(private val api:PostService) {

    suspend fun fetchUserPosts(id:Int): List<Post> {
        return api.getUserPosts(id)
    }
}