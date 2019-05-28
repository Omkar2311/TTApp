package demo.vega.com.ttdemo.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import demo.vega.com.ttdemo.R;

public class PrivacyAndSettingsActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.imgBackButton)
    ImageView imgBackButton;
    @BindView(R.id.txtToolbarName)
    TextView txtToolbarName;
    @BindView(R.id.viewLine)
    View viewLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_and_settings);
        ButterKnife.bind(this);

        txtToolbarName.setText(getString(R.string.privacy_and_settings));
        imgBackButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBackButton:
                finish();
                break;
        }
    }
}
