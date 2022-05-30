package example.com.healthpetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class Language extends AppCompatActivity {

    TextView english, spanish;
    private Locale locale;
    private Configuration config = new Configuration();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        english = ((TextView)findViewById(R.id.english));
        spanish = ((TextView)findViewById(R.id.spanish));

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locale = new Locale("en");
                config.locale = locale;

                getResources().updateConfiguration(config, null);
                Intent refresh = new Intent(Language.this, MenuActivity.class);
                startActivity(refresh);
                finish();
            }
        });

        spanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locale = new Locale("es");
                config.locale = locale;

                getResources().updateConfiguration(config, null);
                Intent  refresh = new Intent(Language.this, MenuActivity.class);
                startActivity(refresh);
                finish();
            }
        });

        /*
        Resources res = Language.this.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale("es");
        res.updateConfiguration(conf, dm);

        startActivity(new Intent(Language.this, Language.class));
        finish();*/

    }
}