package com.example.hw1android3.ui.filmsDetail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw1android3.App;
import com.example.hw1android3.R;
import com.example.hw1android3.databinding.FragmentFilmsBinding;
import com.example.hw1android3.databinding.FragmentFilmsDetailBinding;
import com.example.hw1android3.ui.films.FilmsFragment;

public class FilmsDetailFragment extends Fragment {
    private FragmentFilmsDetailBinding binding;

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
        }
    }
}