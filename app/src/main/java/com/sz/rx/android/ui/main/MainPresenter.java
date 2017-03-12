package com.sz.rx.android.ui.main;

import com.sz.rx.android.data.DataManager;
import com.sz.rx.android.ui.base.BasePresenter;

import java.util.Map;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jhpark on 2016. 5. 24..
 */
public class MainPresenter extends BasePresenter<MainMvpView> {

  private final DataManager mDataManager;
  private Subscription mSubscription;

  @Inject
  public MainPresenter(DataManager dataManager) {
    mDataManager = dataManager;
  }

  @Override
  public void attachView(MainMvpView mvpView) {
    super.attachView(mvpView);
  }

  @Override
  public void detachView() {
    super.detachView();
    if (mSubscription != null) mSubscription.unsubscribe();
  }

//  public void loadData(Map<String, String> params) {
//    checkViewAttached();
//    //System.out.println("서버에서 데이터받아오자 !! ");
//    mSubscription = mDataManager.getTopicInfo(params)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe(new Subscriber<TopicInfo>() {
//              @Override
//              public void onCompleted() {
//                System.out.println("완료 ...");
//                  getMvpView().onDataEmpty(); //2016.08.18 오전 1시 28분에 테스트 코드임
//                  getMvpView().onError();
//              }
//
//              @Override
//              public void onError(Throwable e) {
//                System.out.println("에러 ...");
//                e.printStackTrace();
//              }
//
//              @Override
//              public void onNext(TopicInfo data) {
//                System.out.println("데이터도착 ...");
//                System.out.println(data.topicId);
//                System.out.println(data.msgContent);
////                System.out.println(data.get("cmd").toString());
////                System.out.println(data.get("list") + "111");
////                Type dataSet = new TypeToken<ArrayList<TopicInfo>>() {}.getType();
////                ArrayList<TopicInfo> topicInfos = new Gson().fromJson(new Gson().toJson(data.get("list")), dataSet);
////                System.out.println(topicInfos.get(0).topicId + " <= 첫번째 topicId..");
////                System.out.println(topicInfos.get(1).topicId + " <= 두번째 topicId..");
//              }
//            });
//  }


    public void getSmplSelect(String token) {
        checkViewAttached();
        mSubscription = mDataManager.getSmplSelect(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Map<Object,Object>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("완료 ...");
                        getMvpView().onDataEmpty(); //2016.08.18 오전 1시 28분에 테스트 코드임

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("에러 ...");
                        e.printStackTrace();
                        getMvpView().onError();
                    }

                    @Override
                    public void onNext(Map<Object,Object> map ) {
                        System.out.println(map.get("codeNm"));
                        //System.out.println("데이터도착 ...");
//                        System.out.println(data.msgContent);

                    }
                });
    }
}
