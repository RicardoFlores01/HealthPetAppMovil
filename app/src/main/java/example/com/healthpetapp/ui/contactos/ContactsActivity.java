package example.com.healthpetapp.ui.contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import example.com.healthpetapp.AddContact;
import example.com.healthpetapp.R;
import example.com.healthpetapp.adaptadores.listaContactosAdapter;
import example.com.healthpetapp.db.DbContactos;
import example.com.healthpetapp.entidades.Contactos;

public class ContactsActivity extends AppCompatActivity {
    
    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        listaContactos = findViewById(R.id.listaContactos);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        DbContactos dbContactos = new DbContactos(ContactsActivity.this);

        listaArrayContactos = new ArrayList<>();

        listaContactosAdapter adapter = new listaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contactos, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.agregarContacto:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void nuevoRegistro(){
        Intent intent = new Intent(this, AddContact.class);
        startActivity(intent);
    }
}