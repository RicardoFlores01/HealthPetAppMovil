package example.com.healthpetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.com.healthpetapp.db.DbContactos;
import example.com.healthpetapp.db.DbPets;

public class add_pet extends AppCompatActivity {

    EditText namePet, racePet, agePet, weightPet;
    Button btnSavePet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        namePet = (EditText) findViewById(R.id.namePet);
        racePet = (EditText) findViewById(R.id.racePet);
        agePet = (EditText) findViewById(R.id.agePet);
        weightPet = (EditText) findViewById(R.id.weightPet);
        btnSavePet = (Button) findViewById(R.id.btnSavePet);

        btnSavePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbPets dbPets = new DbPets(add_pet.this);
                long id = dbPets.instertaMascota(namePet.getText().toString(), racePet.getText().toString(), agePet.getText().toString(), weightPet.getText().toString());

                if (id > 0){
                    Toast.makeText(add_pet.this, "MASCOTA GUARDADA", Toast.LENGTH_LONG).show();
                    limpiar();
                } else{
                    Toast.makeText(add_pet.this, "ERROR al guardar MASCOTA", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar(){
        namePet.setText("");
        racePet.setText("");
        agePet.setText("");
        weightPet.setText("");

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