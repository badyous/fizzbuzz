package fr.mappy.fizzbuzz.domain.statistics

import fr.mappy.fizzbuzz.data.models.FormEntity

interface StatisticsRepository {
    suspend fun getTopFiveFormsByHits() : List<FormEntity>
}