package com.sz.rx.android.ui.main;

import android.os.Bundle;
import android.widget.TextView;
import com.sz.rx.android.R;
import com.sz.rx.android.ui.base.BaseActivity;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jhpark on 2016. 5. 24..
 */
public class MainActivity extends BaseActivity implements MainMvpView{

  @Inject MainPresenter mMainPresenter;
  @BindView(R.id.txtView) TextView mTxtView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivityComponent().inject(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    mMainPresenter.attachView(this);
    mTxtView.setText("MVP");

    //sharePreference에서 token을 꺼네거나 util을 만들어관리하거나 ...
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzUsImlhdCI6MTQ4NzgyNDM0M30.CN0QFUTpJx3ORwuOfYcmQNbk6Xob36lxYH_48ZN1w9g";
    mMainPresenter.getSmplSelect(token);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  public void onDataSuccess() {

  }

  @Override
  public void onDataEmpty() {
    System.out.println("ui 처리..");
  }

  @Override
  public void onError() {
    System.out.println("에러 ui 처리 ..");
  }
}
