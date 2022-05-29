package example.com.healthpetapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import example.com.healthpetapp.entidades.Contactos;
import example.com.healthpetapp.ui.gallery.GalleryFragment;

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

    public ArrayList<Contactos> mostrarContactos() {

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Contactos contacto = null;
        Cursor cursorContactos = null;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTS, null);

        if (cursorContactos.moveToFirst()) {
            do {
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNameContact(cursorContactos.getString(1));
                contacto.setPhone(cursorContactos.getString(2));
                contacto.setAddress(cursorContactos.getString(3));
                contacto.setEmail(cursorContactos.getString(4));
                listaContactos.add(contacto);
            } while (cursorContactos.moveToNext());
        }
        cursorContactos.close();
        return listaContactos;
    }
}
