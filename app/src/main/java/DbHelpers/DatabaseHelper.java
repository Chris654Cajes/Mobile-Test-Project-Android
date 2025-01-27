package DbHelpers;

/*
    This class implements database structure and the methods to get or update data to/from the database
*/

import android.content.Context;

public class DatabaseHelper {
    private Context context;

    private static final String DATABASE_NAME = "MobileTest.db";
    private static final int DATABASE_VERSION = 1;

    private static final String COLUMN_ID = "id";

    // Database structure for the Log table
    private static final String TABLE_NAME_LOGS = "Log";
    private static final String COLUMN_PRODUCT_ID = "productId";
    private static final String COLUMN_PRODUCT = "product";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_TOTAL_AMOUNT = "totalAmount";
}
