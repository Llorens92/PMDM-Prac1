package com.example.dam2.adivinanumero_llorenspages;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class AdivinaNumero extends AppCompatActivity {

    EditText et1;
    TextView tv1;
    TextView tv2;
    int numAlea;
    int intentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivina_numero);
        et1= (EditText) findViewById(R.id.CuadroTexto);
        et1.setOnKeyListener(new android.view.View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, android.view.KeyEvent event){
            boolean pulso;
            if(event.getAction()== KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                pulso=true;
            }else{
                pulso=false;
            }
            return pulso;
        }
        });
        tv1 = (TextView) findViewById(R.id.respuesta);
        tv2 = (TextView) findViewById(R.id.nºintentos);
        //numAlea= new Random().nextInt(100)+1;
        numAlea=50;
    }

    public void botonPulsado(View v){
        Resources res = getResources();
        try{
            int numIntro = Integer.parseInt(et1.getText().toString());
            intentos++;
            if(numAlea==numIntro) {
                tv1.setText(R.string.acierto);
            }else if(numAlea<numIntro){
                tv1.setText(String.format(res.getString(R.string.errorMen), numIntro));
            }else{
                tv1.setText(String.format(res.getString(R.string.errorMay), numIntro));
            }

        }catch(NumberFormatException ex){
            tv1.setText(R.string.errorNum);
        }finally{
            tv2.setText(res.getQuantityString(R.plurals.intentos,intentos,intentos));
            tv2.setVisibility(View.VISIBLE);
        }
    }

}
