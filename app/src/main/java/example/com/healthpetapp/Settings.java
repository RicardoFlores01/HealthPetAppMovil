package example.com.healthpetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    TextView account_btn, language_btn, help_btn, aboutus_btn;
    Button btnLogout;

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

        language_btn = (TextView) findViewById(R.id.viewlanguage);
        language_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Language.class);
                startActivity(intent);
            }
        });

        help_btn = (TextView) findViewById(R.id.Viewhelp);
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

        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}