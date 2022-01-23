package com.example.hw1android3.ui.filmsDetail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw1android3.R;
import com.example.hw1android3.databinding.FragmentFilmsDetailBinding;

public class FilmsDetailFragment extends Fragment {
    private FragmentFilmsDetailBinding binding;

    public FilmsDetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_films_detail, container, false);
    }
}