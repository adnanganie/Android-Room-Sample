package com.alkowsar.bulksms.shared.rest;

import com.alkowsar.bulksms.utils.URLUtilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    /**
     * default time out set to 60 seconds
     * @return retrofit object
     */
    public static Retrofit getClient(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URLUtilities.BASE_URL)
                    .client(getOkHttpBuilder(60).build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    /**
     * @param seconds time in seconds
     * @return retrofit object
     */
    public static Retrofit getClient(int seconds){
        return new Retrofit.Builder()
                .baseUrl(URLUtilities.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getOkHttpBuilder(seconds).build())
                .build();
    }

    /**
     * @param timeout time out in seconds
     * @return OkHttpClint builder object
     */
    private static OkHttpClient.Builder getOkHttpBuilder(int timeout){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(timeout, TimeUnit.SECONDS);
        builder.connectTimeout(timeout, TimeUnit.SECONDS);

        return builder;
    }
}
