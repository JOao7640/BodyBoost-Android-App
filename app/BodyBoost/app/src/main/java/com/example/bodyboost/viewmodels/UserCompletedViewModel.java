package com.example.bodyboost.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.models.Ingredients;
import com.example.bodyboost.models.UserCompleted;
import com.example.bodyboost.models.UserCompletedRepository;

import java.util.List;

public class UserCompletedViewModel extends AndroidViewModel {
    private UserCompletedRepository repository;

    public UserCompletedViewModel(@NonNull Application application) {
        super(application);
        // Initialize repository
        this.repository = new UserCompletedRepository(application.getApplicationContext());
    }
    public List<Exercise> getExercisesForUser(int userId, int dayId, int planId) {
        return repository.getExercisesForUser(userId, dayId, planId);
    }

    public int checkIfExerciseCompleted(int userId, int dayId, int planId) {
        return repository.checkIfExerciseCompleted(userId, dayId, planId);
    }

    public void updateExerciseCompleted(int value, int dayId, int userId, int exerciseId){
        repository.updateExerciseCompleted(value,dayId,userId,exerciseId);
    }

    public int countExercisesForUser(int userId, int dayId){
        return repository.countExercisesForUser(userId,dayId);
    }

    public int ammountCompleted(int userId, int dayId){
        return repository.ammountCompleted(userId,dayId);
    }


    public int ammountOfExercisesInDay(int userId, int dayId){
        return repository.ammountOfExercisesInDay(userId,dayId);
    }

    public void deleteByUserId(int userId){
        repository.deleteByUserId(userId);
    }

    public void insert(UserCompleted userCompleted){
        repository.insert(userCompleted);
    }

}




