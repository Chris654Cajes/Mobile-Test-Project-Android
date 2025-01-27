package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobiletestproject.R;

import java.util.ArrayList;

import Models.LogItem;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<LogItem> logs;

    // Use this constructor to create an instance of ProductHistoryAdapter
    public LogAdapter(Context context, ArrayList<LogItem> logs) {
        this.context = context;
        this.logs = logs;
    }

    // Create a row of TextViews
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.logs_row, parent, false);
        return new MyViewHolder(view);
    }

    // Put every product history to every row
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        int index = position;

        holder.txt_button_number.setText("Button " + logs.get(index).getButtonNumber() + " pressed");
        holder.txt_event_timestamp.setText(logs.get(index).getEventTimeStamp().toString());
    }

    // Get the number of rows in the product histories array
    @Override
    public int getItemCount() {
        return logs.size();
    }

    // Blueprints of the row structure
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_button_number, txt_event_timestamp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_button_number = itemView.findViewById(R.id.txt_button_number);
            txt_event_timestamp = itemView.findViewById(R.id.txt_event_timestamp);
        }
    }
}

