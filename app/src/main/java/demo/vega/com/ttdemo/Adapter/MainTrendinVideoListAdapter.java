package demo.vega.com.ttdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.vega.com.ttdemo.R;

public class MainTrendinVideoListAdapter extends RecyclerView.Adapter<MainTrendinVideoListAdapter.MyViewHolder> {

    Context context;

    public MainTrendinVideoListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MainTrendinVideoListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_main_trending_video_list,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainTrendinVideoListAdapter.MyViewHolder myViewHolder, int i) {

        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
        myViewHolder.rvSpecificTrendingList.setLayoutManager(manager);
        SpecificTrendingListAdapter adapter = new SpecificTrendingListAdapter(context);
        myViewHolder.rvSpecificTrendingList.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtTrendName,txtLikesCount;
        RecyclerView rvSpecificTrendingList;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTrendName = itemView.findViewById(R.id.txtTrendName);
            txtLikesCount = itemView.findViewById(R.id.txtLikesCount);
            rvSpecificTrendingList = itemView.findViewById(R.id.rvSpecificTrendingList);

        }
    }
}
