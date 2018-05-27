package rudenko.andrey.currenciesapp.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import rudenko.andrey.currenciesapp.R;
import rudenko.andrey.currenciesapp.entity.AllValuteEntity;
import rudenko.andrey.currenciesapp.presentation.presenter.DateDetailsPresenter;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class DateDetailsActivity extends MvpAppCompatActivity implements DateDetailsView {

    @InjectPresenter
    DateDetailsPresenter presenter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_details);
        initializeToolbar();
        initializeProgressBar();
    }

    @ProvidePresenter
    DateDetailsPresenter provideDetailsPresenter() {
        Intent myIntent =getIntent();
        String month = myIntent.getStringExtra("month");
        String year = myIntent.getStringExtra("year");
        String day = myIntent.getStringExtra("day");
        return new DateDetailsPresenter(year,month,day);
    }

    public void initializeToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        getSupportActionBar().setTitle(R.string.course);
    }

    public void initializeProgressBar() {
        progressBar = findViewById(R.id.pb_date_details);
    }

    @Override
    public void showCurrenciesCourse(AllValuteEntity valute) {
        TextView tv_usd_ammount = findViewById(R.id.tv_usd_ammount);
        TextView tv_eur_ammount = findViewById(R.id.tv_eur_ammount);
        tv_usd_ammount.setText(valute.getValute().getUsd().getValue().toString());
        tv_eur_ammount.setText(valute.getValute().getEur().getValue().toString());
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(this, "Ошибка получения данных с сервера", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
