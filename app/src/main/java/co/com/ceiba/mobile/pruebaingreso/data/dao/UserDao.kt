package co.com.ceiba.mobile.pruebaingreso.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.com.ceiba.mobile.pruebaingreso.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    suspend fun getUsers():List<User>

    @Query("SELECT * FROM user_table WHERE name LIKE :input")
    fun searchUserByName(input:String):Flow<List<User>>

    @Query("SELECT * FROM user_table WHERE id LIKE :id LIMIT 1")
    suspend fun findUser(id: Int): User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user:User)

}