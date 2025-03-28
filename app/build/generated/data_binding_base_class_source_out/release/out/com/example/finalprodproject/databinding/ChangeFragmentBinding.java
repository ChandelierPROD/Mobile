// Generated by view binder compiler. Do not edit!
package com.example.finalprodproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.finalprodproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ChangeFragmentBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatButton btnDialog;

  @NonNull
  public final EditText inputFirstname;

  @NonNull
  public final EditText inputLastname;

  @NonNull
  public final EditText inputOtchestvo;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView updateProfileError;

  private ChangeFragmentBinding(@NonNull LinearLayout rootView, @NonNull AppCompatButton btnDialog,
      @NonNull EditText inputFirstname, @NonNull EditText inputLastname,
      @NonNull EditText inputOtchestvo, @NonNull TextView title,
      @NonNull TextView updateProfileError) {
    this.rootView = rootView;
    this.btnDialog = btnDialog;
    this.inputFirstname = inputFirstname;
    this.inputLastname = inputLastname;
    this.inputOtchestvo = inputOtchestvo;
    this.title = title;
    this.updateProfileError = updateProfileError;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ChangeFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ChangeFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.change_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ChangeFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_dialog;
      AppCompatButton btnDialog = ViewBindings.findChildViewById(rootView, id);
      if (btnDialog == null) {
        break missingId;
      }

      id = R.id.input_firstname;
      EditText inputFirstname = ViewBindings.findChildViewById(rootView, id);
      if (inputFirstname == null) {
        break missingId;
      }

      id = R.id.input_lastname;
      EditText inputLastname = ViewBindings.findChildViewById(rootView, id);
      if (inputLastname == null) {
        break missingId;
      }

      id = R.id.input_otchestvo;
      EditText inputOtchestvo = ViewBindings.findChildViewById(rootView, id);
      if (inputOtchestvo == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.update_profile_error;
      TextView updateProfileError = ViewBindings.findChildViewById(rootView, id);
      if (updateProfileError == null) {
        break missingId;
      }

      return new ChangeFragmentBinding((LinearLayout) rootView, btnDialog, inputFirstname,
          inputLastname, inputOtchestvo, title, updateProfileError);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
