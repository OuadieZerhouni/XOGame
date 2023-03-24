package com.wadie.xogame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class main_activity extends Activity {
    private Button one_v_one;
    private Button one_v_bot;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one_v_one = findViewById(R.id.button_1vs1_game);
        one_v_bot = findViewById(R.id.button_1vsComputer_game);
        exit = findViewById(R.id.button_exit);

        one_v_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_activity.this, one_v_one_activity.class);
                startActivity(intent);
                Toast.makeText(main_activity.this, "1 VS 1 game", Toast.LENGTH_SHORT).show();
            }
        });
        one_v_bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_activity.this, one_v_bot_activity.class);
                startActivity(intent);
                Toast.makeText(main_activity.this, "Agaist Bot game", Toast.LENGTH_SHORT).show();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}