// Generated by view binder compiler. Do not edit!
package com.example.finalprodproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.finalprodproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CoursesCategoryItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RecyclerView coursesCategoryItemRecycler;

  @NonNull
  public final TextView coursesCategoryItemTitle;

  private CoursesCategoryItemBinding(@NonNull LinearLayout rootView,
      @NonNull RecyclerView coursesCategoryItemRecycler,
      @NonNull TextView coursesCategoryItemTitle) {
    this.rootView = rootView;
    this.coursesCategoryItemRecycler = coursesCategoryItemRecycler;
    this.coursesCategoryItemTitle = coursesCategoryItemTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CoursesCategoryItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CoursesCategoryItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.courses_category_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CoursesCategoryItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.courses_category_item_recycler;
      RecyclerView coursesCategoryItemRecycler = ViewBindings.findChildViewById(rootView, id);
      if (coursesCategoryItemRecycler == null) {
        break missingId;
      }

      id = R.id.courses_category_item_title;
      TextView coursesCategoryItemTitle = ViewBindings.findChildViewById(rootView, id);
      if (coursesCategoryItemTitle == null) {
        break missingId;
      }

      return new CoursesCategoryItemBinding((LinearLayout) rootView, coursesCategoryItemRecycler,
          coursesCategoryItemTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
