package com.example.gametictctoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;



public class WinDialog extends Dialog {
    String message;

    TextView messagetxt;
    Button starAgainbtn;

    MainActivity mainActivity;
    public WinDialog(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }


    protected void onCreate(Bundle saveInstaceState){
        super.onCreate(saveInstaceState);

        setContentView(R.layout.win_dialog_layout);

         messagetxt = findViewById(R.id.message_txt);
         starAgainbtn = findViewById(R.id.startAgain_btn);



         messagetxt.setText(message);





         starAgainbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                mainActivity.restartMatch();
                dismiss();
             }
         });




    }





}
