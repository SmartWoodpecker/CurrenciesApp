package rudenko.andrey.currenciesapp.mvpmodels;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public interface DateModel {
    void addDateToList();

    void setItemcount(Integer itemcount);

    ArrayList<Date> getModeldateList();
}
