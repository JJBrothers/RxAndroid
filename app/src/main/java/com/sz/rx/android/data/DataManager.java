package com.sz.rx.android.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sz.rx.android.data.remote.RestService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by jhpark on 2016. 5. 24..
 */
@Singleton
public class DataManager {

  private final RestService mRestService;

  @Inject
  public DataManager(RestService restService) {
    mRestService = restService;
  }

  public Observable<Map<Object,Object>> getSmplSelect(String token){
    return mRestService.getSmplSelect(token)
          .concatMap(objectMap -> {
          Type dataSet = new TypeToken<ArrayList<Map<Object,Object>>>() {}.getType();

          ArrayList<Map<Object,Object>> data = new Gson().fromJson(new Gson().toJson(objectMap.get("data")), dataSet);
          System.out.println(new Gson().toJson(objectMap.get("data")));
          return Observable.from(data);
        });
  }

//
//  public Observable<TopicInfo> getTopicInfo(Map<String,String> params) {
//    return mRestService.getTopicInfo(params)
//            .concatMap(objectMap -> {
//              Type dataSet = new TypeToken<ArrayList<TopicInfo>>() {}.getType();
//                ArrayList<TopicInfo> topicInfos = new Gson().fromJson(new Gson().toJson(objectMap.get("list")), dataSet);
//              System.out.println(new Gson().toJson(objectMap.get("cmd")));
//              System.out.println(topicInfos.size());
//              System.out.println(new Gson().toJson(objectMap.get("list"))+"####");
//
////                Type dataSet = new TypeToken<ArrayList<TopicInfo>>() {}.getType();
////                ArrayList<TopicInfo> topicInfos = new Gson().fromJson(new Gson().toJson(objectObjectMap.get("list")), dataSet);
//
//              return Observable.from(topicInfos);
//            });
//
//
////            .observeOn(AndroidSchedulers.mainThread())
////            .subscribeOn(Schedulers.io())
////            .concatMap(new Func1<Map<Object, Object>, Observable<? extends TopicInfo>>() {
////              @Override
////              public Observable<? extends TopicInfo> call(Map<Object, Object> objectObjectMap) {
////                Type dataSet = new TypeToken<ArrayList<TopicInfo>>() {}.getType();
////                ArrayList<TopicInfo> topicInfos = new Gson().fromJson(new Gson().toJson(objectObjectMap.get("list")), dataSet);
////                return Observable.from(topicInfos);
////              }
////            });
//  }
}
