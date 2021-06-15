package fr.mappy.fizzbuzz.data.local

import fr.mappy.fizzbuzz.data.models.FormEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val formDao: FormDao) {

    suspend fun insertOrUpdateForm(
        input1Int: Int,
        input2Int: Int,
        input1Str: String,
        input2Str: String
    ) {
        formDao.insertOrUpdate(input1Int, input2Int, input1Str, input2Str)
    }


    suspend fun getTop5Forms() : List<FormEntity> = formDao.getTopFiveFormByHits()

}