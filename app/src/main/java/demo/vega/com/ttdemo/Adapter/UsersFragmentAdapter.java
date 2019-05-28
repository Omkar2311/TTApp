package demo.vega.com.ttdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import demo.vega.com.ttdemo.Model.UsersSearchResult;
import demo.vega.com.ttdemo.R;

public class UsersFragmentAdapter extends RecyclerView.Adapter<UsersFragmentAdapter.ViewHolder> {

    Context context;
    List<UsersSearchResult> list = new ArrayList<>();

    public UsersFragmentAdapter(Context context, List<UsersSearchResult> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_user_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UsersSearchResult result = list.get(position);
        if(!result.getUserName().equals("")){
           holder.txtAccountNameUserFragment.setText(result.getUserName());
        }
        if (!result.getDescription().equals("")){
            holder.txtDescriptionUserFragment.setText(result.getDescription());
        }
        if (!result.getImgUrl().equals("")){
            Picasso.with(context).load(result.getImgUrl()).into(holder.cImgProfilePhotoUserFragment);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cImgProfilePhotoUserFragment)
        CircleImageView cImgProfilePhotoUserFragment;
        @BindView(R.id.btnFollowUserFragment)
        Button btnFollowUserFragment;
        @BindView(R.id.txtAccountNameUserFragment)
        TextView txtAccountNameUserFragment;
        @BindView(R.id.txtDescriptionUserFragment)
        TextView txtDescriptionUserFragment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
