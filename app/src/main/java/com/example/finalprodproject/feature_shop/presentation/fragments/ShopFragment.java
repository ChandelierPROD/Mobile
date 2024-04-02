package com.example.finalprodproject.feature_shop.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.finalprodproject.R;
import com.example.finalprodproject.databinding.ShopFragmentBinding;
import com.example.finalprodproject.feature_roadmap.presentation.factories.ThemesViewModelFactory;
import com.example.finalprodproject.feature_roadmap.presentation.viewmodels.ThemesViewModel;
import com.example.finalprodproject.feature_shop.data.models.CourseShopModel;
import com.example.finalprodproject.feature_shop.presentation.adapters.ShopCategoryAdapter;
import com.example.finalprodproject.feature_shop.presentation.adapters.ShopCoursesAdapter;
import com.example.finalprodproject.feature_user.presentation.screens.BuyCourseDialogFragment;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;


public class ShopFragment extends Fragment {
    private ShopFragmentBinding binding;
    private ThemesViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ShopFragmentBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ThemesViewModelFactory(requireActivity().getApplication())).get(ThemesViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getCategories().observe(getViewLifecycleOwner(), categories -> {
            if (categories != null) {

                for (String category: categories) {
                    Chip chip = new Chip(requireContext());
                    chip.setText(category);
                    chip.setCheckable(true);
                    chip.setChipBackgroundColorResource(R.color.white);
                    chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
//                    chip.setChipDrawable(ChipDrawable.createFromResource(requireContext(), R.xml.chip_wrapper));

                    chip.setOnCheckedChangeListener((buttonView, isChecked) -> {
                        if (isChecked) {
                            chip.setChipBackgroundColorResource(R.color.black);
                            chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
                        } else {
                            chip.setChipBackgroundColorResource(R.color.white);
                            chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
                        }
                    });

                    binding.categoryList.addView(chip);
                }
            }
        });

        viewModel.getCourses().observe(getViewLifecycleOwner(), courses -> {
            if (courses != null) {
                ShopCoursesAdapter adapter = new ShopCoursesAdapter(courses);
                adapter.setOnItemClickListener(courseShopModel -> {
                    BuyCourseDialogFragment dialogFragment = new BuyCourseDialogFragment(courseShopModel);
                    dialogFragment.show(getParentFragmentManager(), "BuyCourseDialogFragment");
                });

                binding.shopCoursesList.setAdapter(adapter);
            }
        });
    }
}
