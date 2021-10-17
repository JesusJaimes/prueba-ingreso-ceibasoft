package co.com.ceiba.mobile.pruebaingreso.data.network

import co.com.ceiba.mobile.pruebaingreso.data.dao.UserDao
import co.com.ceiba.mobile.pruebaingreso.data.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepo @Inject constructor(private val api:UserService, private val userDao: UserDao) {

    suspend fun fetchUsers():List<User> {
        var items = userDao.getUsers()
        if(items.isNullOrEmpty()){
            items = api.getUsers()
            for (item in items){
                insertUser(item)
            }
        }
        return userDao.getUsers()
    }

    private suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    fun searchUserByName(input:String): Flow<List<User>> {
        return userDao.searchUserByName(input)
    }
}