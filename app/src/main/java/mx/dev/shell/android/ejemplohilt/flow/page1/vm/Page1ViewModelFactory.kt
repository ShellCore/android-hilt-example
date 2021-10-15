package mx.dev.shell.android.ejemplohilt.flow.page1.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.dev.shell.android.ejemplohilt.core.usecase.Page1UseCase
import javax.inject.Inject

class Page1ViewModelFactory @Inject constructor(
    private val page1UseCase: Page1UseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Page1ViewModel(page1UseCase) as T
    }
}