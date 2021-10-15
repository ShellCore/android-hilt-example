package mx.dev.shell.android.ejemplohilt.flow.page1.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import mx.dev.shell.android.ejemplohilt.core.usecase.Page1UseCase
import mx.dev.shell.android.ejemplohilt.core.usecase.Page1UseCaseImpl

@Module
@InstallIn(FragmentComponent::class)
abstract class Page1Module {

    @Binds
    abstract fun bindsPage1UseCase(impl: Page1UseCaseImpl): Page1UseCase
}