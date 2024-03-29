package com.example.bodyboost.models.databaseModels;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bodyboost.models.Report;

import java.util.List;

@Dao
public interface ReportDao {

    @Query("SELECT * FROM report WHERE userId = :userId ORDER BY date DESC")
    LiveData<List<Report>> getAll(int userId);

    @Query("SELECT * FROM report WHERE reportID = :id")
    Report getById(int id);

    @Insert
    void insert(Report report);

    @Update
    void update(Report report);

    @Delete
    void delete(Report report);

}
