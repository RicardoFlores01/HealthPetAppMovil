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

        return id;

    }

    public ArrayList<Citas> mostrarCitas() {

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Citas> listaCitas = new ArrayList<>();
        Citas cita = null;

        Cursor cursorCitas = null;

        cursorCitas = db.rawQuery("SELECT * FROM " + TABLE_CITES, null);

        if (cursorCitas.moveToFirst()) {
            do {
                cita = new Citas();
                cita.setId(cursorCitas.getInt(0));
                cita.setName(cursorCitas.getString(1));
                cita.setService(cursorCitas.getString(2));
                cita.setDescription(cursorCitas.getString(3));
                cita.setRemind(cursorCitas.getString(4));
                cita.setFecha(cursorCitas.getString(5));
                cita.setHora(cursorCitas.getString(6));
                listaCitas.add(cita);
            } while (cursorCitas.moveToNext());
        }
        cursorCitas.close();
        return listaCitas;
    }

    public Citas VerCitas(int Id) {

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        Citas cita = null;
        Cursor cursorCitas;

        cursorCitas = db.rawQuery("SELECT * FROM " + TABLE_CITES + "WHERE Id = " + Id + "LIMIT 1", null);


        if (cursorCitas.moveToFirst()) {
                cita = new Citas();
                cita.setId(cursorCitas.getInt(0));
                cita.setName(cursorCitas.getString(1));
                cita.setService(cursorCitas.getString(2));
                cita.setDescription(cursorCitas.getString(3));
                cita.setRemind(cursorCitas.getString(4));
                cita.setFecha(cursorCitas.getString(5));
                cita.setHora(cursorCitas.getString(6));
        }
        cursorCitas.close();
        return cita;
    }


}
