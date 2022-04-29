package example.com.healthpetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TwoStepVerification extends AppCompatActivity {

    Button verification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        verification = (Button) findViewById(R.id.btnVerification);
        verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoStepVerification.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}