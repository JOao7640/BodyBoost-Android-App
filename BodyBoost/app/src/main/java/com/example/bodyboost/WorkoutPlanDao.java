package com.example.bodyboost;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.Exercise_classes.ExerciseSet;

import java.util.List;

@Dao
public interface WorkoutPlanDao {

    @Query("SELECT * FROM workoutplan")
    List<WorkoutPlan> getAll();

    @Query("SELECT exercise.* FROM exercise, usercompleted WHERE dayId = :dayId AND userId = :userId AND userCompleted.exerciseId = exercise.exerciseId")
    List<Exercise> getExercises(int userId, int dayId);

    @Query("SELECT exerciseId FROM WorkoutPlan WHERE planId = :planId AND dayId = :dayId")
    List<Integer> getExercisesInDay(int planId, int dayId);
}
