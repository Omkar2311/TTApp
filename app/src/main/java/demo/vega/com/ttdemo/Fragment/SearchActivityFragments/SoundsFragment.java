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
import demo.vega.com.ttdemo.Adapter.SoundsFragmentAdapter;
import demo.vega.com.ttdemo.Model.SoundSearchResult;
import demo.vega.com.ttdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SoundsFragment extends Fragment {

    @BindView(R.id.rvSoundsFragment)
    RecyclerView rvSoundsFragment;
    List<SoundSearchResult> list = new ArrayList<>();
    SoundsFragmentAdapter adapter;

    public SoundsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sounds, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        creatList();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvSoundsFragment.setLayoutManager(manager);
        adapter = new SoundsFragmentAdapter(getActivity(),list);
        rvSoundsFragment.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void creatList() {
        list.add(new SoundSearchResult("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","John Wright","Jsysus","55"));
        list.add(new SoundSearchResult("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","Wilbur Wright","Jsysus","52"));
        list.add(new SoundSearchResult("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","Jon Snow","Snow","5"));
        list.add(new SoundSearchResult("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","Khal Drogo","DJ Snake","85"));
        list.add(new SoundSearchResult("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","Black Panther","Baba Maal","75"));
        list.add(new SoundSearchResult("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","Thor","Brian Tyler","99"));
        list.add(new SoundSearchResult("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","Batman","Hans Zimmer","909"));
    }
}
