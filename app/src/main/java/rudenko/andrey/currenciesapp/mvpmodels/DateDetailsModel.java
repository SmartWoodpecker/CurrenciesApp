package rudenko.andrey.currenciesapp.mvpmodels;

import io.reactivex.Single;
import rudenko.andrey.currenciesapp.entity.AllValuteEntity;
import rudenko.andrey.currenciesapp.entity.ValuteEntity;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public interface DateDetailsModel {
    Single<AllValuteEntity> getAllCurrency(String year, String month, String day);
}
