package rudenko.andrey.currenciesapp.presentation.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


import rudenko.andrey.currenciesapp.mvpmodels.DateDetailsModelImpl;
import rudenko.andrey.currenciesapp.mvpmodels.DateDetailsModel;
import rudenko.andrey.currenciesapp.presentation.view.DateDetailsView;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */
@InjectViewState
public class DateDetailsPresenter extends MvpPresenter<DateDetailsView> {

    private DateDetailsModel dateModel = new DateDetailsModelImpl();
    private String month;
    private String year;
    private String day;

    public DateDetailsPresenter(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getCurrency();
    }

    private void getCurrency() {
        getViewState().showProgressBar();
        dateModel.getAllCurrency(year, month, day)
                .doAfterTerminate(() -> getViewState().hideProgressBar())
                .subscribe(currencies -> getViewState().showCurrenciesCourse(currencies),
                        error -> getViewState().showConnectionError()
                );
    }

}
