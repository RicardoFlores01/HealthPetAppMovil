package example.com.healthpetapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.icu.number.Scale;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import example.com.healthpetapp.db.DbContactos;
import example.com.healthpetapp.ui.RateUs.RateFragment;

public class RateUsDialog extends Dialog  {

    private float userRate = 0;

    public RateUsDialog(@NonNull Context context) {
        super(context);
    }

     Button rateNowBtn, laterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_us_dialog_layout);

        rateNowBtn = (Button) findViewById(R.id.rateNowBtn);
        laterBtn = findViewById(R.id.laterBtn);

        final AppCompatButton rateNowBtn = findViewById(R.id.rateNowBtn);
        final AppCompatButton laterBtn = findViewById(R.id.laterBtn);
        final RatingBar ratingbar = findViewById(R.id.ratingbar);
        final ImageView ratingImage = findViewById(R.id.ratingImage);


        rateNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Rating Sent" + " "+ userRate, Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        laterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dismiss();

            }
        });

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                if (v <= 1){
                    ratingImage.setImageResource(R.drawable.one_star);
                }
                else  if (v <= 2){
                    ratingImage.setImageResource(R.drawable.two_star);
                }
                else if (v <= 3){
                    ratingImage.setImageResource(R.drawable.treeh_star);
                }
                else if (v <= 4){
                    ratingImage.setImageResource(R.drawable.four_star);
                }
                else if (v <= 5){
                    ratingImage.setImageResource(R.drawable.five_start);
                }

                animateImage(ratingImage);

                userRate = v;

            }
        });
    }

    private void animateImage(ImageView ratingImage){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1f, 0, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(100);
        ratingImage.startAnimation(scaleAnimation);
    }
}
