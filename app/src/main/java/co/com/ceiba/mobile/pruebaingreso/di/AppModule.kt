package co.com.ceiba.mobile.pruebaingreso.di

import android.app.Application
import co.com.ceiba.mobile.pruebaingreso.data.DataBase
import co.com.ceiba.mobile.pruebaingreso.data.dao.UserDao
import co.com.ceiba.mobile.pruebaingreso.data.network.ApiClient
import co.com.ceiba.mobile.pruebaingreso.rest.Endpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Endpoints.URL_BASE).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideDataBase(app:Application): DataBase {
        return DataBase.getDatabase(app)
    }

    @Singleton
    @Provides
    fun provideUserDao(db: DataBase): UserDao {
        return db.userDao()
    }

}