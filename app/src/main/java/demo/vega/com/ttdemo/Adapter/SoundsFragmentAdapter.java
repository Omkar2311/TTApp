package demo.vega.com.ttdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.vega.com.ttdemo.Model.SoundSearchResult;
import demo.vega.com.ttdemo.R;

public class SoundsFragmentAdapter extends RecyclerView.Adapter<SoundsFragmentAdapter.ViewHolder> {

    Context context;
    List<SoundSearchResult> list = new ArrayList<>();

    public SoundsFragmentAdapter(Context context, List<SoundSearchResult> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_sounds_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SoundSearchResult result = list.get(position);
        if (!result.getImgUrl().equals("")) {
            Picasso.with(context).load(result.getImgUrl()).into(holder.imgUserProfileSoundsFragment);
        }
        if (!result.getUserName().equals("")) {
            holder.txtUserNameSoundsFragment.setText(result.getUserName());
        }
        if (!result.getDescription().equals("")) {
            holder.txtDescriptionSoundsFragment.setText(result.getDescription());
        }
        if (!result.getNoOfSounds().equals("")) {
            holder.txtNoOfSoundsCount.setText(result.getNoOfSounds());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgUserProfileSoundsFragment)
        ImageView imgUserProfileSoundsFragment;
        @BindView(R.id.txtUserNameSoundsFragment)
        TextView txtUserNameSoundsFragment;
        @BindView(R.id.txtDescriptionSoundsFragment)
        TextView txtDescriptionSoundsFragment;
        @BindView(R.id.txtNoOfSoundsCount)
        TextView txtNoOfSoundsCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
