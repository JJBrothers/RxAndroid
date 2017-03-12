package com.sz.rx.android.injection.module;

import android.app.Application;
import android.content.Context;

import com.sz.rx.android.data.DataManager;
import com.sz.rx.android.data.remote.RestService;
import com.sz.rx.android.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
  protected final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  Application provideApplication() {
    return mApplication;
  }

  @Provides
  @ApplicationContext
  Context provideContext() {
    return mApplication;
  }

  @Provides
  @Singleton
  RestService provideRestService() {
    return RestService.Creator.newRestService();
  }
}
