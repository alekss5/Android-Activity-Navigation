package com.example.multiple;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button finish = findViewById(R.id.a3finish);
        TextView name = findViewById(R.id.a3name);
        TextView years = findViewById(R.id.a3years);
        TextView address = findViewById(R.id.a3address);
        TextView city = findViewById(R.id.a3city);

        MapView mapView = findViewById(R.id.mapView);

      Intent intent = getIntent();
      if (intent.hasExtra("people")){
           People people = (People) intent.getParcelableExtra("people");
           //getParsableExtra()

            if (people != null) {


                name.setText(people.getName());
                years.setText(String.valueOf(people.getAge()));
                address.setText(people.getAddress());
                city.setText(people.getCity());

                finish.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        finishAndRemoveTask();

                    }
                });
            }
        }
    }
}