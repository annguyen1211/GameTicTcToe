package com.example.gametictctoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class  MainActivity extends AppCompatActivity {
    TextView player1, player2;
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    LinearLayout player1Layout, player2Layout;


    final List<int[]> list = new ArrayList<>();
    int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int playerTurn = 1;
    int totalSelectionBox = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        player1 = findViewById(R.id.playerOneName);
        player2 = findViewById(R.id.playerTwoName);


        player1Layout = findViewById(R.id.playerOneLayout);
        player2Layout = findViewById(R.id.playerTwoLayout);
        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        img3 = findViewById(R.id.image3);
        img4 = findViewById(R.id.image4);
        img5 = findViewById(R.id.image5);
        img6 = findViewById(R.id.image6);
        img7 = findViewById(R.id.image7);
        img8 = findViewById(R.id.image8);
        img9 = findViewById(R.id.image9);


        list.add(new int[]{0, 1, 2});
        list.add(new int[]{3, 4, 5});
        list.add(new int[]{6, 7, 8});
        list.add(new int[]{0, 3, 6});
        list.add(new int[]{1, 4, 7});
        list.add(new int[]{2, 5, 8});
        list.add(new int[]{2, 4, 6});
        list.add(new int[]{0, 4, 8});

        final String getPlayerOneName = getIntent().getStringExtra("player1");
        final String getPlayerTwoName = getIntent().getStringExtra("player2");


        player1.setText(getPlayerOneName);
        player2.setText(getPlayerTwoName);


        player1Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        player2Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(0)){
                    performAction((ImageView)v, 0);

                }

            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(1)){
                    performAction((ImageView)v, 1);

                }

            }
        });


        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(2)){
                    performAction((ImageView)v, 2);

                }

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(3)){
                    performAction((ImageView)v, 3);

                }

            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(4)){
                    performAction((ImageView)v, 4);

                }

            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(5)){
                    performAction((ImageView)v, 5);

                }

            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(6)){
                    performAction((ImageView)v, 6);

                }

            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(7)){
                    performAction((ImageView)v, 7);

                }

            }
        });


        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(8)){
                    performAction((ImageView)v, 8);
                }

            }
        });
    }


    void performAction(ImageView imageView, int selectedBoxPosition){

        boxPositions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1 ){
            imageView.setImageResource(R.drawable.cross);

            if (checkPlayerWin()){

                WinDialog winDialog = new WinDialog(MainActivity.this, player1.getText().toString() + " Chiến thắng", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }

            else if (totalSelectionBox == 9){
                WinDialog winDialog = new WinDialog(MainActivity.this, "Hòa", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(2);
                totalSelectionBox++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.circle);
            if(checkPlayerWin()){
                WinDialog winDialog = new WinDialog(MainActivity.this, player2.getText().toString() + " Chiến thắng", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }

            else {
                changePlayerTurn(1);
                totalSelectionBox++;
            }

        }


    }



    void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if(playerTurn == 1 ){
            player1Layout.setBackgroundResource(R.drawable.round_black_blue_border);
            player2Layout.setBackgroundResource(R.drawable.round_black_dark_blue);

        }
        else{
            player1Layout.setBackgroundResource(R.drawable.round_black_dark_blue);
            player2Layout.setBackgroundResource(R.drawable.round_black_blue_border);
        }
    }

    boolean checkPlayerWin(){
        boolean response = false;

        for (int i = 0;i<list.size();i++){
            int [] winState = list.get(i);

            if(boxPositions[winState[0]] == playerTurn && boxPositions[winState[1]] == playerTurn && boxPositions[winState[2]] == playerTurn){
                response = true;
            }
        }

        return response;
    }



        boolean isBoxSelected(int boxPosition){

            boolean response = false;
            if (boxPositions[boxPosition] == 0 ){
                response = true;

        }
            return response;


    }

    public void restartMatch(){
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn = 1;

        totalSelectionBox = 1;

        img1.setImageResource(R.drawable.transparent1);
        img2.setImageResource(R.drawable.transparent1);
        img3.setImageResource(R.drawable.transparent1);
        img4.setImageResource(R.drawable.transparent1);
        img5.setImageResource(R.drawable.transparent1);
        img6.setImageResource(R.drawable.transparent1);
        img7.setImageResource(R.drawable.transparent1);
        img8.setImageResource(R.drawable.transparent1);
        img9.setImageResource(R.drawable.transparent1);



    }
}