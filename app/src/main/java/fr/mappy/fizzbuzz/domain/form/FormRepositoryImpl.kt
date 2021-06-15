package fr.mappy.fizzbuzz.domain.form

import fr.mappy.fizzbuzz.data.local.LocalDataSource
import javax.inject.Inject

class FormRepositoryImpl @Inject constructor(private val source: LocalDataSource) : FormRepository {
    override suspend fun saveHitForForm(
        input1Int: Int,
        input2Int: Int,
        input1Str: String,
        input2Str: String
    ) {
        source.insertOrUpdateForm(input1Int, input2Int, input1Str, input2Str)
    }

}