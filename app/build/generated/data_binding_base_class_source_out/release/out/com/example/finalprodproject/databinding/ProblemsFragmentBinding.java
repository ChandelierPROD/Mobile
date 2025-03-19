// Generated by view binder compiler. Do not edit!
package com.example.finalprodproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.finalprodproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProblemsFragmentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText answer;

  @NonNull
  public final ImageView arrowBack;

  @NonNull
  public final AppCompatButton nextButton;

  @NonNull
  public final AppCompatButton task1;

  @NonNull
  public final AppCompatButton task2;

  @NonNull
  public final AppCompatButton task3;

  @NonNull
  public final TextView taskDescription;

  @NonNull
  public final TextView taskNum;

  @NonNull
  public final ImageView taskPicture;

  @NonNull
  public final ImageView topCard;

  private ProblemsFragmentBinding(@NonNull ConstraintLayout rootView, @NonNull EditText answer,
      @NonNull ImageView arrowBack, @NonNull AppCompatButton nextButton,
      @NonNull AppCompatButton task1, @NonNull AppCompatButton task2,
      @NonNull AppCompatButton task3, @NonNull TextView taskDescription, @NonNull TextView taskNum,
      @NonNull ImageView taskPicture, @NonNull ImageView topCard) {
    this.rootView = rootView;
    this.answer = answer;
    this.arrowBack = arrowBack;
    this.nextButton = nextButton;
    this.task1 = task1;
    this.task2 = task2;
    this.task3 = task3;
    this.taskDescription = taskDescription;
    this.taskNum = taskNum;
    this.taskPicture = taskPicture;
    this.topCard = topCard;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProblemsFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProblemsFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.problems_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProblemsFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.answer;
      EditText answer = ViewBindings.findChildViewById(rootView, id);
      if (answer == null) {
        break missingId;
      }

      id = R.id.arrow_back;
      ImageView arrowBack = ViewBindings.findChildViewById(rootView, id);
      if (arrowBack == null) {
        break missingId;
      }

      id = R.id.next_button;
      AppCompatButton nextButton = ViewBindings.findChildViewById(rootView, id);
      if (nextButton == null) {
        break missingId;
      }

      id = R.id.task_1;
      AppCompatButton task1 = ViewBindings.findChildViewById(rootView, id);
      if (task1 == null) {
        break missingId;
      }

      id = R.id.task_2;
      AppCompatButton task2 = ViewBindings.findChildViewById(rootView, id);
      if (task2 == null) {
        break missingId;
      }

      id = R.id.task_3;
      AppCompatButton task3 = ViewBindings.findChildViewById(rootView, id);
      if (task3 == null) {
        break missingId;
      }

      id = R.id.task_description;
      TextView taskDescription = ViewBindings.findChildViewById(rootView, id);
      if (taskDescription == null) {
        break missingId;
      }

      id = R.id.task_num;
      TextView taskNum = ViewBindings.findChildViewById(rootView, id);
      if (taskNum == null) {
        break missingId;
      }

      id = R.id.task_picture;
      ImageView taskPicture = ViewBindings.findChildViewById(rootView, id);
      if (taskPicture == null) {
        break missingId;
      }

      id = R.id.top_card;
      ImageView topCard = ViewBindings.findChildViewById(rootView, id);
      if (topCard == null) {
        break missingId;
      }

      return new ProblemsFragmentBinding((ConstraintLayout) rootView, answer, arrowBack, nextButton,
          task1, task2, task3, taskDescription, taskNum, taskPicture, topCard);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
