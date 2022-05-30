package example.com.healthpetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    TextView account_btn, language_btn, help_btn, aboutus_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        account_btn = (TextView) findViewById(R.id.account);
        account_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Profile.class);
                startActivity(intent);
            }
        });

        language_btn = (TextView) findViewById(R.id.language);
        language_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Language.class);
                startActivity(intent);
            }
        });

        help_btn = (TextView) findViewById(R.id.help);
        help_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Help.class);
                startActivity(intent);
            }
        });

        aboutus_btn = (TextView) findViewById(R.id.aboutus);
        aboutus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, About.class);
                startActivity(intent);
            }
        });
    }
}