package hooooong.com.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomFABActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_fab);

        initView();
    }

    private void initView(){
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter customAdapter = new CustomAdapter();
        recyclerView.setAdapter(customAdapter);

        customAdapter.addData(setData());
    }

    private List<String> setData(){
        List<String> data = new ArrayList<>();
        for(int i = 0 ; i<100; i++){
            data.add("데이터 : "+i);
        }
        return data;
    }

}
