package demo.vega.com.ttdemo.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import demo.vega.com.ttdemo.Activity.PrivacyAndSettingsActivity;
import demo.vega.com.ttdemo.R;

public class ProfileFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.imgProfile)
    ImageView imgProfile;
    @BindView(R.id.txtUserName)
    TextView txtUserName;
    @BindView(R.id.imgCode)
    ImageView imgCode;
    @BindView(R.id.imgMenu)
    ImageView imgMenu;
    @BindView(R.id.imgProfilePicture)
    CircleImageView imgProfilePicture;
    @BindView(R.id.txtProfileUserName)
    TextView txtProfileUserName;
    @BindView(R.id.txtNoOfVideos)
    TextView txtNoOfVideos;
    @BindView(R.id.noOfFollowers)
    TextView noOfFollowers;
    @BindView(R.id.txtFollowers)
    TextView txtFollowers;
    @BindView(R.id.followings)
    TextView followings;
    @BindView(R.id.heart)
    TextView heart;
    @BindView(R.id.txtHearts)
    TextView txtHearts;
    @BindView(R.id.btnEditProfile)
    Button btnEditProfile;
    @BindView(R.id.imgMyVideos)
    ImageView imgMyVideos;
    @BindView(R.id.imgFavouriteVideos)
    ImageView imgFavouriteVideos;
    @BindView(R.id.vpContainerMyVideosAndFavourite)
    LinearLayout vpContainerMyVideosAndFavourite;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        this.imgMyVideos.setOnClickListener(this);
        this.imgFavouriteVideos.setOnClickListener(this);
        this.imgMenu.setOnClickListener(this);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.vpContainerMyVideosAndFavourite,new MyVideosFragment()).addToBackStack(null).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgMyVideos:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.vpContainerMyVideosAndFavourite,new MyVideosFragment()).addToBackStack(null).commit();
                break;
            case R.id.imgFavouriteVideos:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.vpContainerMyVideosAndFavourite,new FavouriteVideosFragment()).addToBackStack(null).commit();
                break;
            case R.id.imgMenu:
                Intent intent = new Intent(getActivity(),PrivacyAndSettingsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
