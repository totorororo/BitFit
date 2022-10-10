package com.example.bitfit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entity_table")
data class Entity(
    @ColumnInfo(name = "title") var titleDesc: String,
    @ColumnInfo(name = "value") var value: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
)
