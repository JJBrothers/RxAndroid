package com.sz.rx.android.injection.component;

import com.sz.rx.android.injection.PerActivity;
import com.sz.rx.android.injection.module.ActivityModule;
import com.sz.rx.android.ui.main.MainActivity;


import dagger.Component;


/**
 * This component inject dependencies to all Activities across the application
        */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
