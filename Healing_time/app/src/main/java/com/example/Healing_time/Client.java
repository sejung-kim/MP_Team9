package com.example.Healing_time;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Client {

    private static final String BASE_URL = "http://humming1106.dothome.co.kr";
    private static Client myClient;
    private Retrofit retrofit;

    private Client(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized Client getInstancce(){

        if(myClient == null){
            myClient = new Client();
        }
        return myClient;
    }

    public Api getApi(){
        return  retrofit.create(Api.class);
    }
}
