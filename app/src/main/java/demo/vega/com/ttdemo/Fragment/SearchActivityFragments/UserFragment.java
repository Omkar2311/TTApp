package demo.vega.com.ttdemo.Fragment.SearchActivityFragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import demo.vega.com.ttdemo.Adapter.UsersFragmentAdapter;
import demo.vega.com.ttdemo.Model.UsersSearchResult;
import demo.vega.com.ttdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {


    @BindView(R.id.rvUsersFragment)
    RecyclerView rvUsersFragment;
    UsersFragmentAdapter adapter;
    List<UsersSearchResult> list = new ArrayList<>();

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        createListOfUsers();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvUsersFragment.setLayoutManager(manager);
        adapter = new UsersFragmentAdapter(getActivity(),list);
        rvUsersFragment.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void createListOfUsers(){
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","John Wright","@johnWright55 fans call me JW"));
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/baboon.png","Wilbur Wright","@wilburWright fans call me WW"));
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/boat.png","Rose Dawson","@roseDove fans call me RD"));
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/boat.png","Rose Dawson","@roseDove fans call me RD"));
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/girl.png","Shuri","@shuri fans call me SH"));
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","John Wright","@johnWright55 fans call me JW"));
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/baboon.png","Wilbur Wright","@wilburWright fans call me WW"));
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/boat.png","Rose Dawson","@roseDove fans call me RD"));
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/boat.png","Rose Dawson","@roseDove fans call me RD"));
        list.add(new UsersSearchResult("https://homepages.cae.wisc.edu/~ece533/images/girl.png","Shuri","@shuri fans call me SH"));
    }

}
