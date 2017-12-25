package rest;

import model.Crypto;
import model.KoinexResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sarabjeet Singh on 25-12-2017.
 */

public interface ApiInterface {

    @GET("api/ticker")
    Call<KoinexResponse> getCryptoValues();
}
