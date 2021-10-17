package co.com.ceiba.mobile.pruebaingreso.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.com.ceiba.mobile.pruebaingreso.data.dao.UserDao
import co.com.ceiba.mobile.pruebaingreso.data.model.User

@Database(entities = [User::class], version = 2)
abstract class DataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var DB_INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase {
            return DB_INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, DataBase::class.java, "database").build()
                DB_INSTANCE = instance
                instance
            }
        }
    }

}