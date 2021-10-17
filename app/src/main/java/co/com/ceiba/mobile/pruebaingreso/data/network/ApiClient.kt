package co.com.ceiba.mobile.pruebaingreso.data.network

import co.com.ceiba.mobile.pruebaingreso.data.model.Post
import co.com.ceiba.mobile.pruebaingreso.data.model.User
import co.com.ceiba.mobile.pruebaingreso.rest.Endpoints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET(Endpoints.GET_USERS)
    suspend fun getUsers():Response<List<User>>

    @GET(Endpoints.GET_POST_USER)
    suspend fun getUserPosts(@Query("userId") id:Int):Response<List<Post>>
}