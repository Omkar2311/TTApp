package demo.vega.com.ttdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.vega.com.ttdemo.R;

public class SpecificTrendingListAdapter extends RecyclerView.Adapter<SpecificTrendingListAdapter.MyViewHolder> {
    private Context context;

    public SpecificTrendingListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SpecificTrendingListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_specific_trending_list,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecificTrendingListAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
