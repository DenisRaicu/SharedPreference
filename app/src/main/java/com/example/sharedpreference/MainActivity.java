package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.email = (EditText)findViewById(R.id.txt_email);
        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        this.email.setText(pref.getString("mail", ""));
    }

    //Metodo para el boton guardar:
    public void guardar(View view) {
        SharedPreferences sh = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sh.edit();
        edit.putString("mail", this.email.getText().toString());
        edit.commit();
        this.finish();
    }
}
