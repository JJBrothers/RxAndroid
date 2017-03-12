package com.sz.rx.android.injection.component;

import android.app.Application;
import android.content.Context;

import com.sz.rx.android.data.DataManager;
import com.sz.rx.android.data.remote.RestService;
import com.sz.rx.android.injection.ApplicationContext;
import com.sz.rx.android.injection.module.ApplicationModule;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  //void inject(SyncService syncService);

  @ApplicationContext Context context();
  Application application();
  RestService restService();
  DataManager dataManager();
}
