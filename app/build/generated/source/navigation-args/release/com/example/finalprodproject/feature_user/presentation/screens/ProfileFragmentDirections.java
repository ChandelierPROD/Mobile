package com.example.finalprodproject.feature_user.presentation.screens;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.finalprodproject.R;

public class ProfileFragmentDirections {
  private ProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionProfileFragmentToEditProfileDialogFragment() {
    return new ActionOnlyNavDirections(R.id.action_profileFragment_to_editProfileDialogFragment);
  }

  @NonNull
  public static NavDirections actionProfileFragmentToAuthFragment() {
    return new ActionOnlyNavDirections(R.id.action_profileFragment_to_authFragment);
  }
}
