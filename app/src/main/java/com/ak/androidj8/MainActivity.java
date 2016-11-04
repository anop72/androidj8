package com.ak.androidj8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);

        Button but = (Button) findViewById(R.id.but);
        but.setOnClickListener(v -> makeRequest());

        List<String> lines = Arrays.asList("Annop", "AK", "Champ");

        List result = lines.stream()
                .filter(r -> r.contains("Ann"))
                .map(r -> r + " KOBKIJ")
                .collect(Collectors.toList());

        result.forEach(r -> textView.setText(textView.getText() + " " + r));

    }

    private void log(String msg) {
        Log.d(MainActivity.class.getSimpleName(), msg);
    }

    private void makeRequest() {

        PokemonGateway gateway = ServerAPI.createRetrofitService(PokemonGateway.class);

        Random r = new Random();
        int randomId = r.nextInt(100) + 1;

        Observable<Pokemon> observable = gateway.pokemon(randomId);

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(
                        res -> {
                            textView.setText(res.name);
                            log(res.name);
                        },
                        error -> log("error")
                );
    }

}
