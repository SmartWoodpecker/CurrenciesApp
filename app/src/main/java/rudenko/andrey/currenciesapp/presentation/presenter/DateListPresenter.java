package rudenko.andrey.currenciesapp.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Date;

import rudenko.andrey.currenciesapp.mvpmodels.DateModelImpl;
import rudenko.andrey.currenciesapp.mvpmodels.DateModel;
import rudenko.andrey.currenciesapp.presentation.view.DateListView;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */
@InjectViewState
public class DateListPresenter extends MvpPresenter<DateListView> {

    private DateModel dateModel = new DateModelImpl();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().createScrollListener();
        getDate(0);
    }

    public void getDate(int itemCount) {
        dateModel.setItemcount(itemCount);
        dateModel.addDateToList();
        getViewState().addProposalsToList(dateModel.getModeldateList());
    }

    public void dateListItemClicked(Date date) {
        getViewState().navigateToDateDetailsAtcivity(date);
    }
}
