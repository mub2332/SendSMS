package com.example.sendsms;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Siren extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siren);

        final MediaPlayer sirenMP = MediaPlayer.create(this, R.raw.tornado_siren_2);

        Button playSiren = (Button) this.findViewById(R.id.play_siren);

        playSiren.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(sirenMP.isPlaying())
                    sirenMP.pause();
                else
                    sirenMP.start();
            }
        });
    }
}
