package com.sz.rx.android.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sz.rx.android.MvpApplication;
import com.sz.rx.android.injection.component.ActivityComponent;

import com.sz.rx.android.injection.component.DaggerActivityComponent;
import com.sz.rx.android.injection.module.ActivityModule;

/**
 * Created by jhpark on 2016. 5. 24..
 */
public class BaseActivity extends AppCompatActivity{

  private ActivityComponent mActivityComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public ActivityComponent getActivityComponent() {
    if (mActivityComponent == null) {
      mActivityComponent = DaggerActivityComponent.builder()
              //.activityModule(new ActivityModule(this))
              .applicationComponent(MvpApplication.get(this).getComponent())
              .build();
    }
    return mActivityComponent;
  }
}
