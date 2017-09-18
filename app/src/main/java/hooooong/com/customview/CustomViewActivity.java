package hooooong.com.customview;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;

public class CustomViewActivity extends AppCompatActivity {

    ConstraintLayout stage;
    CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        stage = (ConstraintLayout) findViewById(R.id.stage);
        customView = (CustomView)findViewById(R.id.customView);

        CustomView cv = new CustomView(this);
        cv.setX(500);
        cv.setY(500);
        stage.addView(cv);

    }
}
