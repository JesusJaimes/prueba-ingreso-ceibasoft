package co.com.ceiba.mobile.pruebaingreso.domain

import co.com.ceiba.mobile.pruebaingreso.data.network.UserRepo
import co.com.ceiba.mobile.pruebaingreso.data.model.User
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repo: UserRepo) {

    suspend operator fun invoke(): List<User> {
      return repo.fetchUsers()
    }
}