package co.com.ceiba.mobile.pruebaingreso.domain

import co.com.ceiba.mobile.pruebaingreso.data.model.Post
import co.com.ceiba.mobile.pruebaingreso.data.network.PostRepo
import javax.inject.Inject

class GetUserPostsUseCase  @Inject constructor(private val repo: PostRepo) {

    suspend operator fun invoke(id:Int): List<Post> {
        return repo.fetchUserPosts(id)
    }
}