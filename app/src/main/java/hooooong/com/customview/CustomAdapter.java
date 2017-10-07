package hooooong.com.customview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Android Hong on 2017-10-07.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {

    List<String> data;

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String text = data.get(position);
        holder.setTextView(text);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
        }

        public void setTextView(String data){
            textView.setText(data);
        }
    }
}
