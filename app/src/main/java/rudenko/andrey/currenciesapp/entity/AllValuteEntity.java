package rudenko.andrey.currenciesapp.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class AllValuteEntity {

    @SerializedName("Valute")
    ValuteEntity valute;

    public ValuteEntity getValute() {
        return valute;
    }

    public void setValute(ValuteEntity valute) {
        this.valute = valute;
    }
}
