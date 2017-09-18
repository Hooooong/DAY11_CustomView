package hooooong.com.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomWidgetActivity extends AppCompatActivity {

    Button aniButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_widget);

        aniButton = (AniButton)findViewById(R.id.aniButton);

        aniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "클릭", Toast.LENGTH_LONG).show();
            }
        });
    }
}
