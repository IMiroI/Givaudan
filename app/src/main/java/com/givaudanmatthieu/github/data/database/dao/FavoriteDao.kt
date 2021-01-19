package com.givaudanmatthieu.github.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.givaudanmatthieu.github.data.database.model.Favorite

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite")
    suspend fun getFavorite(): List<Favorite>

}