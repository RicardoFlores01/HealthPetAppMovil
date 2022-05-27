package example.com.healthpetapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DBHelper{
    Context context;

    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public Long instertaContacto(String nameContact, String phone, String address, String email) {
        long id = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nameContact", nameContact);
            values.put("phone", phone);
            values.put("address", address);
            values.put("email", email);


            id = db.insert(TABLE_CONTACTS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;

    }
}
