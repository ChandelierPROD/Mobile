package com.example.finalprodproject.feature_roadmap.presentation.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.finalprodproject.R;

public class DeepEduFragmentDirections {
  private DeepEduFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionDeepEduFragmentToProblemsFragment() {
    return new ActionOnlyNavDirections(R.id.action_deepEduFragment_to_problemsFragment);
  }
}
