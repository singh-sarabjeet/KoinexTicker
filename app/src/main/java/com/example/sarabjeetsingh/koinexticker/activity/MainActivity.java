package com.example.sarabjeetsingh.koinexticker.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sarabjeetsingh.koinexticker.R;

import adapter.CryptoListAdapter;
import model.Crypto;
import model.KoinexResponse;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Crypto crypto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFreshData();
    }


    private void getFreshData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<KoinexResponse> call = apiInterface.getCryptoValues();
        call.enqueue(new Callback<KoinexResponse>() {
            @Override
            public void onResponse(Call<KoinexResponse> call, Response<KoinexResponse> response) {
                crypto = response.body().getPrices();
                Log.i("BTC", crypto.getBitcoin());

                RecyclerView cryptoRecyclerView = findViewById(R.id.cryptoRecyclerView);
                CryptoListAdapter cryptoListAdapter = new CryptoListAdapter(crypto, getApplicationContext());
                cryptoRecyclerView.setAdapter(cryptoListAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                cryptoRecyclerView.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<KoinexResponse> call, Throwable t) {
                Log.e("Error in request", t.toString());
            }
        });
    }
}
