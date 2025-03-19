package com.example.finalprodproject.feature_user.presentation.screens;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.finalprodproject.R;

public class EditProfileDialogFragmentDirections {
  private EditProfileDialogFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionEditProfileDialogFragmentToProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_editProfileDialogFragment_to_profileFragment);
  }
}
