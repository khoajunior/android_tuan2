package com.example.andriod_tuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = findViewById(R.id.editTextTextPersonName);
        final EditText editText2 = findViewById(R.id.editTextTextPersonName2);
        final CheckBox cBox1 = findViewById(R.id.checkBox);
        final CheckBox cBox2 = findViewById(R.id.checkBox2);
        final CheckBox cBox3 = findViewById(R.id.checkBox3);
        final CheckBox cBox4 = findViewById(R.id.checkBox4);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = Integer.parseInt(editText2.getText().toString());



                String password = generatePassword(length, cBox1.isChecked(), cBox2.isChecked(),cBox3.isChecked(), cBox4.isChecked());
                editText.setText(password);
            }
        });
    }
    public String generatePassword(int length, boolean includeLower, boolean includeUpper,
                                   boolean includeNumber, boolean includeSpecial) {
        final String lowerCase = "qwertyuioplkjhgfdsazxcvbnm";
        final String upperCase = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        final String numberCase = "1234567890";
        final String specialCase = "~!@#$%^&*()_+-=[]{};:/?.>,<";
        String chars = "";

        if (includeLower)
            chars += lowerCase;

        if (includeUpper)
            chars += upperCase;

        if (includeNumber)
            chars += numberCase;

        if (includeSpecial)
            chars += specialCase;

        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i)
            sb.append(chars.charAt(random.nextInt(chars.length())));

        return sb.toString();
    }
}