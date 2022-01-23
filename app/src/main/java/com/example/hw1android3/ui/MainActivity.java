package com.example.hw1android3.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hw1android3.R;
import com.example.hw1android3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}