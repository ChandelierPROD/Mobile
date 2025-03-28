// Generated by data binding compiler. Do not edit!
package com.example.finalprodproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.finalprodproject.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AuthFragmentBinding extends ViewDataBinding {
  @NonNull
  public final LoadingLayoutBinding loader;

  @NonNull
  public final FrameLayout loadingLayout;

  @NonNull
  public final FrameLayout successAuth;

  @NonNull
  public final SuccessAuthFragmentBinding successLayout;

  protected AuthFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LoadingLayoutBinding loader, FrameLayout loadingLayout, FrameLayout successAuth,
      SuccessAuthFragmentBinding successLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.loader = loader;
    this.loadingLayout = loadingLayout;
    this.successAuth = successAuth;
    this.successLayout = successLayout;
  }

  @NonNull
  public static AuthFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.auth_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AuthFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AuthFragmentBinding>inflateInternal(inflater, R.layout.auth_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static AuthFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.auth_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AuthFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AuthFragmentBinding>inflateInternal(inflater, R.layout.auth_fragment, null, false, component);
  }

  public static AuthFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static AuthFragmentBinding bind(@NonNull View view, @Nullable Object component) {
    return (AuthFragmentBinding)bind(component, view, R.layout.auth_fragment);
  }
}
