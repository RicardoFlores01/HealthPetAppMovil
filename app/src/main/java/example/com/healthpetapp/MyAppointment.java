package example.com.healthpetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;

import example.com.healthpetapp.db.DbCites;
import example.com.healthpetapp.entidades.Citas;

public class MyAppointment extends AppCompatActivity {

    EditText ser_text, calendar_text, time_text, name, desc_text;
    Button btnModify;

    Citas cita;
    int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointment);

        ser_text = (EditText) findViewById(R.id.ser_text);
        calendar_text = (EditText) findViewById(R.id.calendar_text);
        time_text = (EditText) findViewById(R.id.time_text);
        name = (EditText) findViewById(R.id.name);
        desc_text = (EditText) findViewById(R.id.desc_text);
        btnModify = (Button) findViewById(R.id.btnModify);

        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);

            }else {
                id = extras.getInt("ID");
            }
        }else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbCites dbCites = new DbCites(MyAppointment.this);
        cita = dbCites.VerCitas(id);

        if (cita != null){
            ser_text.setText(cita.getService());
            calendar_text.setText(cita.getFecha());
            time_text.setText(cita.getHora());
            name.setText(cita.getName());
            desc_text.setText(cita.getDescription());
            //no abrir el teclado en editext

            ser_text.setInputType(InputType.TYPE_NULL);
            calendar_text.setInputType(InputType.TYPE_NULL);
            time_text.setInputType(InputType.TYPE_NULL);
            name.setInputType(InputType.TYPE_NULL);
            desc_text.setInputType(InputType.TYPE_NULL);
        }
    }
}