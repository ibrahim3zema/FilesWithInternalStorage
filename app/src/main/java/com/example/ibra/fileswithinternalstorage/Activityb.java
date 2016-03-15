package com.example.ibra.fileswithinternalstorage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activityb extends AppCompatActivity {
    TextView username , password;
    String DEFAULT="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        username= (TextView) findViewById(R.id.username);
        password=(TextView)findViewById(R.id.password);
    }

    public void previous(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void load(View view) {
        try {
            FileInputStream fileInputStream=openFileInput("ibra.txt");
            int read=-1;
            StringBuffer buffer=new StringBuffer();
            while((read=fileInputStream.read())!=-1){
                buffer.append((char)read);
            }
            String user=buffer.substring(0,buffer.indexOf(" "));
            String pass=buffer.substring(buffer.indexOf(" ")+1);
            username.setText(user);
            password.setText(pass);
            Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
