package com.sz.rx.android.ui.base;

/**
 * Created by jhpark on 2016. 5. 24..
 */
public interface Presenter<V extends MvpView> {
  void attachView(V mvpView);
  void detachView();
}
