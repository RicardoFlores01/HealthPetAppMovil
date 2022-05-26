package example.com.healthpetapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "AppPet.db";
    public static final String TABLE_CITES = "cites";
    public static final String TABLE_CONTACTS = "contacts";
    public static final String TABLE_PETS = "pets";


    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CITES + "(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "service TEXT NOT NULL," +
                "description TEXT," +
                "remind TEXT," +
                "fecha TEXT NOT NULL," +
                "hora TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACTS +"(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name_contact TEXT," +
                "phone INTEGER," +
                "adress TEXT," +
                "email TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PETS + "(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name_pet TEXT," +
                "race_pet TEXT," +
                "age INTEGER," +
                "weight INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CITES);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CONTACTS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PETS);

        onCreate(sqLiteDatabase);

    }
}
