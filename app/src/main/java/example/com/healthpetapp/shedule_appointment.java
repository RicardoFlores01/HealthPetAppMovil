package example.com.healthpetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import example.com.healthpetapp.db.DBHelper;
import example.com.healthpetapp.db.DbCites;

public class shedule_appointment extends AppCompatActivity implements View.OnClickListener {

    Button btnCalendar, btnTime, btnSaveDate;
    EditText calendar_text, time_text;
    private  int dia, mes, año, hora, minutos;

    EditText name, ser_text, desc_text, remind_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shedule_appointment);

        btnCalendar = (Button) findViewById(R.id.cal);
        btnTime = (Button) findViewById(R.id.tim);
        calendar_text = (EditText) findViewById(R.id.calendar_text);
        time_text = (EditText) findViewById(R.id.time_text);
        btnCalendar.setOnClickListener(this);
        btnTime.setOnClickListener(this);

        name = (EditText) findViewById(R.id.name);
        ser_text = (EditText) findViewById(R.id.ser_text);
        desc_text = (EditText) findViewById(R.id.desc_text);
        remind_text = (EditText) findViewById(R.id.remind_text);
        btnSaveDate = (Button) findViewById(R.id.btnSaveDate);

        btnSaveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbCites dbCites = new DbCites(shedule_appointment.this);
               long id = dbCites.instertaCita(name.getText().toString(), ser_text.getText().toString(), desc_text.getText().toString(), remind_text.getText().toString(), calendar_text.getText().toString(), time_text.getText().toString());

                if (id > 0){
                    Toast.makeText(shedule_appointment.this, "Cita guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                } else{
                    Toast.makeText(shedule_appointment.this, "ERROR al guardar cita", Toast.LENGTH_LONG).show();
                }


            }
        });


    }
    private void limpiar(){
        name.setText("");
        ser_text.setText("");
        desc_text.setText("");
        remind_text.setText("");
        calendar_text.setText("");
        time_text.setText("");
    }





    @Override
    public void onClick(View v) {
        if(v==btnCalendar){
            final Calendar c = Calendar.getInstance();
            dia= c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    calendar_text.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);

                }
            }
            ,dia,mes,año);
            datePickerDialog.show();

        }if (v==btnTime){
            final Calendar c = Calendar.getInstance();
            hora= c.get(Calendar.HOUR_OF_DAY);
            minutos= c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    time_text.setText(hourOfDay+":"+minute);
                }
            }, hora, minutos, false);
            timePickerDialog.show();

        }
    }
}