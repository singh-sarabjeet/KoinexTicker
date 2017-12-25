package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sarabjeet Singh on 25-12-2017.
 */

public class Crypto {
    public String getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(String bitcoin) {
        this.bitcoin = bitcoin;
    }

    public String getEther() {
        return ether;
    }

    public void setEther(String ether) {
        this.ether = ether;
    }

    public String getBitcoinCash() {
        return bitcoinCash;
    }

    public void setBitcoinCash(String bitcoinCash) {
        this.bitcoinCash = bitcoinCash;
    }

    public String getRipple() {
        return ripple;
    }

    public void setRipple(String ripple) {
        this.ripple = ripple;
    }

    public String getLitecoin() {
        return litecoin;
    }

    public void setLitecoin(String litecoin) {
        this.litecoin = litecoin;
    }

    @SerializedName("BTC")
    private String bitcoin;
    @SerializedName("ETH")
    private String ether;
    @SerializedName("BCH")
    private String bitcoinCash;
    @SerializedName("XRP")
    private String ripple;
    @SerializedName("LTC")
    private String litecoin;
}
