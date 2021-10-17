package co.com.ceiba.mobile.pruebaingreso.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class User(
    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id:Int,

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name:String,

    @SerializedName("phone")
    @ColumnInfo(name = "phone")
    val phone:String,

    @SerializedName("email")
    @ColumnInfo(name = "email")
    val email:String )