package com.example.ibra.fileswithinternalstorage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
    }

    public void save(View view) {
        FileOutputStream fileOutputStream=null;
        File file=null;
        String user=username.getText().toString();
        String pass=password.getText().toString();
        user=user+" ";
        try {
            file=getFilesDir();
            fileOutputStream=openFileOutput("ibra.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(user.getBytes());
            fileOutputStream.write(pass.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Data saved successfully"+file+"/ibra.txt", Toast.LENGTH_LONG).show();

    }

    public void next(View view) {
        Intent i = new Intent(this, Activityb.class);
        startActivity(i);
    }


}
