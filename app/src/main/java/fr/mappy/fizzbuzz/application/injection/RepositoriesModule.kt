package fr.mappy.fizzbuzz.application.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.mappy.fizzbuzz.domain.form.FormRepository
import fr.mappy.fizzbuzz.domain.form.FormRepositoryImpl
import fr.mappy.fizzbuzz.domain.statistics.StatisticsRepository
import fr.mappy.fizzbuzz.domain.statistics.StatisticsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun bindFormRepository(impl: FormRepositoryImpl): FormRepository

    @Binds
    abstract fun bindStatisticsRepository(impl: StatisticsRepositoryImpl): StatisticsRepository
}