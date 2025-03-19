package com.example.finalprodproject.feature_course_end_page.presentation;

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

public class CourseEndFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CourseEndFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CourseEndFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CourseEndFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CourseEndFragmentArgs __result = new CourseEndFragmentArgs();
    bundle.setClassLoader(CourseEndFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("name")) {
      String name;
      name = bundle.getString("name");
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("name", name);
    } else {
      throw new IllegalArgumentException("Required argument \"name\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("points")) {
      int points;
      points = bundle.getInt("points");
      __result.arguments.put("points", points);
    } else {
      throw new IllegalArgumentException("Required argument \"points\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CourseEndFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    CourseEndFragmentArgs __result = new CourseEndFragmentArgs();
    if (savedStateHandle.contains("name")) {
      String name;
      name = savedStateHandle.get("name");
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("name", name);
    } else {
      throw new IllegalArgumentException("Required argument \"name\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("points")) {
      int points;
      points = savedStateHandle.get("points");
      __result.arguments.put("points", points);
    } else {
      throw new IllegalArgumentException("Required argument \"points\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getName() {
    return (String) arguments.get("name");
  }

  @SuppressWarnings("unchecked")
  public int getPoints() {
    return (int) arguments.get("points");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("name")) {
      String name = (String) arguments.get("name");
      __result.putString("name", name);
    }
    if (arguments.containsKey("points")) {
      int points = (int) arguments.get("points");
      __result.putInt("points", points);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("name")) {
      String name = (String) arguments.get("name");
      __result.set("name", name);
    }
    if (arguments.containsKey("points")) {
      int points = (int) arguments.get("points");
      __result.set("points", points);
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
    CourseEndFragmentArgs that = (CourseEndFragmentArgs) object;
    if (arguments.containsKey("name") != that.arguments.containsKey("name")) {
      return false;
    }
    if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
      return false;
    }
    if (arguments.containsKey("points") != that.arguments.containsKey("points")) {
      return false;
    }
    if (getPoints() != that.getPoints()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + getPoints();
    return result;
  }

  @Override
  public String toString() {
    return "CourseEndFragmentArgs{"
        + "name=" + getName()
        + ", points=" + getPoints()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull CourseEndFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String name, int points) {
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("name", name);
      this.arguments.put("points", points);
    }

    @NonNull
    public CourseEndFragmentArgs build() {
      CourseEndFragmentArgs result = new CourseEndFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setName(@NonNull String name) {
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("name", name);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPoints(int points) {
      this.arguments.put("points", points);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getName() {
      return (String) arguments.get("name");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public int getPoints() {
      return (int) arguments.get("points");
    }
  }
}
