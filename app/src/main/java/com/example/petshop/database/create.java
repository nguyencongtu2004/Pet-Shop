package com.example.petshop.database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
public class create extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ShopPet.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    public static final String TABLE_ACCOUNT = "Account";
    public static final String TABLE_ACCOUNT_DT = "Account_dt";
    public static final String TABLE_PRODUCT = "Product";
    public static final String TABLE_PRODUCT_RATE = "Product_Rate";
    public static final String TABLE_CART = "Cart";
    public static final String TABLE_NOTIFICATION = "Notification";
    public static final String TABLE_ORDER = "`Order`"; // Escaped using backticks
    public static final String TABLE_PRODUCT_FAVORITES = "Product_Favorites";
    public static final String TABLE_CHAT = "Chat";
    public static final String TABLE_DISCOUNT = "Discount";

    // Common column names
    private static final String KEY_ID_USER = "ID_User";
    private static final String KEY_ID_PRODUCT = "ID_Product";

    // Account table column names
    private static final String KEY_PASS = "Pass";

    // Account_dt table column names
    private static final String KEY_DISPLAY_NAME = "DisplayName";
    private static final String KEY_TYPE_USER = "Type_User";
    private static final String KEY_ADDRESS = "Address";
    private static final String KEY_SEX = "Sex";
    private static final String KEY_BIRTHDAY = "BirthDay";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_AVATAR = "Avatar";

    // Product table column names
    private static final String KEY_NAME = "Name";
    private static final String KEY_TYPE = "Type";
    private static final String KEY_IMG_PATH = "ImgPath";
    private static final String KEY_NOTE = "Note";
    private static final String KEY_SIZE = "Size";
    private static final String KEY_WEIGHT = "Weight";
    private static final String KEY_BRAND = "Brand";
    private static final String KEY_STAR = "Star";

    // Product_Rate table column names
    private static final String KEY_RATE = "Rate";

    // Cart table column names
    private static final String KEY_QUANTITY = "Quantity";

    // Notification table column names
    private static final String KEY_ID_NOTIFICATION = "ID_Notification";
    private static final String KEY_TITLE = "Title";
    private static final String KEY_CONTENT = "Content";
    private static final String KEY_STATUS = "Status";

    // Order table column names
    private static final String KEY_ID_ORDER = "ID_Order";
    private static final String KEY_DATE_ORDER = "DateOrder";

    // Discount table column names
    private static final String KEY_ID_DISCOUNT = "ID_Discount";
    private static final String KEY_TYPE_DISCOUNT = "TypeDiscount";
    private static final String KEY_PERCENT = "Percent";
    private static final String KEY_START_DATE = "StartDate";
    private static final String KEY_END_DATE = "EndDate";

    // Create table statements
    private static final String CREATE_TABLE_ACCOUNT = "CREATE TABLE " + TABLE_ACCOUNT + " ("
            + KEY_ID_USER + " INTEGER PRIMARY KEY, "
            + KEY_PASS + " TEXT)";

    private static final String CREATE_TABLE_ACCOUNT_DT = "CREATE TABLE " + TABLE_ACCOUNT_DT + " ("
            + KEY_ID_USER + " INTEGER, "
            + KEY_DISPLAY_NAME + " TEXT, "
            + KEY_TYPE_USER + " TEXT, "
            + KEY_ADDRESS + " TEXT, "
            + KEY_SEX + " TEXT, "
            + KEY_BIRTHDAY + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_AVATAR + " TEXT, "
            + "FOREIGN KEY (" + KEY_ID_USER + ") REFERENCES " + TABLE_ACCOUNT + "(" + KEY_ID_USER + "))";

    private static final String CREATE_TABLE_PRODUCT = "CREATE TABLE " + TABLE_PRODUCT + " ("
            + KEY_ID_PRODUCT + " INTEGER PRIMARY KEY, "
            + KEY_NAME + " TEXT, "
            + KEY_TYPE + " TEXT, "
            + KEY_IMG_PATH + " TEXT, "
            + KEY_NOTE + " TEXT, "
            + KEY_SIZE + " TEXT, "
            + KEY_WEIGHT + " TEXT, "
            + KEY_BRAND + " TEXT, "
            + KEY_STAR + " TEXT)";

    private static final String CREATE_TABLE_PRODUCT_RATE = "CREATE TABLE " + TABLE_PRODUCT_RATE + " ("
            + KEY_ID_PRODUCT + " INTEGER, "
            + KEY_RATE + " TEXT, "
            + "FOREIGN KEY (" + KEY_ID_PRODUCT + ") REFERENCES " + TABLE_PRODUCT + "(" + KEY_ID_PRODUCT + "))";

    private static final String CREATE_TABLE_CART = "CREATE TABLE " + TABLE_CART + " ("
            + KEY_ID_USER + " INTEGER, "
            + KEY_ID_PRODUCT + " INTEGER, "
            + KEY_QUANTITY + " INTEGER, "
            + "FOREIGN KEY (" + KEY_ID_USER + ") REFERENCES " + TABLE_ACCOUNT + "(" + KEY_ID_USER + "), "
            + "FOREIGN KEY (" + KEY_ID_PRODUCT + ") REFERENCES " + TABLE_PRODUCT + "(" + KEY_ID_PRODUCT + "))";

    private static final String CREATE_TABLE_NOTIFICATION = "CREATE TABLE " + TABLE_NOTIFICATION + " ("
            + KEY_ID_NOTIFICATION + " INTEGER PRIMARY KEY, "
            + KEY_ID_USER + " INTEGER, "
            + KEY_TITLE + " TEXT, "
            + KEY_CONTENT + " TEXT, "
            + KEY_STATUS + " TEXT)";

    private static final String CREATE_TABLE_ORDER = "CREATE TABLE " + TABLE_ORDER + " ("
            + KEY_ID_ORDER + " INTEGER PRIMARY KEY, "
            + KEY_ID_USER + " INTEGER, "
            + KEY_ID_PRODUCT + " INTEGER, "
            + KEY_QUANTITY + " INTEGER, "
            + KEY_STATUS + " TEXT, "
            + KEY_DATE_ORDER + " TEXT, "
            + "FOREIGN KEY (" + KEY_ID_USER + ") REFERENCES " + TABLE_ACCOUNT + "(" + KEY_ID_USER + "), "
            + "FOREIGN KEY (" + KEY_ID_PRODUCT + ") REFERENCES " + TABLE_PRODUCT + "(" + KEY_ID_PRODUCT + "))";

    private static final String CREATE_TABLE_PRODUCT_FAVORITES = "CREATE TABLE " + TABLE_PRODUCT_FAVORITES + " ("
            + KEY_ID_USER + " INTEGER, "
            + KEY_ID_PRODUCT + " INTEGER, "
            + "FOREIGN KEY (" + KEY_ID_USER + ") REFERENCES " + TABLE_ACCOUNT + "(" + KEY_ID_USER + "), "
            + "FOREIGN KEY (" + KEY_ID_PRODUCT + ") REFERENCES " + TABLE_PRODUCT + "(" + KEY_ID_PRODUCT + "))";

    private static final String CREATE_TABLE_CHAT = "CREATE TABLE " + TABLE_CHAT + " ("
            + "chat_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "sender_id INTEGER, "
            + "receiver_id INTEGER, "
            + "message TEXT, "
            + "sent_time DATETIME DEFAULT CURRENT_TIMESTAMP, "
            + "FOREIGN KEY(sender_id) REFERENCES " + TABLE_ACCOUNT + "(" + KEY_ID_USER + "), "
            + "FOREIGN KEY(receiver_id) REFERENCES " + TABLE_ACCOUNT + "(" + KEY_ID_USER + "))";

    private static final String CREATE_TABLE_DISCOUNT = "CREATE TABLE " + TABLE_DISCOUNT + " ("
            + KEY_ID_DISCOUNT + " INTEGER PRIMARY KEY, "
            + KEY_TYPE_DISCOUNT + " TEXT, "
            + KEY_PERCENT + " REAL, "
            + KEY_ID_PRODUCT + " INTEGER, "
            + KEY_START_DATE + " TEXT, "
            + KEY_END_DATE + " TEXT, "
            + "FOREIGN KEY (" + KEY_ID_PRODUCT + ") REFERENCES " + TABLE_PRODUCT + "(" + KEY_ID_PRODUCT + "))";

    public create(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ACCOUNT);
        db.execSQL(CREATE_TABLE_ACCOUNT_DT);
        db.execSQL(CREATE_TABLE_PRODUCT);
        db.execSQL(CREATE_TABLE_PRODUCT_RATE);
        db.execSQL(CREATE_TABLE_CART);
        db.execSQL(CREATE_TABLE_NOTIFICATION);
        db.execSQL(CREATE_TABLE_ORDER);
        db.execSQL(CREATE_TABLE_PRODUCT_FAVORITES);
        db.execSQL(CREATE_TABLE_CHAT);
        db.execSQL(CREATE_TABLE_DISCOUNT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNT_DT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT_RATE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT_FAVORITES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISCOUNT);
        onCreate(db);
    }
}