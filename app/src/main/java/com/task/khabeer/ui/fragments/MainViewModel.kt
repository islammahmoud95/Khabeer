package com.task.khabeer.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.task.domain.entities.model.response.payrollrespons.PayRollResponse
import com.task.domain.usecases.PayRollUseCases
import kotlinx.coroutines.launch
import com.task.domain.common.Result
import com.task.domain.entities.model.response.allowences.Allowences
import com.task.domain.entities.model.response.user.User


class MainViewModel (val useCases: PayRollUseCases) : ViewModel(){
    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading
    private val _viewModelChanged = MutableLiveData<Boolean>()
    val viewModelChanged = _viewModelChanged

    private val _response = MutableLiveData<PayRollResponse>()
    val response = _response

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse = _errorResponse

    var employee= User()
    var allowences= ArrayList<Allowences>()

    fun getPayRoll() {
        _loading.postValue(true)
        viewModelScope.launch {
                val response = useCases.invoke()

            when (response) {
                is Result.Success -> {
                    _loading.postValue(false)
                    _response.postValue(response.data)
                }
                is Result.Error -> {
                    _errorResponse.postValue(response.exception.message)
                    _loading.postValue(false)

                }
            }
        }
    }

    class AttachedViewModelFactory(
        val useCases: PayRollUseCases
    ) :
        ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(
                useCases
            ) as T
        }
    }

}