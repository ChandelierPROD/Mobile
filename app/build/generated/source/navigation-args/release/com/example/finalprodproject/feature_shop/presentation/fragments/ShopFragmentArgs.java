package com.example.finalprodproject.feature_shop.presentation.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ShopFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ShopFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ShopFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ShopFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ShopFragmentArgs __result = new ShopFragmentArgs();
    bundle.setClassLoader(ShopFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("id")) {
      int id;
      id = bundle.getInt("id");
      __result.arguments.put("id", id);
    } else {
      throw new IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ShopFragmentArgs fromSavedStateHandle(@NonNull SavedStateHandle savedStateHandle) {
    ShopFragmentArgs __result = new ShopFragmentArgs();
    if (savedStateHandle.contains("id")) {
      int id;
      id = savedStateHandle.get("id");
      __result.arguments.put("id", id);
    } else {
      throw new IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getId() {
    return (int) arguments.get("id");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("id")) {
      int id = (int) arguments.get("id");
      __result.putInt("id", id);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("id")) {
      int id = (int) arguments.get("id");
      __result.set("id", id);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ShopFragmentArgs that = (ShopFragmentArgs) object;
    if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
      return false;
    }
    if (getId() != that.getId()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getId();
    return result;
  }

  @Override
  public String toString() {
    return "ShopFragmentArgs{"
        + "id=" + getId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull ShopFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(int id) {
      this.arguments.put("id", id);
    }

    @NonNull
    public ShopFragmentArgs build() {
      ShopFragmentArgs result = new ShopFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setId(int id) {
      this.arguments.put("id", id);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public int getId() {
      return (int) arguments.get("id");
    }
  }
}
