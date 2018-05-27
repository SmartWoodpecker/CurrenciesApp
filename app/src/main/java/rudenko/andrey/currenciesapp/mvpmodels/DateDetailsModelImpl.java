package rudenko.andrey.currenciesapp.mvpmodels;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import rudenko.andrey.currenciesapp.api.RetrofitClient;
import rudenko.andrey.currenciesapp.entity.AllValuteEntity;
import rudenko.andrey.currenciesapp.entity.ValuteEntity;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class DateDetailsModelImpl implements DateDetailsModel{

    @Override
    public Single<AllValuteEntity> getAllCurrency(String year, String month, String day) {
        RetrofitClient.getInstance();
        Single<AllValuteEntity> response = RetrofitClient.getCurrencyApiService().getCurrency(year, month, day);
        response = response.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return response;
    }
}
