package com.example.bodyboost.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.R;
import com.example.bodyboost.viewmodels.DaysViewModel;
import com.example.bodyboost.viewmodels.UserCompletedViewModel;
import com.example.bodyboost.viewmodels.UserPlanViewModel;
import com.example.bodyboost.viewmodels.WorkoutViewModel;
import java.util.List;


public class ExerciseFragment extends Fragment implements ExerciseSetAdapter.ExerciseSetAdapterEventListener {
    private int userId;
    private int day;
    private ExerciseSetAdapter adapter;
    private DaysViewModel daysViewModel;
    private WorkoutViewModel workoutViewModel;
    private UserPlanViewModel userPlanViewModel;
    private UserCompletedViewModel userCompletedViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the viewmodels
        userPlanViewModel = new ViewModelProvider(this).get(UserPlanViewModel.class);
        userCompletedViewModel = new ViewModelProvider(this).get(UserCompletedViewModel.class);
        workoutViewModel = new ViewModelProvider(this).get(WorkoutViewModel.class);
        daysViewModel = new ViewModelProvider(this).get(DaysViewModel.class);
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
        day = ExerciseFragmentArgs.fromBundle(getArguments()).getExerciseDay();

        // Get and set the name of the day
        TextView dayOfWeek = view.findViewById(R.id.dayIndicatorTextView);
        dayOfWeek.setText(daysViewModel.getDayByID(day));

        RecyclerView recyclerView = view.findViewById(R.id.exerciseRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Get the id of the user's plan
        int planId = userPlanViewModel.getUserPlanById(userId);

        // Get the list of exercises for the user in the specific day
        List<Exercise> getExercisesForUser = userCompletedViewModel.getExercisesForUser(userId, day, planId);
        adapter = new ExerciseSetAdapter(this, day ,getExercisesForUser, getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onExerciseCompleted() {
        refreshFragment();
    }

    public void refreshFragment() {

        adapter.updateData(workoutViewModel.getExercises(HomeFragment.userId, day));

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();

        onExerciseCompleted();
    }
}