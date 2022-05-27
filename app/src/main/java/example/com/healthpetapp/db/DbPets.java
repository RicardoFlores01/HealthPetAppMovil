package example.com.healthpetapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbPets extends DBHelper{
    Context context;
    public DbPets(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public Long instertaMascota(String namePet, String race, String age, String weight) {
        long id = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("namePet", namePet);
            values.put("race", race);
            values.put("age", age);
            values.put("weight", weight);


            id = db.insert(TABLE_PETS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;

    }
}
