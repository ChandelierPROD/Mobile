// Generated by view binder compiler. Do not edit!
package com.example.finalprodproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.finalprodproject.R;
import com.google.android.material.chip.ChipGroup;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ShopFragmentBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ChipGroup categoryList;

  @NonNull
  public final RecyclerView shopCoursesList;

  @NonNull
  public final ImageView topCard;

  private ShopFragmentBinding(@NonNull LinearLayout rootView, @NonNull ChipGroup categoryList,
      @NonNull RecyclerView shopCoursesList, @NonNull ImageView topCard) {
    this.rootView = rootView;
    this.categoryList = categoryList;
    this.shopCoursesList = shopCoursesList;
    this.topCard = topCard;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ShopFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ShopFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.shop_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ShopFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.category_list;
      ChipGroup categoryList = ViewBindings.findChildViewById(rootView, id);
      if (categoryList == null) {
        break missingId;
      }

      id = R.id.shop_courses_list;
      RecyclerView shopCoursesList = ViewBindings.findChildViewById(rootView, id);
      if (shopCoursesList == null) {
        break missingId;
      }

      id = R.id.top_card;
      ImageView topCard = ViewBindings.findChildViewById(rootView, id);
      if (topCard == null) {
        break missingId;
      }

      return new ShopFragmentBinding((LinearLayout) rootView, categoryList, shopCoursesList,
          topCard);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
