//package com.sz.rx.android;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//
//import java.util.ArrayList;
//
//import rx.Observable;
//import rx.Subscriber;
//import rx.functions.Func0;
//import rx.functions.Func1;
//import rx.schedulers.Schedulers;
//
//public class MainActivity extends AppCompatActivity {
//
//  //RxAndroid
//  //http://gaemi.github.io/android/2015/05/20/RxJava%20with%20Android%20-%201%20-%20RxJava%20%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0.html
//
//  //RetroLambda
//  //http://tiii.tistory.com/5
//
//  private final String TAG = "RXANDROID";
//
//  @Override
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_main);
//
//    ////ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ just(), from() ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//
//////Observable 은 이벤트를 발생시키는 주체
////    Log.e(TAG,"create observable");
////    //Observable<String> observable = Observable.just("개미");//just()는 누군가가 구독(subscribe)을 하게 되면 "개미" 라는 이벤트를 1번 발생시키는 Observable 이라고 이해하시면 됩니다.
////    Observable<String> observable = Observable.from(new String[] { "개미", "매", "마루" });//Observable.from() 은 배열 또는 Iterable 의 요소를 순서대로 이벤트로 발생시키는 Observable 이라고 이해하시면 됩니다. 즉 "개미", "매", "마루" 순서로 이벤트가 발생이 되겠네요.
////    Log.e(TAG, "do subscribe");
////    observable.subscribe(new Subscriber<String>() {
////      @Override
////      public void onNext(String text) {
////        Log.e(TAG, "onNext : "+text);
////      }
////
////      @Override
////      public void onCompleted() {
////        Log.e(TAG, "onCompleted");
////      }
////
////      @Override
////      public void onError(Throwable e) {
////        Log.e(TAG, "onError : " + e.getMessage());
////      }
////    });
//
//
//    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ defer() ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
////
////    Log.e(TAG, "create observable");
////    Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {//Observable.defer() 는 구독(subscribe) 하는 순간 특정 function 을 실행하고 리턴받은 Observable 의 이벤트를 전달합니다.
////      @Override public Observable<String> call() {
////        Log.e(TAG,"defer function call");
////        return Observable.just("HelloWorld");
////      }
////    });
////    Log.e(TAG, "do subscribe");
////    observable.subscribe(new Subscriber<String>() {
////      @Override public void onNext(String text) {
////        Log.e(TAG, "onNext : " + text);
////      }
////
////      @Override public void onCompleted() {
////        Log.e(TAG, "onCompleted");
////      }
////
////      @Override public void onError(Throwable e) {
////        Log.e(TAG, "onError : " + e.getMessage());
////      }
////    });
//
//
//    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ subscribeOn(), observeOn() 1번째 exampleㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//
////    Log.e(TAG,Thread.currentThread().getName() + ", create observable");
////    Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
////      @Override public Observable<String> call() {
////        Log.e(TAG, Thread.currentThread().getName() + ", defer function call");
////        return Observable.just("HelloWorld");
////      }
////    });
////    Log.e(TAG, Thread.currentThread().getName() + ", do subscribe");
////    observable
////            .subscribeOn(Schedulers.computation()) // computation thread 에서 defer function 이 실행됩니다.
////            .observeOn(Schedulers.newThread()) // 새로운 thread 에서 Subscriber 로 이벤트가 전달됩니다.
////            .subscribe(new Subscriber<String>() {
////              @Override public void onNext(String text) {
////                Log.e(TAG, Thread.currentThread().getName() + ", onNext : " + text);
////              }
////
////              @Override public void onCompleted() {
////                Log.e(TAG, Thread.currentThread().getName() + ", onCompleted");
////              }
////
////              @Override public void onError(Throwable e) {
////                Log.e(TAG, Thread.currentThread().getName() + ", onError : " + e.getMessage());
////              }
////            });
////
////    Log.e(TAG, Thread.currentThread().getName() + ", after subscribe");
//
//
//    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ subscribeOn(), observeOn() 2번째 exampleㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//
//
////    Log.e(TAG, Thread.currentThread().getName() + ", create observable");
////    Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
////      @Override public Observable<String> call() {
////        Log.e(TAG, Thread.currentThread().getName() + ", defer function call");
////        return Observable.just("HelloWorld");
////      }
////    });
////    Log.e(TAG, Thread.currentThread().getName() + ", do subscribe");
////
////    Observable<String> observable2 = observable
////            .subscribeOn(Schedulers.computation())
////            .observeOn(Schedulers.newThread())
////            .map(new Func1<String, String>() {
////              @Override public String call(String text) {
////                Log.e(TAG, Thread.currentThread().getName() + ", map");
////                return "(" + text + ")";
////              }
////            });
////
////    observable2
////            .observeOn(Schedulers.newThread())
////            .subscribe(new Subscriber<String>() {
////              @Override public void onNext(String text) {
////                Log.e(TAG, Thread.currentThread().getName() + ", onNext : " + text);
////              }
////
////              @Override public void onCompleted() {
////                Log.e(TAG, Thread.currentThread().getName() + ", onCompleted");
////              }
////
////              @Override public void onError(Throwable e) {
////                Log.e(TAG, Thread.currentThread().getName() + ", onError : " + e.getMessage());
////              }
////            });
////
////    Log.e(TAG, Thread.currentThread().getName() + ", after subscribe");
//
//
////ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ RetroLambda ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//
////    Log.e(TAG, "create observable");
////    Observable<String> observable = Observable.just("개미");
////    Log.e(TAG, "do subscribe");
////    observable.subscribe(
////            text -> {
////              Log.e(TAG, "onNext : " + text);
////              Log.e(TAG, "중괄호 {}를 사용할수있다 .");
////            },
////            e -> Log.e(TAG, "onError : " + e.getMessage()),
////            () -> Log.e(TAG, "onCompleted")
////    );
////
////    Log.e(TAG, "after subscribe");
////
////
////    new Thread(()->{
////      System.out.println("asdasdasd");
////    }).start();
//
//
////합쳐서 결과한번에 받기
////
////    Observable.zip(
////            Observable.just("개미"),
////            Observable.just("gaemi.jpg"),
////            (profile1, image) -> "프로필 : " + profile1 + ", 이미지 : " + image
////    ).subscribe(
////            print -> System.out.println("onNext : " + print),
////            e -> System.out.println("onError"),
////            () -> System.out.println("onCompleted")
////    );
//
//
//    System.out.println(Thread.currentThread().getName() + ", create observable");
//    Observable<String> observable = Observable.defer(() -> {
//      return Observable.just("HelloWorld");
//    });
//    System.out.println(Thread.currentThread().getName() + ", do subscribe");
//
//    Observable<String> observable2 = observable
//            .subscribeOn(Schedulers.computation())
//            .observeOn(Schedulers.newThread())
//            .map((text) -> {
//              return "(" + text + ")";
//            });
//
//    observable2
//            .observeOn(Schedulers.newThread())
//            .subscribe((text) -> System.out.println(Thread.currentThread().getName() + ", onNext : " + text),
//                    (e) -> System.out.println(Thread.currentThread().getName() + ", onError : " + e.getMessage()),
//                    () -> System.out.println(Thread.currentThread().getName() + ", onCompleted")
//            );
////            .subscribe(new Subscriber<String>() {
////              @Override public void onNext(String text) {
////                System.out.println(Thread.currentThread().getName() + ", onNext : " + text);
////              }
////
////              @Override public void onCompleted() {
////                System.out.println(Thread.currentThread().getName() + ", onCompleted");
////              }
////
////              @Override public void onError(Throwable e) {
////                System.out.println(Thread.currentThread().getName() + ", onError : " + e.getMessage());
////              }
////            });
//
//    System.out.println(Thread.currentThread().getName() + ", after subscribe");
//
//
//  }
//}
