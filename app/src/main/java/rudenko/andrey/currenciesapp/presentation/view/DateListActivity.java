package rudenko.andrey.currenciesapp.presentation.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import rudenko.andrey.currenciesapp.R;
import rudenko.andrey.currenciesapp.common.EndlessRecyclerViewScrollListener;
import rudenko.andrey.currenciesapp.common.CurrencyAdapter;
import rudenko.andrey.currenciesapp.presentation.presenter.DateListPresenter;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class DateListActivity extends MvpAppCompatActivity implements DateListView {

    @InjectPresenter
    DateListPresenter presenter;
    RecyclerView rv_currency_list;
    CurrencyAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_list);
        initializeToolbar();
        initializeRecycler();
    }

    public void initializeToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setTitle(R.string.main);
    }

    @Override
    public void createScrollListener() {
        rv_currency_list.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                presenter.getDate(totalItemsCount);
            }
        });
    }

    private void initializeRecycler() {
        rv_currency_list = findViewById(R.id.rv_currency_list);
        layoutManager = new LinearLayoutManager(rv_currency_list.getContext());
        rv_currency_list.setLayoutManager(layoutManager);
        rv_currency_list.addItemDecoration(new DividerItemDecoration(rv_currency_list.getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void addProposalsToList(ArrayList<Date> dates) {
        if (adapter == null) {
            adapter = new CurrencyAdapter(dates, (Date date) -> presenter.dateListItemClicked(date));
            rv_currency_list.setAdapter(adapter);
        } else {
            adapter.setData(dates);
        }
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void navigateToDateDetailsAtcivity(Date date) {
        Intent intent = new Intent(this, DateDetailsActivity.class);
        intent.putExtra("year", new SimpleDateFormat("yyyy").format(date));
        intent.putExtra("day", new SimpleDateFormat("dd").format(date));
        intent.putExtra("month", new SimpleDateFormat("MM").format(date));
        startActivity(intent);
    }

}
