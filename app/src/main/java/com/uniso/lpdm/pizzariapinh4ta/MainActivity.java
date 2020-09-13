package com.uniso.lpdm.pizzariapinh4ta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método que chama o textview referente a horas quando clicar
    public void onclickhourCheck(View view){
        TextView chkHours = findViewById(R.id.RegHours);
        chkHours.setText("Total de horas!");
    }
    //Método que chama o textview referente a pedindo quando executar o click
    public void OnClickOrder(View view){
        TextView orderfood = findViewById(R.id.RegiPed);
        orderfood.setText("Registrando pedido...");
    }

    //Método que chama a segunda atividade que nos leva a cadastro de pedido para a cozinha
    public void OnClickKitchen(View view){
    Intent intent = new Intent(this, KItchenActivity.class);
    startActivity(intent);
    }

}