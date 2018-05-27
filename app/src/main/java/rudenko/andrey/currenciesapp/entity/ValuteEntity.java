package rudenko.andrey.currenciesapp.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class ValuteEntity {

    @SerializedName("USD")
    private ValuteDetailsEntity usd;
    @SerializedName("EUR")
    private ValuteDetailsEntity eur;

    public ValuteDetailsEntity getUsd() {
        return usd;
    }

    public void setUsd(ValuteDetailsEntity usd) {
        this.usd = usd;
    }

    public ValuteDetailsEntity getEur() {
        return eur;
    }

    public void setEur(ValuteDetailsEntity eur) {
        this.eur = eur;
    }
}
