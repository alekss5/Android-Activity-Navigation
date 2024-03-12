package com.example.multiple;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button nextPageButton = findViewById(R.id.b1);

        TextView textView = findViewById(R.id.text1);
        TextView errorText = findViewById(R.id.errorText1);
        People people = new People();





        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                if(textView.length()>5){
                    people.setName(textView.getText().toString());
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
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