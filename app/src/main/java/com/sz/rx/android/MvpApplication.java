package com.sz.rx.android;

import android.app.Application;
import android.content.Context;

import com.sz.rx.android.injection.component.ApplicationComponent;

import com.sz.rx.android.injection.component.DaggerApplicationComponent;
import com.sz.rx.android.injection.module.ApplicationModule;


/**
 * Created by jhpark on 2016. 5. 24..
 */
public class MvpApplication extends Application {

  ApplicationComponent mApplicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
  }

  public static MvpApplication get(Context context) {
    return (MvpApplication) context.getApplicationContext();
  }

  public ApplicationComponent getComponent() {
    if (mApplicationComponent == null) {
      mApplicationComponent = DaggerApplicationComponent.builder()
              .applicationModule(new ApplicationModule(this))
              .build();
    }
    return mApplicationComponent;
  }

  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }
}
