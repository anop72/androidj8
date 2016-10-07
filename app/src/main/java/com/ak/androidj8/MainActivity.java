package com.ak.androidj8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text_view);

        Button but = (Button) findViewById(R.id.but);
        but.setOnClickListener(v -> Log.d("MainActivity", "clicked"));

        List<String> lines = Arrays.asList("Annop", "AK", "Champ");

        List result = lines.stream()
                .filter(r -> r.contains("Ann"))
                .map(r -> r + " KOBKIJ")
                .collect(Collectors.toList());

        result.forEach(r -> textView.setText(textView.getText() + " " + r));
    }

}
