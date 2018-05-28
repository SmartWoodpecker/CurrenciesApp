package rudenko.andrey.currenciesapp.mvpmodels;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class DateModelImpl implements DateModel {
    private static final int ITEM_COUNT_ON_LOAD = 19;
    private ArrayList<Date> modelDateList = new ArrayList<>();
    private Integer itemCount;

    @Override
    public void setItemcount(Integer itemcount) {
        this.itemCount = itemcount;
    }

    public ArrayList<Date> getModeldateList() {
        return modelDateList;
    }

    @Override
    public void addDateToList() {
        for (int i = itemCount; i < itemCount + ITEM_COUNT_ON_LOAD; i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -i);
            Date date = cal.getTime();
            modelDateList.add(date);
        }
    }
}
