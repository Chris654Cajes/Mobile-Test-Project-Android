package Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobiletestproject.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

import Models.LogItem;

/*
    This adapter lists all the logs and put the to logs row
*/

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<LogItem> logs;

    // Use this constructor to create an instance of LogsAdapter
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

    // Put every log to every row
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        int index = position;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            // Formatting time by MM/dd/yyyy HH:mm a
            LocalDateTime dateTime = LocalDateTime.parse(logs.get(index).getEventTimeStamp(), formatter);

            int month = dateTime.getMonthValue();
            int day = dateTime.getDayOfMonth();
            int year = dateTime.getYear();

            int hour = dateTime.getHour();
            int minute = dateTime.getMinute();

            String dayAbbreviation = "AM";

            if (hour > 11) {
                hour = hour - 12;
                dayAbbreviation = "PM";
            } else {
                dayAbbreviation = "AM";
            }

            String formattedDateTime = month + "/" + day + "/" + year + " " + hour + ":" + String.format("%02d", minute) + " " + dayAbbreviation;

            holder.txt_button_number.setText("Button " + logs.get(index).getButtonNumber() + " pressed");
            holder.txt_event_timestamp.setText(formattedDateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get the number of rows in the logs array
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

