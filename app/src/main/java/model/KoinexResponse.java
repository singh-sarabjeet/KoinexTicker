package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sarabjeet Singh on 25-12-2017.
 */

public class KoinexResponse {
    public Crypto getPrices() {
        return prices;
    }

    public void setPrices(Crypto prices) {
        this.prices = prices;
    }

    @SerializedName("prices")
    private Crypto prices;
}
