package example.com.healthpetapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import example.com.healthpetapp.adaptadores.listaCitasAdapter;
import example.com.healthpetapp.db.DbCites;
import example.com.healthpetapp.entidades.Citas;

public class VerCitas extends AppCompatActivity {

    RecyclerView listaCitas;
    ArrayList<Citas> listaArrayCitas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_citas);

        listaCitas = (RecyclerView) findViewById(R.id.listaCitas);
        listaCitas.setLayoutManager(new LinearLayoutManager(this));

        DbCites dbCites = new DbCites(VerCitas.this);

        listaArrayCitas = new ArrayList<>();

        listaCitasAdapter adapter = new listaCitasAdapter(dbCites.mostrarCitas());
        listaCitas.setAdapter(adapter);
    }

}