package com.example.multiple;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected String activityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityName = getClass().getSimpleName();
        Log.i(activityName, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(activityName, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(activityName, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(activityName, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(activityName, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(activityName, "onDestroy");
    }
}
