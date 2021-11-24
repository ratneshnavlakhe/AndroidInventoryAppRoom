package com.example.inventory.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM item WHERE id = :id")
    fun getItemId(id: Int): LiveData<Item>

    @Query("SELECT * FROM item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
}