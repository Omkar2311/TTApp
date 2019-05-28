package demo.vega.com.ttdemo.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import demo.vega.com.ttdemo.Adapter.SearchActivtyTabsPagerAdapter;
import demo.vega.com.ttdemo.R;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.imgBackButton)
    ImageView imgBackButton;
    @BindView(R.id.imgScanner)
    ImageView imgScanner;
    @BindView(R.id.edtSearch)
    EditText edtSearch;
    @BindView(R.id.llSearch)
    LinearLayout llSearch;
    @BindView(R.id.tlSearchActivity)
    TabLayout tlSearchActivity;
    @BindView(R.id.vpSearchActivity)
    ViewPager vpSearchActivity;

    String searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        if (!getIntent().getStringExtra("SearchText").equals("")){
            searchText = getIntent().getStringExtra("SearchText");
            edtSearch.setText(searchText);
            imgBackButton.setVisibility(View.VISIBLE);
        }

        setTabs();

        edtSearch.addTextChangedListener(watcher);
        imgBackButton.setOnClickListener(this);
        imgScanner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.search));
    }

    public void setTabs(){
        tlSearchActivity.addTab(tlSearchActivity.newTab().setText("USERS"));
        tlSearchActivity.addTab(tlSearchActivity.newTab().setText("SOUNDS"));
        tlSearchActivity.addTab(tlSearchActivity.newTab().setText("HASHTAGS"));

        tlSearchActivity.setTabGravity(TabLayout.GRAVITY_FILL);

        SearchActivtyTabsPagerAdapter tabsAdapter = new SearchActivtyTabsPagerAdapter(getSupportFragmentManager(), tlSearchActivity.getTabCount());
        vpSearchActivity.setAdapter(tabsAdapter);
        vpSearchActivity.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlSearchActivity));

        tlSearchActivity.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpSearchActivity.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(edtSearch.getText().toString().equals("")){
                imgBackButton.setVisibility(View.GONE);
            }else {
                imgBackButton.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBackButton:
                finish();
                break;
        }
    }
}
