package com.example.hw1android3.ui.filmsDetail;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.hw1android3.App;
import com.example.hw1android3.R;
import com.example.hw1android3.data.models.FilmModel;
import com.example.hw1android3.databinding.FragmentFilmsBinding;
import com.example.hw1android3.databinding.FragmentFilmsDetailBinding;
import com.example.hw1android3.ui.films.FilmsFragment;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsDetailFragment extends Fragment {
    private FragmentFilmsDetailBinding binding;
    private String bufferId;

    public FilmsDetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmsDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            Log.d("pizzaa", "onViewCreated: got string: " + getArguments().getString("sendId"));
            bufferId = getArguments().getString("sendId");
        }

        App.api.getFilmById(bufferId).enqueue(new Callback<FilmModel>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Glide.with(getContext()).load(response.body().getMovieBanner()).into(binding.ivBanner);

                    binding.tvTitle.setText(response.body().getTitle());
                    binding.tvTitleJapan.setText(response.body().getOriginalTitle());
                    binding.tvAuthor.setText(response.body().getDirector());
                    binding.tvProducer.setText(response.body().getProducer());

                    binding.tvDuration.setText(fromMinutesToHHmmNew(Integer.parseInt(response.body().getDuration())));

                    binding.tvRtScore.setText(response.body().getRtScore() + "%");
                    binding.tvDescription.setText(response.body().getDescription());
                }
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {

            }
        });
    }

    private void setInfo() {

    }

    public String fromMinutesToHHmmOld(int minutes) {
        String startTime = "00:00";
        int h = minutes / 60 + Integer.parseInt(startTime.substring(0,1));
        int m = minutes % 60 + Integer.parseInt(startTime.substring(3,4));
        String time = h+":"+m;
        return time;
    }

    public String fromMinutesToHHmmNew(int minutes) {
        long hours = TimeUnit.MINUTES.toHours(Long.valueOf(minutes));
        long remainMinutes = minutes - TimeUnit.HOURS.toMinutes(hours);
        return String.format("%02d:%02d", hours, remainMinutes);
    }
}