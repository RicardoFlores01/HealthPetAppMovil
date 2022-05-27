package example.com.healthpetapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Random;

public class TwoStepVerification extends AppCompatActivity {

    Button verification;
    EditText code;
    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_step_verification);

        code = (EditText) findViewById(R.id.code);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("code", "Code Verification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Random random = new Random();
        int val = random.nextInt(1000);
        String codigo = Integer.toString(val);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "code").setSmallIcon(R.drawable.ic_baseline_pets_24)
                .setContentTitle("Code Verification").setContentText("Your code is " + codigo);

        notification = builder.build();
        notificationManagerCompat = notificationManagerCompat.from(this);

        notificationManagerCompat.notify(1, notification);
        //Toast.makeText(TwoStepVerification.this,codigo, Toast.LENGTH_LONG).show();

        verification = (Button) findViewById(R.id.btnVerification);
        verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod = code.getText().toString();
                //Toast.makeText(TwoStepVerification.this,cod, Toast.LENGTH_LONG).show();
                if(cod.equals(codigo)){
                    Intent intent = new Intent(TwoStepVerification.this, MenuActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(TwoStepVerification.this,"The code is not correct", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}