//José vitor Alves Pignataro
//00096150
//Sexto Semestre Ciências da computação

package com.uniso.lpdm.pizzariapinh4ta;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
public class ExpedienteActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;
    private boolean Wrunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expediente);

        running = true;
        Wrunning = true;

        //verificação ára ver se o estadio é nulo
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("Segundos");
            running = savedInstanceState.getBoolean("Rodando");
            Wrunning =savedInstanceState.getBoolean("Estavarodando");
        }
        RuntimeCount();
    }

    //salva o estado atual da atividade antes de finalizar
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("Segundos", seconds);
        savedInstanceState.putBoolean("Rodando", running);
        savedInstanceState.putBoolean("Estavarodando", Wrunning);

        super.onSaveInstanceState(savedInstanceState);
    }


    @Override
    protected void onPause(){
        super.onPause();
        Wrunning = running;
        running = false;
    }

    @Override
    protected void onResume(){
        super.onResume();
        running = Wrunning;
    }

    //Inicia a contagem
    public void onClickStart(View view){
        running = true;
    }
    //pausa a contagem
    public void  onClickStop(View view){
        running = false;
    }
    //finaliza/zera a contagem
    public void onClickFinish(View view){
        running = false;
        seconds = 0;
    }


    private void RuntimeCount(){

        final TextView textView = (TextView) findViewById(R.id.timecount);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                //calculo do tempo
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secondsI = seconds%60;

                //definimos o formato que será exibido na tela
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours,minutes,secondsI);
                textView.setText(time);
                    if(running){
                        seconds++;
                    }
                    handler.postDelayed(this, 1000);
                }
            }
        );
    }

    //Método que retorna ao menu ao clicar em uma elemento, neste caso um botão.
    public void onclickBack2Menu(View view){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }

}