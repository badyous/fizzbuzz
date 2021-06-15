package fr.mappy.fizzbuzz.domain.statistics

import fr.mappy.fizzbuzz.data.local.LocalDataSource
import fr.mappy.fizzbuzz.data.models.FormEntity
import javax.inject.Inject

class StatisticsRepositoryImpl @Inject constructor(private val source: LocalDataSource) :
    StatisticsRepository {
    override suspend fun getTopFiveFormsByHits(): List<FormEntity> = source.getTop5Forms()
}