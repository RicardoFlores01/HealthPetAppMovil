package example.com.healthpetapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import example.com.healthpetapp.entidades.Contactos;
import example.com.healthpetapp.entidades.Pets;

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

    public ArrayList<Pets> mostrarPets(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Pets> listaPets = new ArrayList<>();
        Pets pet = null;
        Cursor cursorPets = null;

        cursorPets = db.rawQuery("SELECT * FROM " + TABLE_PETS, null);

        if (cursorPets.moveToFirst()) {
            do {
                pet = new Pets();
                pet.setId(cursorPets.getInt(0));
                pet.setNamePet(cursorPets.getString(1));
                pet.setRace(cursorPets.getString(2));
                pet.setAge(cursorPets.getString(3));
                pet.setWeight(cursorPets.getString(4));
                listaPets.add(pet);
            } while (cursorPets.moveToNext());
        }
        cursorPets.close();
        return listaPets;
    }
}
