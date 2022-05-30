package example.com.healthpetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {

    Button btnWhats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        btnWhats  = (Button) findViewById(R.id.button2);
        btnWhats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                intent.putExtra("jid", PhoneNumberUtils.stripSeparators("52" + "4495777823")+"@s.whatsapp.net");
                startActivity(intent);
            }
        });
    }
}