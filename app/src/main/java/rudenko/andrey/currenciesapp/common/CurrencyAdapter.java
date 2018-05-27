package rudenko.andrey.currenciesapp.common;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import rudenko.andrey.currenciesapp.R;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Date date);
    }

    private ArrayList<Date> data;
    private OnItemClickListener listener = null;

    public CurrencyAdapter(ArrayList<Date> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    public ArrayList<Date> getData() {
        return data;
    }

    public void setData(ArrayList<Date> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        v = inflater.inflate(R.layout.list_item_date, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder itemHolder = holder;
        itemHolder.tv_date.setText(data.get(position).toString());
        itemHolder.cl_date.setOnClickListener(v -> listener.onItemClick(data.get(position)));
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        } else return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_date;
        ConstraintLayout cl_date;

        ViewHolder(View itemView) {
            super(itemView);
            cl_date = itemView.findViewById(R.id.cl_date);
            tv_date = itemView.findViewById(R.id.tv_date);
        }
    }
}
