package fr.mappy.fizzbuzz.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "formTable",
    primaryKeys = ["input1Int", "input2Int", "input1String", "input2String"]
)
data class FormEntity(
    @ColumnInfo(name = "input1Int") val input1Int: Int,
    @ColumnInfo(name = "input2Int") val input2Int: Int,
    @ColumnInfo(name = "input1String") val input1String: String,
    @ColumnInfo(name = "input2String") val input2String: String,
    @ColumnInfo(name = "hits") val hits: Int,
)
