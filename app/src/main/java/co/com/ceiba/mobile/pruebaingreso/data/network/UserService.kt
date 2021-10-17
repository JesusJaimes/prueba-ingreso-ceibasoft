package co.com.ceiba.mobile.pruebaingreso.data.network
import co.com.ceiba.mobile.pruebaingreso.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserService @Inject constructor(private val api: ApiClient) {

    suspend fun getUsers():List<User>{
        return withContext(Dispatchers.IO){
            val response = api.getUsers()
            response.body()?: emptyList()
        }
    }
}