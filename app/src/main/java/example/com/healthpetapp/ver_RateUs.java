package example.com.healthpetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class ver_RateUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_rate_us);

        RateUsDialog rateUsDialog = new RateUsDialog(ver_RateUs.this);
        rateUsDialog.show();



    }
}