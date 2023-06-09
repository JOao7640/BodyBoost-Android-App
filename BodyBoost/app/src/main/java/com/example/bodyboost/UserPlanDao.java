package com.example.bodyboost;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserPlanDao {

    @Query("SELECT * FROM UserPlan")
    List<UserPlan> getAll();

    @Query("SELECT planId FROM userplan WHERE userId = :id LIMIT 1")
    int getUserPlanById(int id);

    @Insert
    void insert(UserPlan userPlan);

}
