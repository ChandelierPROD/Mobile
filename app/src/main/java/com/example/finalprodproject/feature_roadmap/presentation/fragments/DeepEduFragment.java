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

import com.example.finalprodproject.R;
import com.example.finalprodproject.databinding.ThemeDetailsBinding;
import com.example.finalprodproject.feature_roadmap.presentation.factories.ThemesViewModelFactory;
import com.example.finalprodproject.feature_roadmap.presentation.viewmodels.ThemesViewModel;

public class DeepEduFragment extends Fragment {
    private ThemeDetailsBinding binding;
    private ThemesViewModel viewModel;
    private String themeID;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ThemeDetailsBinding.inflate(getLayoutInflater(), container, false);

        Bundle args = getArguments();
        if (args != null) {
            themeID = args.getString("id");

            viewModel = new ViewModelProvider(this, new ThemesViewModelFactory(requireActivity().getApplication())).get(ThemesViewModel.class);

            viewModel.loadThemeData(themeID).observe(requireActivity(), themeDTO -> {
                if (themeDTO != null) {
                    binding.themeTitle.setText(themeDTO.getCategory());
                    binding.themeName.setText(themeDTO.getTitle());
                }
            });

            binding.webView.getSettings().setJavaScriptEnabled(true);
            String link = "qaFOd_Ho6vI?si=NTCgxaoeAga652BA";
            String url = "https://www.youtube.com/embed/" + link;

            binding.webView.loadUrl(url);
        }

        binding.smile1.setOnClickListener(v -> setMark(1));
        binding.smile2.setOnClickListener(v -> setMark(2));
        binding.smile3.setOnClickListener(v -> setMark(3));
        binding.smile4.setOnClickListener(v -> setMark(4));
        binding.smile5.setOnClickListener(v -> setMark(5));

        binding.arrowBack.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());

        binding.startTest.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("id", themeID);
            Navigation.findNavController(v).navigate(R.id.action_deepEduFragment_to_problemsFragment, bundle);
        });

        return binding.getRoot();
    }

    private void setMark(int mark) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.mark_toast, null);
        Toast toast = new Toast(getContext());
        toast.setGravity(Gravity.TOP, 0, 120);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
        Log.d("toast", "toast");
        viewModel.setMark(mark);
    }
}
