package rudenko.andrey.currenciesapp.api;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rudenko.andrey.currenciesapp.entity.AllValuteEntity;
import rudenko.andrey.currenciesapp.entity.ValuteEntity;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public interface CurrencyApi {
    @GET("archive//{year}//{month}//{day}//daily_json.js")
    Single<AllValuteEntity> getCurrency(@Path("year") String year,
                                        @Path("month") String month,
                                        @Path("day") String day);
}
