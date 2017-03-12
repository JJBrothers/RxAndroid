package com.sz.rx.android.ui.main;

import com.sz.rx.android.ui.base.MvpView;

/**
 * Created by jhpark on 2016. 5. 24..
 */
public interface MainMvpView extends MvpView{
  void onDataSuccess();
  void onDataEmpty();
  //void onError();
}
