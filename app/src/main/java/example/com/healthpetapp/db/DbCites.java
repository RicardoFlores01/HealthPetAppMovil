package example.com.healthpetapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbCites extends DBHelper {

    Context context;

    public DbCites(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public Long instertaCita(String name, String service, String description, String remind, String fecha, String hora) {
        long id = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("service", service);
            values.put("description", description);
            values.put("remind", remind);
            values.put("fecha", fecha);
            values.put("hora", hora);

            id = db.insert(TABLE_CITES, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return null;

    }

}
