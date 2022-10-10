package com.example.bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EntityDao {
    @Query("SELECT * FROM entity_table")
    fun getAll(): Flow<List<Entity>>

    @Insert
    fun insertAll(entities: List<Entity>)

    @Insert
    fun insert(entity: Entity)

    @Query("DELETE FROM entity_table")
    fun deleteAll()
}