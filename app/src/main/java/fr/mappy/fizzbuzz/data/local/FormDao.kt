package fr.mappy.fizzbuzz.data.local

import androidx.room.*
import fr.mappy.fizzbuzz.data.models.FormEntity

@Dao
interface FormDao {

    @Transaction
    suspend fun insertOrUpdate(
        input1Int: Int,
        input2Int: Int,
        input1Str: String,
        input2Str: String
    ) {
        val formEntityToInsert = FormEntity(input1Int, input2Int, input1Str, input2Str, 1)
        val insertIgnore = insertIgnore(formEntityToInsert)
        if (insertIgnore == -1L) {
            //Already exists (insert Ignored), then we should update it
            val hitsFromFormEntity =
                getHitsFromFormEntity(input1Int, input2Int, input1Str, input2Str)
            update(FormEntity(input1Int, input2Int, input1Str, input2Str, hitsFromFormEntity + 1))
        }
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertIgnore(entity: FormEntity): Long

    @Update
    fun update(entity: FormEntity)

    @Query("SELECT * FROM formTable GROUP BY hits LIMIT 5")
    suspend fun getTopFiveFormByHits(): List<FormEntity>

    @Query("SELECT hits FROM formTable WHERE input1Int = :input1Int AND input2Int = :input2Int AND input1String = :input1Str AND input2String = :input2Str")
    suspend fun getHitsFromFormEntity(
        input1Int: Int,
        input2Int: Int,
        input1Str: String,
        input2Str: String
    ): Int
}