package com.example.gametictctoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayer extends AppCompatActivity {
EditText player1, player2;
Button startGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        player1 = findViewById(R.id.playerOne_edt);
        player2 = findViewById(R.id.playerTwo_edt);
        startGame = findViewById(R.id.startGame_btn);



        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getPlayerOne = player1.getText().toString();
                String getPlayerTwo = player2.getText().toString();


                if (getPlayerOne.isEmpty() || getPlayerTwo.isEmpty()){
                    Toast.makeText(AddPlayer.this, "Vui lòng nhập tên người chơi", Toast.LENGTH_SHORT).show();
                }else {

                    Intent intent = new Intent(AddPlayer.this, MainActivity.class);
                    intent.putExtra("player1", getPlayerOne);
                    intent.putExtra("player2", getPlayerTwo);
                    startActivity(intent);
                }
            }
        });


    }


}