package fr.mappy.fizzbuzz.domain.form

interface FormRepository {
    suspend fun saveHitForForm(input1Int: Int,
                        input2Int: Int,
                        input1Str: String,
                        input2Str: String)
}