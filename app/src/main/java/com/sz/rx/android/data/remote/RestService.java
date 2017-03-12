package com.sz.rx.android.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

/**
 * Created by jhpark on 2016. 5. 24..
 */
public interface RestService {

  String ENDPOINT = "https://210.221.219.131:187/";

  @GET("/api/schdl/getThmCode")
  Observable<Map<Object,Object>> getSmplSelect(@Header("token") String token);

  class Creator{
    public static RestService newRestService(){

      Gson gson = new GsonBuilder()
              .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
              .create();
      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(RestService.ENDPOINT)
              .addConverterFactory(GsonConverterFactory.create(gson))
              .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
              .client(SSLClient.getInstance().createSSLClient())
              .build();
      return retrofit.create(RestService.class);
    }
  }
}
