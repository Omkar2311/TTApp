package demo.vega.com.ttdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import demo.vega.com.ttdemo.Model.HashtagSearchResults;
import demo.vega.com.ttdemo.R;

public class HashtagFragmentAdapter extends RecyclerView.Adapter<HashtagFragmentAdapter.ViewHolder> {

    Context context;
    List<HashtagSearchResults> list = new ArrayList<>();

    public HashtagFragmentAdapter(Context context, List<HashtagSearchResults> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_hashtag_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HashtagSearchResults results = list.get(position);
        if (!results.getHashTagName().equals("")){
            holder.txtHashtagName.setText(results.getHashTagName());
        }
        if (!results.getNoOfViews().equals("")){
            holder.txtNoOfViews.setText(results.getNoOfViews()+" views");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtHashtagName)
        TextView txtHashtagName;
        @BindView(R.id.txtNoOfViews)
        TextView txtNoOfViews;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
