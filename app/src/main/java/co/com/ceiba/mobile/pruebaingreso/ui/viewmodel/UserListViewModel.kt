package co.com.ceiba.mobile.pruebaingreso.ui.viewmodel

import androidx.lifecycle.*
import co.com.ceiba.mobile.pruebaingreso.data.model.User
import co.com.ceiba.mobile.pruebaingreso.domain.GetUsersUseCase
import co.com.ceiba.mobile.pruebaingreso.domain.SearchUsersByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase:GetUsersUseCase,
    private val seacthUsersByNameUseCase: SearchUsersByNameUseCase
): ViewModel() {

    val users = MutableLiveData<List<User>>()
    val isLoading = MutableLiveData<Boolean>()

     fun getUsers(){
        isLoading.postValue(true)
        viewModelScope.launch {
            users.postValue(getUsersUseCase.invoke())
        }
        isLoading.postValue(false)
    }

    fun searchUsersByName(input:String):LiveData<List<User>>{
        return seacthUsersByNameUseCase.invoke(input).asLiveData()
    }
}