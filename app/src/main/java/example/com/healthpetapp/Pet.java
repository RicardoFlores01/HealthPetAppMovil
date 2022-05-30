package example.com.healthpetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import example.com.healthpetapp.adaptadores.listaPetsAdapter;
import example.com.healthpetapp.db.DbPets;
import example.com.healthpetapp.entidades.Pets;

public class Pet extends AppCompatActivity {

    FloatingActionButton nuevaMascota;
    RecyclerView listaPets;
    ArrayList<Pets> listaArrayPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

        listaPets = findViewById(R.id.listaPets);
        listaPets.setLayoutManager(new LinearLayoutManager(this));

        DbPets dbPets = new DbPets(Pet.this);

        listaArrayPets = new ArrayList<>();

        listaPetsAdapter adapter = new listaPetsAdapter(dbPets.mostrarPets());
        listaPets.setAdapter(adapter);


        nuevaMascota = (FloatingActionButton) findViewById(R.id.nuevaMascota);
        nuevaMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pet.this, add_pet.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}