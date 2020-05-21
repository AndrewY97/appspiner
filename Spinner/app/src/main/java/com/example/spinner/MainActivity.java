package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner stemp1,stemp2;
    public EditText c1,c2;
    int p,q;
    String p2,q2;

    private void LisaTemp() {
        String[] temperaturas = {"Selecciona Unidad","°Centigrados", "°Farenheit", "°Kelvin", "°Rankine"};
        //ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.r.layout.sjmple_list_item_1,temperaturas);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temperaturas);
        stemp1.setAdapter(adapter);
    }

    private void LisaTemp2() {
        String[] temperaturas = {"°Centigrados", "°Farenheit", "°Kelvin", "°Rankine"};
        //ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.r.layout.sjmple_list_item_1,temperaturas);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temperaturas);
        stemp2.setAdapter(adapter);
    }

    private void LisaTemp3() {
        String[] temperaturas = {""};
        //ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.r.layout.sjmple_list_item_1,temperaturas);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temperaturas);
        stemp2.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stemp1 = (Spinner) findViewById(R.id.stemp1);
        stemp2 = (Spinner)findViewById(R.id.stemp2);

        c1 = (EditText)findViewById(R.id.c1);
        c2 = (EditText)findViewById(R.id.c2);

        //int p;

        LisaTemp();
        stemp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p= position;
                p2= Integer.toString(p);
                //p = Integer.valueOf(position);
                if (position!=0){
                    LisaTemp2();
                    //p = position;
                }else{
                    LisaTemp3();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        stemp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                q= position;
                q2= Integer.toString(q);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @SuppressLint("SetTextI18n")
    public void convierte(View v){
        String valor= c1.getText().toString();
        int valor2  =Integer.parseInt(valor);
        int resultado;
        //Toast.makeText(this, q2, Toast.LENGTH_LONG).show();
        if(p==1){
            if(q==0){
                c2.setText(valor);
            }if(q==1){
                resultado= (int) ((valor2*1.8)+32);
                c2.setText(Integer.toString(resultado));
            }if(q==2){
                resultado= (int) ((valor2+273.15));
                c2.setText(Integer.toString(resultado));
            }
            if(q==3){
                resultado= (int) (((valor2*1.8)+491.67));
                c2.setText(Integer.toString(resultado));
            }
        }if(p==2){
            if(q==0){
                resultado= (int)((valor2-32)*1.8);
                c2.setText(Integer.toString(resultado));
            }if(q==1){
                //resultado= (int) ((valor2*1.8)+32);
                //c2.setText(Integer.toString(resultado));
                c2.setText(valor);
            }if(q==2){
                resultado= (int) ((valor2-32)*1.8+273.15);
                c2.setText(Integer.toString(resultado));
            }
            if(q==3){
                resultado= (int) ((((valor2-32)*1.8)*1.8)+491.67);
                c2.setText(Integer.toString(resultado));
            }
        }if(p==3){
            if(q==0){
                resultado= (int)(valor2-273.15);
                c2.setText(Integer.toString(resultado));
            }if(q==1){
                resultado= (int) (((valor2-273.15)*1.8)+32);
                c2.setText(Integer.toString(resultado));
                //c2.setText(valor);
            }if(q==2){
                c2.setText(valor);
            }
            if(q==3){
                resultado= (int) (((valor2-273.15)*1.8)+491.67);
                c2.setText(Integer.toString(resultado));
            }
        }if(p==4){
            if(q==0){
                resultado= (int)((valor2-491.67)/1.8);
                c2.setText(Integer.toString(resultado));
            }if(q==1){
                resultado= (int) ((((valor2-491.67)/1.8)*1.8)+32);
                c2.setText(Integer.toString(resultado));
                //c2.setText(valor);
            }if(q==2){
                //c2.setText(valor);
                resultado= (int) ((((valor2-491.67)/1.8)+273.15));
                c2.setText(Integer.toString(resultado));
            }
            if(q==3){
                //resultado= (int) (((valor2-273.15)*1.8)+491.67);
                //c2.setText(Integer.toString(resultado));
                c2.setText(valor);
            }
        }
    }

}
