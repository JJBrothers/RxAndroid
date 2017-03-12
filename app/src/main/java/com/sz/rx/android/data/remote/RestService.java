package com.sz.rx.android.data.remote;

import android.annotation.SuppressLint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sz.rx.android.data.model.TopicInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
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
      System.out.println("여기는 몇번오나#### ");
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
