package com.example.petshop.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Create(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "ShopPet.db"
        private const val DATABASE_VERSION = 1

        // Table names
        const val TABLE_ACCOUNT = "Account"
        const val TABLE_ACCOUNT_DT = "Account_dt"
        const val TABLE_PRODUCT = "Product"
        const val TABLE_PRODUCT_RATE = "Product_Rate"
        const val TABLE_CART = "Cart"
        const val TABLE_NOTIFICATION = "Notification"
        const val TABLE_ORDER = "`Order`" // Escaped using backticks
        const val TABLE_PRODUCT_FAVORITES = "Product_Favorites"
        const val TABLE_CHAT = "Chat"
        const val TABLE_DISCOUNT = "Discount"

        // Common column names
        private const val KEY_ID_USER = "ID_User"
        private const val KEY_ID_PRODUCT = "ID_Product"

        // Account table column names
        private const val KEY_PASS = "Pass"

        // Account_dt table column names
        private const val KEY_DISPLAY_NAME = "DisplayName"
        private const val KEY_TYPE_USER = "Type_User"
        private const val KEY_ADDRESS = "Address"
        private const val KEY_SEX = "Sex"
        private const val KEY_BIRTHDAY = "BirthDay"
        private const val KEY_EMAIL = "Email"
        private const val KEY_AVATAR = "Avatar"

        // Product table column names
        private const val KEY_NAME = "Name"
        private const val KEY_TYPE = "Type"
        private const val KEY_IMG_PATH = "ImgPath"
        private const val KEY_NOTE = "Note"
        private const val KEY_SIZE = "Size"
        private const val KEY_WEIGHT = "Weight"
        private const val KEY_BRAND = "Brand"
        private const val KEY_STAR = "Star"

        // Product_Rate table column names
        private const val KEY_RATE = "Rate"

        // Cart table column names
        private const val KEY_QUANTITY = "Quantity"

        // Notification table column names
        private const val KEY_ID_NOTIFICATION = "ID_Notification"
        private const val KEY_TITLE = "Title"
        private const val KEY_CONTENT = "Content"
        private const val KEY_STATUS = "Status"

        // Order table column names
        private const val KEY_ID_ORDER = "ID_Order"
        private const val KEY_DATE_ORDER = "DateOrder"

        // Discount table column names
        private const val KEY_ID_DISCOUNT = "ID_Discount"
        private const val KEY_TYPE_DISCOUNT = "TypeDiscount"
        private const val KEY_PERCENT = "Percent"
        private const val KEY_START_DATE = "StartDate"
        private const val KEY_END_DATE = "EndDate"

        // Create table statements
        private const val CREATE_TABLE_ACCOUNT = "CREATE TABLE $TABLE_ACCOUNT (" +
                "$KEY_ID_USER INTEGER PRIMARY KEY, " +
                "$KEY_PASS TEXT)"

        private const val CREATE_TABLE_ACCOUNT_DT = "CREATE TABLE $TABLE_ACCOUNT_DT (" +
                "$KEY_ID_USER INTEGER, " +
                "$KEY_DISPLAY_NAME TEXT, " +
                "$KEY_TYPE_USER TEXT, " +
                "$KEY_ADDRESS TEXT, " +
                "$KEY_SEX TEXT, " +
                "$KEY_BIRTHDAY TEXT, " +
                "$KEY_EMAIL TEXT, " +
                "$KEY_AVATAR TEXT, " +
                "FOREIGN KEY ($KEY_ID_USER) REFERENCES $TABLE_ACCOUNT($KEY_ID_USER))"

        private const val CREATE_TABLE_PRODUCT = "CREATE TABLE $TABLE_PRODUCT (" +
                "$KEY_ID_PRODUCT INTEGER PRIMARY KEY, " +
                "$KEY_NAME TEXT, " +
                "$KEY_TYPE TEXT, " +
                "$KEY_IMG_PATH TEXT, " +
                "$KEY_NOTE TEXT, " +
                "$KEY_SIZE TEXT, " +
                "$KEY_WEIGHT TEXT, " +
                "$KEY_BRAND TEXT, " +
                "$KEY_STAR TEXT)"

        private const val CREATE_TABLE_PRODUCT_RATE = "CREATE TABLE $TABLE_PRODUCT_RATE (" +
                "$KEY_ID_PRODUCT INTEGER, " +
                "$KEY_RATE TEXT, " +
                "FOREIGN KEY ($KEY_ID_PRODUCT) REFERENCES $TABLE_PRODUCT($KEY_ID_PRODUCT))"

        private const val CREATE_TABLE_CART = "CREATE TABLE $TABLE_CART (" +
                "$KEY_ID_USER INTEGER, " +
                "$KEY_ID_PRODUCT INTEGER, " +
                "$KEY_QUANTITY INTEGER, " +
                "FOREIGN KEY ($KEY_ID_USER) REFERENCES $TABLE_ACCOUNT($KEY_ID_USER), " +
                "FOREIGN KEY ($KEY_ID_PRODUCT) REFERENCES $TABLE_PRODUCT($KEY_ID_PRODUCT))"

        private const val CREATE_TABLE_NOTIFICATION = "CREATE TABLE $TABLE_NOTIFICATION (" +
                "$KEY_ID_NOTIFICATION INTEGER PRIMARY KEY, " +
                "$KEY_ID_USER INTEGER, " +
                "$KEY_TITLE TEXT, " +
                "$KEY_CONTENT TEXT, " +
                "$KEY_STATUS TEXT)"

        private const val CREATE_TABLE_ORDER = "CREATE TABLE $TABLE_ORDER (" +
                "$KEY_ID_ORDER INTEGER PRIMARY KEY, " +
                "$KEY_ID_USER INTEGER, " +
                "$KEY_ID_PRODUCT INTEGER, " +
                "$KEY_QUANTITY INTEGER, " +
                "$KEY_STATUS TEXT, " +
                "$KEY_DATE_ORDER TEXT, " +
                "FOREIGN KEY ($KEY_ID_USER) REFERENCES $TABLE_ACCOUNT($KEY_ID_USER), " +
                "FOREIGN KEY ($KEY_ID_PRODUCT) REFERENCES $TABLE_PRODUCT($KEY_ID_PRODUCT))"

        private const val CREATE_TABLE_PRODUCT_FAVORITES = "CREATE TABLE $TABLE_PRODUCT_FAVORITES (" +
                "$KEY_ID_USER INTEGER, " +
                "$KEY_ID_PRODUCT INTEGER, " +
                "FOREIGN KEY ($KEY_ID_USER) REFERENCES $TABLE_ACCOUNT($KEY_ID_USER), " +
                "FOREIGN KEY ($KEY_ID_PRODUCT) REFERENCES $TABLE_PRODUCT($KEY_ID_PRODUCT))"

        private const val CREATE_TABLE_CHAT = "CREATE TABLE $TABLE_CHAT (" +
                "chat_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "sender_id INTEGER, " +
                "receiver_id INTEGER, " +
                "message TEXT, " +
                "sent_time DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                "FOREIGN KEY(sender_id) REFERENCES $TABLE_ACCOUNT($KEY_ID_USER), " +
                "FOREIGN KEY(receiver_id) REFERENCES $TABLE_ACCOUNT($KEY_ID_USER))"

        private const val CREATE_TABLE_DISCOUNT = "CREATE TABLE $TABLE_DISCOUNT (" +
                "$KEY_ID_DISCOUNT INTEGER PRIMARY KEY, " +
                "$KEY_TYPE_DISCOUNT TEXT, " +
                "$KEY_PERCENT REAL, " +
                "$KEY_ID_PRODUCT INTEGER, " +
                "$KEY_START_DATE TEXT, " +
                "$KEY_END_DATE TEXT, " +
                "FOREIGN KEY ($KEY_ID_PRODUCT) REFERENCES $TABLE_PRODUCT($KEY_ID_PRODUCT))"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_ACCOUNT)
        db.execSQL(CREATE_TABLE_ACCOUNT_DT)
        db.execSQL(CREATE_TABLE_PRODUCT)
        db.execSQL(CREATE_TABLE_PRODUCT_RATE)
        db.execSQL(CREATE_TABLE_CART)
        db.execSQL(CREATE_TABLE_NOTIFICATION)
        db.execSQL(CREATE_TABLE_ORDER)
        db.execSQL(CREATE_TABLE_PRODUCT_FAVORITES)
        db.execSQL(CREATE_TABLE_CHAT)
        db.execSQL(CREATE_TABLE_DISCOUNT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ACCOUNT")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ACCOUNT_DT")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCT")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCT_RATE")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CART")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NOTIFICATION")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ORDER")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCT_FAVORITES")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CHAT")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_DISCOUNT")
        onCreate(db)
    }
}
