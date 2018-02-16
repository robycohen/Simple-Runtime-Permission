package com.robydarmansyah.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.robydarmansyah.simplepermission.SimplePermission;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button requestBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestBtn=(Button) findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.requestBtn:
                SimplePermission.with(MainActivity.this)
                        .request(SimplePermission.CAMERA,SimplePermission.WRITE_EXTERNAL_STORAGE)
                        .onRequestResultListener(new SimplePermission.OnRequestResult() {
                            @Override
                            public void onGranted() {
                                Toast.makeText(getApplicationContext(),"Permission Granted",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onDenied() {
                                Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
                            }
                        });
                break;
        }
    }
}
