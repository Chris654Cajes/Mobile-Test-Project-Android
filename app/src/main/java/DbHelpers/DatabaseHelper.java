package DbHelpers;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import Models.LogItem;

/*
    This class implements database structure and the methods to get or add new data to/from the database
*/

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;

    private static final String DATABASE_NAME = "MobileTest.db";
    private static final int DATABASE_VERSION = 1;

    // Database structure for the Log table
    private static final String TABLE_NAME_LOGS = "Log";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_BUTTON_NUMBER = "buttonNumber";
    private static final String COLUMN_EVENT_TIMESTAMP = "eventTimestamp";

    // Constructor for the database structure
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // When the app is opened for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create able User
        String queryCreateTableUser = "CREATE TABLE " + TABLE_NAME_LOGS +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BUTTON_NUMBER + " INTEGER, " +
                COLUMN_EVENT_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP)";
        db.execSQL(queryCreateTableUser);
    }

    // When there are new updates in the app
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LOGS);
        onCreate(db);
    }

    // This method is called to get logs form the phone database
    public ArrayList<LogItem> getLogs() {
        ArrayList<LogItem> logItems = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME_LOGS;
        SQLiteDatabase db = this.getReadableDatabase();

        // Execute SQL query
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                LogItem logItem = new LogItem();

                logItem.setId(cursor.getInt(0));
                logItem.setButtonNumber(cursor.getInt(1));
                logItem.setEventTimeStamp(cursor.getString(2));

                logItems.add(logItem);
            }
        }

        cursor.close();

        return logItems;
    }

    // This method is called to add new log when clicking the button
    public String addLog(int buttonNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_BUTTON_NUMBER, buttonNumber);

        // Execute SQL query
        long added = db.insert(TABLE_NAME_LOGS, null, values);

        if (added == -1) {
            return "Unable to add new log...";
        } else {
            return "New log is added successfully";
        }
    }
}
