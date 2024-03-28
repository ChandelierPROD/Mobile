package com.example.finalprodproject.feature_main.presentation.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalprodproject.databinding.NoNetworkFragmentBinding;

public class NoNetworkFragment extends Fragment {
    private NoNetworkFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = NoNetworkFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}
