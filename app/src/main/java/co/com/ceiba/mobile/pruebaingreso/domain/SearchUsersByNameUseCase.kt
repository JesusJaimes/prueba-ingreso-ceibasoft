package co.com.ceiba.mobile.pruebaingreso.domain

import co.com.ceiba.mobile.pruebaingreso.data.model.User
import co.com.ceiba.mobile.pruebaingreso.data.network.UserRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUsersByNameUseCase @Inject constructor(private val repo: UserRepo) {

    operator fun invoke(input:String): Flow<List<User>> {
        return repo.searchUserByName(input)
    }
}