package example.com.healthpetapp.ui.contactos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import example.com.healthpetapp.AddContact;
import example.com.healthpetapp.MenuActivity;
import example.com.healthpetapp.R;
import example.com.healthpetapp.TwoStepVerification;
import example.com.healthpetapp.adaptadores.listaContactosAdapter;
import example.com.healthpetapp.databinding.FragmentGalleryBinding;
import example.com.healthpetapp.db.DbContactos;
import example.com.healthpetapp.entidades.Contactos;
import example.com.healthpetapp.ui.gallery.GalleryViewModel;

public class ContactsActivity extends AppCompatActivity {
    
    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        /*TextView img = (TextView) findViewById(R.id.callContact);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel = "44495777823";
                startActivity(new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:"+tel)));
            }
        });*/

        listaContactos = findViewById(R.id.listaContactos);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        DbContactos dbContactos = new DbContactos(ContactsActivity.this);

        listaArrayContactos = new ArrayList<>();

        listaContactosAdapter adapter = new listaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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

            case android.R.id.home:
                finish();
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