package mx.dev.shell.android.ejemplohilt.flow.page1.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import mx.dev.shell.android.ejemplohilt.core.usecase.Page1UseCase
import javax.inject.Inject

class Page1ViewModel @Inject constructor(private val page1UseCase: Page1UseCase) : ViewModel() {

    val loading = MutableLiveData<Boolean>()
    val result = MutableLiveData<String>()
    val errorMessage = MutableLiveData<String>()

    fun queryInfo() {
        loading.postValue(true)

        viewModelScope.launch (Dispatchers.IO) {
            page1UseCase.queryUserInfo()
                .onEach {
                    loading.postValue(false)
                }
                .collect {
                if (it.isSuccess) {
                    result.postValue(it.getOrNull()?:"Cayó pedo en la matrix")
                } else {
                    errorMessage.postValue(it.exceptionOrNull()?.message?:"Falló algo en las capas internas")
                }
            }
        }
    }
}