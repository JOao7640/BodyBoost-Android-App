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
import android.widget.Toast;

import com.example.bodyboost.R;
import com.example.bodyboost.models.Feed;
import com.example.bodyboost.models.MealResponse;
import com.example.bodyboost.models.Meals;
import com.example.bodyboost.models.NewsResponse;
import com.example.bodyboost.viewmodels.NewsViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class feedFragment extends Fragment {

    private FeedAdapter adapter;
    private NewsViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the needed viewmodel
        viewModel = new ViewModelProvider(this).get(NewsViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.feedRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        // Collect all the news from the API through the fetchNews method in the viewmodel
        viewModel.fetchNews(getContext());

        // Create observer from the getNews method in the viewmodel
        viewModel.getNews().observe(getViewLifecycleOwner(), news -> {

            adapter = new FeedAdapter(news);
            recyclerView.setAdapter(adapter);
        });

    }
}