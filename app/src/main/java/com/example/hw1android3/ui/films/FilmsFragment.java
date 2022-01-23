package com.example.hw1android3.ui.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw1android3.App;
import com.example.hw1android3.R;
import com.example.hw1android3.data.models.FilmModel;
import com.example.hw1android3.databinding.FragmentFilmsBinding;
import com.example.hw1android3.ui.filmsDetail.FilmsDetailFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsFragment extends Fragment implements OnItemClick{
    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public FilmsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new FilmsAdapter(this);

        fetchFilms();

        binding.recycler.setAdapter(adapter);
    }

    private void fetchFilms() {
        App.api.getFilms().enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setFilms(response.body());
                } else {
                    Log.e("pizzaa", "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                Log.e("pizzaa", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onClick(String id) {
        Bundle bundle = new Bundle();
        bundle.putString("sendId", id);

        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.filmsDetailFragment, bundle);
    }
}