package rudenko.andrey.currenciesapp.common;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public abstract class EndlessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {

    // The current offset index of data you have loaded
    private int currentPage = 0;
    // The total number of items in the dataset after the last load
    private int previousTotalItemCount = 0;
    // True if we are still waiting for the last set of data to load.
    private boolean loading = true;

    private RecyclerView.LayoutManager mLinearLayoutManager;

    protected EndlessRecyclerViewScrollListener(LinearLayoutManager layoutManager) {
        this.mLinearLayoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {

        int totalItemCount = mLinearLayoutManager.getItemCount();
        int lastVisibleItemPosition = 0;
        lastVisibleItemPosition = ((LinearLayoutManager) mLinearLayoutManager).findLastVisibleItemPosition();
        if (totalItemCount < previousTotalItemCount) {
            this.currentPage = 0;
            this.previousTotalItemCount = totalItemCount;
            if (totalItemCount == 0) {
                this.loading = true;
            }
        }

        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false;
            previousTotalItemCount = totalItemCount;
        }

        int visibleThreshold = 5;
        if (!loading && lastVisibleItemPosition + visibleThreshold > totalItemCount) {
            currentPage++;
            onLoadMore(currentPage, totalItemCount);
            loading = true;
        }
    }

    public abstract void onLoadMore(int page, int totalItemsCount);
}
