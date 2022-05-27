package example.com.healthpetapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION= 1;
    private static final String DATABASE_NAME = "HealtPet.db";
    public static final String TABLE_CITES = "t_cites";
    public static final String TABLE_CONTACTS = "t_contacts";
    public static final String TABLE_PETS = "t_pets";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CITES + "(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "service TEXT," +
                "description TEXT," +
                "remind TEXT," +
                "fecha TEXT, " +
                "Hora TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACTS + "(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nameContact TEXT," +
                "phone INTEGER," +
                "address INTEGER," +
                "email TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PETS + "(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "namePet TEXT," +
                "race TEXT," +
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

    public void agregarCitas(String name, String service, String description, String remind, String fecha, String hora){
        SQLiteDatabase db= getWritableDatabase();
        if (db!= null){
            db.execSQL("INSERT INTO TABLE_CITES VALUES('"+name+"','"+service+"','"+description+"','"+remind+"','"+fecha+"','"+hora+"')");
            db.close();
        }

    }


}
