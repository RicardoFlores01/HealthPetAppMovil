package example.com.healthpetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.com.healthpetapp.db.DbCites;
import example.com.healthpetapp.db.DbContactos;

public class AddContact extends AppCompatActivity {

    EditText txtName, txtPhone, txtAddress, txtEmail;
    Button btnSaveContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        txtName = (EditText) findViewById(R.id.txtName);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtAddress = (EditText) findViewById(R.id.txtAddress);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnSaveContact = (Button) findViewById(R.id.btnSaveContact);

        btnSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(AddContact.this);
                long id = dbContactos.instertaContacto(txtName.getText().toString(), txtPhone.getText().toString(), txtAddress.getText().toString(), txtEmail.getText().toString());
                if (id > 0){
                    Toast.makeText(AddContact.this, "CONTACTO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else{
                    Toast.makeText(AddContact.this, "ERROR al guardar CONTACTO", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    private void limpiar(){
        txtName.setText("");
        txtPhone.setText("");
        txtAddress.setText("");


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