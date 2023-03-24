package com.wadie.xogame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.wadie.xogame.actions.PlayAction;

public class one_v_one_activity extends Activity {
    private Button btn_00, btn_01, btn_02, btn_10, btn_11, btn_12, btn_20, btn_21, btn_22,btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_v_one);
        btn_00 = findViewById(R.id.button_00);
        btn_01 = findViewById(R.id.button_01);
        btn_02 = findViewById(R.id.button_02);
        btn_10 = findViewById(R.id.button_10);
        btn_11 = findViewById(R.id.button_11);
        btn_12 = findViewById(R.id.button_12);
        btn_20 = findViewById(R.id.button_20);
        btn_21 = findViewById(R.id.button_21);
        btn_22 = findViewById(R.id.button_22);
        btn_back = findViewById(R.id.button_back);
        btn_back.setOnClickListener(v -> {
            Intent intent = new Intent(one_v_one_activity.this, main_activity.class);
            startActivity(intent);
        });

        PlayAction playAction=new PlayAction(this);
        btn_00.setOnClickListener(playAction);
        btn_01.setOnClickListener(playAction);
        btn_02.setOnClickListener(playAction);
        btn_10.setOnClickListener(playAction);
        btn_11.setOnClickListener(playAction);
        btn_12.setOnClickListener(playAction);
        btn_20.setOnClickListener(playAction);
        btn_21.setOnClickListener(playAction);
        btn_22.setOnClickListener(playAction);
    }

    public void resetBoard() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);}

}