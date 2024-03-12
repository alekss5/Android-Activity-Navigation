package com.example.multiple;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView nameText = findViewById(R.id.nameText);

        TextView years = findViewById(R.id.years);
        TextView address = findViewById(R.id.address);
        TextView city = findViewById(R.id.city);

        Button next = findViewById(R.id.next);
        Button back = findViewById(R.id.back);

        TextView errorText = findViewById(R.id.a2error);
        Intent intent = getIntent();
        if (intent.hasExtra("people")){
            People people = (People) intent.getParcelableExtra("people");

            if (people != null) {
                String name = people.getName();
                nameText.setText(name);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(isValidYears(Integer.parseInt(years.getText().toString()))){
                            people.setAge(Integer.parseInt(years.getText().toString()));
                            people.setAddress(address.getText().toString());
                            people.setCity(city.getText().toString());
                            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                            intent.putExtra("people", people);
                            startActivity(intent);
                        }
                        else{
                            errorText.setTextColor(getResources().getColor(R.color.red));
                            errorText.setVisibility(View.VISIBLE);

                        }


                    }
                });
            }
        }
    }

    public boolean isValidYears(int years) {
        try {
            if (years >= 1) {
                LocalDate today = LocalDate.now();
                LocalDate oneYearFromToday = today.plusYears(1);
                int currentYear = today.getYear();
                return years >= (currentYear - oneYearFromToday.getYear());
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}