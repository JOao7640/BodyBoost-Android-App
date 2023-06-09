package com.example.bodyboost.Exercise_classes;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.HomeFragment;
import com.example.bodyboost.R;
import com.example.bodyboost.User;
import com.example.bodyboost.UserCompleted;
import com.example.bodyboost.UserCompletedDao;
import com.example.bodyboost.UserPlanDao;
import com.example.bodyboost.WorkoutPlanDao;

public class ExerciseFragment extends Fragment implements ExerciseSetAdapter.ExerciseSetAdapterEventListener {
    private int userId; // Declare the userId variable

    private ExerciseSetAdapter adapter;
    private AppDatabase db;

    private int exerciseDay;
    private DaysDao daysDao;
    private WorkoutPlanDao workoutPlanDao;
    private UserPlanDao userPlanDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtain an instance of AppDatabase and DaysDao
        db = AppDatabase.getInstance(getContext());
        daysDao = db.getDaysDao();
        workoutPlanDao = db.getWorkoutPlanDao();
        userPlanDao = db.getUserPlanDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Retrieve the userId from the arguments using HomeFragmentArgs
        userId = HomeFragment.userId;

        // Stores the given argument (an ID of the selected day) in the exerciseDay variable
        int exerciseDay = ExerciseFragmentArgs.fromBundle(getArguments()).getExerciseDay();

        TextView dayOfWeek = view.findViewById(R.id.dayIndicatorTextView);
        dayOfWeek.setText(daysDao.getDayByID(exerciseDay));

        RecyclerView recyclerView = view.findViewById(R.id.exerciseRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        int planId = userPlanDao.getUserPlanById(userId);
        adapter = new ExerciseSetAdapter(this, workoutPlanDao.getExerciseInfosFromPlan(planId, exerciseDay), workoutPlanDao.getExercises(HomeFragment.userId, exerciseDay), getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onExerciseCompleted() {
        refreshFragment();
    }

    public void refreshFragment() {

        adapter.updateData(workoutPlanDao.getExercises(HomeFragment.userId, exerciseDay));

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();

        onExerciseCompleted();
    }
}