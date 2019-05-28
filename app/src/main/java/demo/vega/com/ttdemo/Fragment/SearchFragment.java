package demo.vega.com.ttdemo.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import demo.vega.com.ttdemo.Activity.SearchActivity;
import demo.vega.com.ttdemo.Adapter.MainTrendinVideoListAdapter;
import demo.vega.com.ttdemo.R;

public class SearchFragment extends Fragment implements View.OnClickListener {

    RecyclerView rvTrendingVideoList;
    MainTrendinVideoListAdapter adapter;
    CarouselView carouselView;

    boolean flag = false;

    @BindView(R.id.imgBackButton)
    ImageView imgBackButton;
    @BindView(R.id.imgScanner)
    ImageView imgScanner;
    @BindView(R.id.edtSearch)
    EditText edtSearch;

    int[] sampleImages = {R.drawable.image_one, R.drawable.image_three, R.drawable.image_two, R.drawable.image_four, R.drawable.image_five, R.drawable.image_one, R.drawable.image_three, R.drawable.image_two, R.drawable.image_four, R.drawable.image_five};
    @BindView(R.id.llSearch)
    LinearLayout llSearch;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        rvTrendingVideoList = view.findViewById(R.id.rvMainTrendingVideoList);
        carouselView = view.findViewById(R.id.carouselView);

        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(sampleImages.length);

        edtSearch.addTextChangedListener(watcher);
        this.imgBackButton.setOnClickListener(this);
        this.imgScanner.setOnClickListener(this);
        imgBackButton.setVisibility(View.GONE);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvTrendingVideoList.setLayoutManager(manager);
        adapter = new MainTrendinVideoListAdapter(getActivity());
        rvTrendingVideoList.setAdapter(adapter);

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            imgBackButton.setVisibility(View.VISIBLE);

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (edtSearch.getText().toString().equals("")){
                imgScanner.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.scanner));
                imgBackButton.setVisibility(View.GONE);
                flag = false;
            }else {
                imgScanner.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.search));
                imgBackButton.setVisibility(View.VISIBLE);
                flag = true;

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBackButton:
                hideKeyboard();
                break;
            case R.id.imgScanner:
                if (flag){
                    flag = false;
                    Intent intent = new Intent(getActivity(),SearchActivity.class);
                    intent.putExtra("SearchText",edtSearch.getText().toString());
                    startActivity(intent);
                    edtSearch.setText("");
                }else {

                }
                break;
        }
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
