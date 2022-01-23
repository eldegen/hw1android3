package com.example.hw1android3.ui.films;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw1android3.data.models.FilmModel;
import com.example.hw1android3.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {
    private List<FilmModel> films = new ArrayList<>();
    private OnItemClick listener;

    public FilmsAdapter(OnItemClick listener) {
        this.listener = listener;
    }

    public void setFilms(List<FilmModel> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(films.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public void addItem(FilmModel filmModel) {
        films.add(0, filmModel);
    }

    // ViewHolder class
    public class FilmsViewHolder extends RecyclerView.ViewHolder {
        private ItemFilmBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(FilmModel filmModel) {
            binding.title.setText(filmModel.getTitle());
            binding.description.setText(filmModel.getDescription());
        }
    }
}
