// Generated by view binder compiler. Do not edit!
package com.example.finalprodproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.finalprodproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CourseEndBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView courseName;

  @NonNull
  public final ImageView lightning;

  @NonNull
  public final ImageView mainIcon;

  @NonNull
  public final ImageView plusIcon;

  @NonNull
  public final ImageView pointsCard;

  @NonNull
  public final TextView pointsVal;

  @NonNull
  public final TextView title1;

  @NonNull
  public final TextView title2;

  private CourseEndBinding(@NonNull ConstraintLayout rootView, @NonNull TextView courseName,
      @NonNull ImageView lightning, @NonNull ImageView mainIcon, @NonNull ImageView plusIcon,
      @NonNull ImageView pointsCard, @NonNull TextView pointsVal, @NonNull TextView title1,
      @NonNull TextView title2) {
    this.rootView = rootView;
    this.courseName = courseName;
    this.lightning = lightning;
    this.mainIcon = mainIcon;
    this.plusIcon = plusIcon;
    this.pointsCard = pointsCard;
    this.pointsVal = pointsVal;
    this.title1 = title1;
    this.title2 = title2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CourseEndBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CourseEndBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.course_end, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CourseEndBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.course_name;
      TextView courseName = ViewBindings.findChildViewById(rootView, id);
      if (courseName == null) {
        break missingId;
      }

      id = R.id.lightning;
      ImageView lightning = ViewBindings.findChildViewById(rootView, id);
      if (lightning == null) {
        break missingId;
      }

      id = R.id.main_icon;
      ImageView mainIcon = ViewBindings.findChildViewById(rootView, id);
      if (mainIcon == null) {
        break missingId;
      }

      id = R.id.plus_icon;
      ImageView plusIcon = ViewBindings.findChildViewById(rootView, id);
      if (plusIcon == null) {
        break missingId;
      }

      id = R.id.points_card;
      ImageView pointsCard = ViewBindings.findChildViewById(rootView, id);
      if (pointsCard == null) {
        break missingId;
      }

      id = R.id.points_val;
      TextView pointsVal = ViewBindings.findChildViewById(rootView, id);
      if (pointsVal == null) {
        break missingId;
      }

      id = R.id.title1;
      TextView title1 = ViewBindings.findChildViewById(rootView, id);
      if (title1 == null) {
        break missingId;
      }

      id = R.id.title2;
      TextView title2 = ViewBindings.findChildViewById(rootView, id);
      if (title2 == null) {
        break missingId;
      }

      return new CourseEndBinding((ConstraintLayout) rootView, courseName, lightning, mainIcon,
          plusIcon, pointsCard, pointsVal, title1, title2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
