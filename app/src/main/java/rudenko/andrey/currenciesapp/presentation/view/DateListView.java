package rudenko.andrey.currenciesapp.presentation.view;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public interface DateListView extends MvpView {
    void createScrollListener();

    void addProposalsToList(ArrayList<Date> dates);

    void navigateToDateDetailsAtcivity(Date date);
}
