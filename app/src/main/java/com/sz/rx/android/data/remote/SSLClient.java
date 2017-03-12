package com.sz.rx.android.data.remote;

import android.annotation.SuppressLint;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by jaehunpark on 2017. 3. 12..
 */

public class SSLClient {
    private static final String TAG = "RetrofitHelper";
    private OkHttpClient httpClient = new OkHttpClient.Builder().build();
    private static SSLClient mInstance;
    private Retrofit mRetrofit;

    private SSLClient() {
    }

    public static SSLClient getInstance() {
        if (mInstance == null) {
            synchronized (SSLClient.class) {
                mInstance = new SSLClient();
            }
        }
        return mInstance;
    }

    public OkHttpClient createSSLClient(){
        try {
            SSLContext sc;
            sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new X509TrustManager() {
                @SuppressLint("TrustAllX509TrustManager")
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @SuppressLint("TrustAllX509TrustManager")
                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }}, new SecureRandom());

            HostnameVerifier hv = (hostname, session) -> true;

            String workerClassName = "okhttp3.OkHttpClient";
            try {
                Class workerClass = Class.forName(workerClassName);
                java.lang.reflect.Field hostnameVerifier = workerClass.getDeclaredField("hostnameVerifier");
                hostnameVerifier.setAccessible(true);
                hostnameVerifier.set(httpClient, hv);

                java.lang.reflect.Field sslSocketFactory = workerClass.getDeclaredField("sslSocketFactory");
                sslSocketFactory.setAccessible(true);
                sslSocketFactory.set(httpClient, sc.getSocketFactory());

                return httpClient;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
////http://blog.fobid.me/3