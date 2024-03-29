package com.example.bodyboost.views;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bodyboost.models.Feed;

import com.example.bodyboost.R;
import com.example.bodyboost.viewmodels.NewsViewModel;
import com.squareup.picasso.Picasso;

public class NewsFragment extends Fragment{

    Context context;
    private NewsViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this.getContext();

        // Initialize the news viewmodel
        viewModel = new ViewModelProvider(this).get(NewsViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Stores the given argument ( an ID of the selected new ) in the newsId variable
        int newsId = com.example.bodyboost.views.NewsFragmentArgs.fromBundle(getArguments()).getSelectedNew();

        ImageView newsImageView = view.findViewById(R.id.newsImageView2);
        TextView newsTitle = view.findViewById(R.id.newstitleTextView2);
        TextView newsSmallDescription = view.findViewById(R.id.newsSmallDescriptionTextView);
        TextView newsFullDescription = view.findViewById(R.id.newsDescriptionTextView2);
        TextView newsDateTextView = view.findViewById(R.id.newsDateTextView2);
        TextView newsWebsiteNameTextView = view.findViewById(R.id.websiteNameTextView);

        // Store the news with the given Id
        Feed news = viewModel.getById(newsId);

        // Load the news image and concatenate with base url into the imageView
        Picasso.get().load("http://10.0.2.2:8000/storage/" + news.getNewsImg()).into(newsImageView);

        // Set news information in the respective textviews
        newsTitle.setText(news.getNewsTitle());
        newsSmallDescription.setText(news.getNewsSmallDescription());
        newsFullDescription.setText(news.getNewsFullDescription());
        newsDateTextView.setText(news.getNewsDate());
        newsWebsiteNameTextView.setText("Read More");

        newsWebsiteNameTextView.setPaintFlags(newsWebsiteNameTextView.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        // Redirect the user to the source website to access the full news
        newsWebsiteNameTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(news.getSourceLink()));
                context.startActivity(viewIntent);
            }
        });

        // Redirect the user to the source website to access the full news
        newsImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(news.getSourceLink()));
                context.startActivity(viewIntent);
            }
        });


    }



}