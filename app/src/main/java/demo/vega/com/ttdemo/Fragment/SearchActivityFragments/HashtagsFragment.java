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
import demo.vega.com.ttdemo.Adapter.HashtagFragmentAdapter;
import demo.vega.com.ttdemo.Model.HashtagSearchResults;
import demo.vega.com.ttdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HashtagsFragment extends Fragment {

    @BindView(R.id.rvHashtagFragments)
    RecyclerView rvHashtagFragments;
    HashtagFragmentAdapter adapter;
    List<HashtagSearchResults> list = new ArrayList<>();

    public HashtagsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hashtags, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        createList();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvHashtagFragments.setLayoutManager(manager);
        adapter = new HashtagFragmentAdapter(getActivity(),list);
        rvHashtagFragments.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void createList() {
        list.add(new HashtagSearchResults("thanksforthefullsupport","63"));
        list.add(new HashtagSearchResults("thanksfor","65"));
        list.add(new HashtagSearchResults("thanksforwatch","6"));
        list.add(new HashtagSearchResults("thanksforlikes","80"));
        list.add(new HashtagSearchResults("thanksforwatching","78"));
        list.add(new HashtagSearchResults("thanksforlistening","5"));
        list.add(new HashtagSearchResults("thanksforlooking","75"));
        list.add(new HashtagSearchResults("thanksforlove","99"));
    }
}
