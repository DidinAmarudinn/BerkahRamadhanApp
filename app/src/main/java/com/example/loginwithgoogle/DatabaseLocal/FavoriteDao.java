package com.example.loginwithgoogle.DatabaseLocal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface FavoriteDao {
    @Insert
    void addData(FavoriteList favoriteList);

    @Query("select * from favoritelist")
    List<FavoriteList> getFavoriteData();

    @Query("SELECT EXISTS (SELECT 1 FROM favoritelist WHERE id=:id)")
    int isFavorite(int id);

    @Delete
    void delete(FavoriteList favoriteList);
}
