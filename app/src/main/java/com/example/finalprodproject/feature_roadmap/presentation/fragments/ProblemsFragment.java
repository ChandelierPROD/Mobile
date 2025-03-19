package com.example.finalprodproject.feature_roadmap.presentation.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.finalprodproject.R;
import com.example.finalprodproject.databinding.ProblemsFragmentBinding;
import com.example.finalprodproject.feature_roadmap.data.models.TaskModel;
import com.example.finalprodproject.feature_roadmap.presentation.factories.ThemesViewModelFactory;
import com.example.finalprodproject.feature_roadmap.presentation.viewmodels.ThemesViewModel;

public class ProblemsFragment extends Fragment {
    private ProblemsFragmentBinding binding;
    private int underThemeID = -1;
    private ThemesViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ProblemsFragmentBinding.inflate(getLayoutInflater(), container, false);
        viewModel = new ViewModelProvider(requireActivity(), new ThemesViewModelFactory(requireActivity().getApplication())).get(ThemesViewModel.class);

        Bundle args = getArguments();
        if (args != null) {
            underThemeID = args.getInt("id");
        }

        binding.arrowBack.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());
        binding.nextButton.setOnClickListener(v -> {
            LayoutInflater inflater1 = getLayoutInflater();
            View layout = inflater1.inflate(R.layout.saved_toast, null);
            Toast toast = new Toast(getContext());
            toast.setGravity(Gravity.TOP, 0, 100);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        });


//        binding.roadmap.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_problemsFragment_to_roadmapFragment));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (underThemeID != -1) {
            viewModel.getByUnderTheme(underThemeID).observe(getViewLifecycleOwner(), underTheme -> {
                if (underTheme != null && underTheme.getTasks() != null) {
                    //Log.d("msg", tasksList.get(0).getDescription());
                    for (TaskModel task : underTheme.getTasks()) {
                        binding.taskDescription.setText(underTheme.getTasks().get(0).getDescription());
                        Glide.with(requireView()).load(underTheme.getTasks().get(0).getImage()).into(binding.taskPicture);
                    }
                }
            });
        }
    }
}
