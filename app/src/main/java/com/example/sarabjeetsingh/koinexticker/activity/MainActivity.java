package com.example.sarabjeetsingh.koinexticker.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sarabjeetsingh.koinexticker.R;

import java.util.List;

import model.Crypto;
import model.KoinexResponse;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFreshData();
    }

    private void getFreshData(){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<KoinexResponse> call = apiInterface.getCryptoValues();
        call.enqueue(new Callback<KoinexResponse>() {
            @Override
            public void onResponse(Call<KoinexResponse> call, Response<KoinexResponse> response) {
                Crypto crypto = response.body().getPrices();
                Log.i("BTC",crypto.getBitcoin());
            }

            @Override
            public void onFailure(Call<KoinexResponse> call, Throwable t) {
                Log.e("Error in request", t.toString());
            }
        });
    }
}
