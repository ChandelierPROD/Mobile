package com.example.finalprodproject.feature_study_page.presentation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.finalprodproject.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class StudyFragmentDirections {
  private StudyFragmentDirections() {
  }

  @NonNull
  public static ActionStudyFragmentToStudyInformationFragment actionStudyFragmentToStudyInformationFragment(
      int id) {
    return new ActionStudyFragmentToStudyInformationFragment(id);
  }

  @NonNull
  public static ActionStudyFragmentToRoadmapFragment actionStudyFragmentToRoadmapFragment(int id) {
    return new ActionStudyFragmentToRoadmapFragment(id);
  }

  @NonNull
  public static ActionStudyFragmentToCourseEndFragment actionStudyFragmentToCourseEndFragment(
      @NonNull String name, int points) {
    return new ActionStudyFragmentToCourseEndFragment(name, points);
  }

  public static class ActionStudyFragmentToStudyInformationFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionStudyFragmentToStudyInformationFragment(int id) {
      this.arguments.put("id", id);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionStudyFragmentToStudyInformationFragment setId(int id) {
      this.arguments.put("id", id);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("id")) {
        int id = (int) arguments.get("id");
        __result.putInt("id", id);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_studyFragment_to_studyInformationFragment;
    }

    @SuppressWarnings("unchecked")
    public int getId() {
      return (int) arguments.get("id");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionStudyFragmentToStudyInformationFragment that = (ActionStudyFragmentToStudyInformationFragment) object;
      if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
        return false;
      }
      if (getId() != that.getId()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getId();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionStudyFragmentToStudyInformationFragment(actionId=" + getActionId() + "){"
          + "id=" + getId()
          + "}";
    }
  }

  public static class ActionStudyFragmentToRoadmapFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionStudyFragmentToRoadmapFragment(int id) {
      this.arguments.put("id", id);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionStudyFragmentToRoadmapFragment setId(int id) {
      this.arguments.put("id", id);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("id")) {
        int id = (int) arguments.get("id");
        __result.putInt("id", id);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_studyFragment_to_roadmapFragment;
    }

    @SuppressWarnings("unchecked")
    public int getId() {
      return (int) arguments.get("id");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionStudyFragmentToRoadmapFragment that = (ActionStudyFragmentToRoadmapFragment) object;
      if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
        return false;
      }
      if (getId() != that.getId()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getId();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionStudyFragmentToRoadmapFragment(actionId=" + getActionId() + "){"
          + "id=" + getId()
          + "}";
    }
  }

  public static class ActionStudyFragmentToCourseEndFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionStudyFragmentToCourseEndFragment(@NonNull String name, int points) {
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("name", name);
      this.arguments.put("points", points);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionStudyFragmentToCourseEndFragment setName(@NonNull String name) {
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("name", name);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionStudyFragmentToCourseEndFragment setPoints(int points) {
      this.arguments.put("points", points);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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

    @Override
    public int getActionId() {
      return R.id.action_studyFragment_to_courseEndFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionStudyFragmentToCourseEndFragment that = (ActionStudyFragmentToCourseEndFragment) object;
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
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getName() != null ? getName().hashCode() : 0);
      result = 31 * result + getPoints();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionStudyFragmentToCourseEndFragment(actionId=" + getActionId() + "){"
          + "name=" + getName()
          + ", points=" + getPoints()
          + "}";
    }
  }
}
