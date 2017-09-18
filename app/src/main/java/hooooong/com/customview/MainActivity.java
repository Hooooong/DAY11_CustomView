package hooooong.com.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button customWidgetActivity;
    Button customViewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    public void initView(){
        customWidgetActivity = (Button)findViewById(R.id.customWidgetActivity);
        customViewActivity = (Button)findViewById(R.id.customViewActivity);
    }

    public void initListener(){
        customWidgetActivity.setOnClickListener(this);
        customViewActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button){
            Intent goActivity;
            switch (v.getId()){
                case R.id.customWidgetActivity:
                    goActivity = new Intent(getBaseContext(), CustomWidgetActivity.class);
                    startActivity(goActivity);
                    break;
                case R.id.customViewActivity:
                    goActivity = new Intent(getBaseContext(), CustomViewActivity.class);
                    startActivity(goActivity);
                    break;
            }
        }

    }
}
