package example.com.healthpetapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import example.com.healthpetapp.entidades.Citas;

public class DbCites extends DBHelper {

    Context context;

    public DbCites(@Nullable Context context) {
        super(context, "t_cites", null, 1);
        this.context = context;
    }

    public Long instertaCita(String name, String service, String description, String remind, String fecha, String hora) {
        long id = 0;

        try {
            DBHelper dbHelper = new DBHelper(context, "t_cites", null, 1);
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

        return id;

    }

    public ArrayList<Citas> mostrarCitas() {

        DBHelper dbHelper = new DBHelper(context, "t_cites", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Citas> listaCitas = new ArrayList<>();
        Citas citas = null;

        Cursor cursorCitas = null;

        cursorCitas = db.rawQuery("SELECT * FROM " + TABLE_CITES, null);

        if (cursorCitas.moveToFirst()) {
            do {
                citas = new Citas();
                citas.setId(cursorCitas.getInt(0));
                citas.setName(cursorCitas.getString(1));
                citas.setService(cursorCitas.getString(2));
                citas.setDescription(cursorCitas.getString(3));
                citas.setRemind(cursorCitas.getString(4));
                citas.setFecha(cursorCitas.getString(5));
                citas.setHora(cursorCitas.getString(6));
                listaCitas.add(citas);
            } while (cursorCitas.moveToNext());
        }
        cursorCitas.close();
        return listaCitas;


    }
}
