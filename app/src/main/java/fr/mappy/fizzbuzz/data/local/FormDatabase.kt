package fr.mappy.fizzbuzz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.mappy.fizzbuzz.data.models.FormEntity

@Database(entities = [FormEntity::class], version = 1, exportSchema = false)
abstract class FormDatabase : RoomDatabase() {
    abstract fun formDao(): FormDao
}