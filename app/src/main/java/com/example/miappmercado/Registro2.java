package com.example.miappmercado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Registro2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
    }

    public void RegistroUsuarios(View View) {
        Intent i = new Intent(Registro2.this , Registro.class);
        startActivity(i);
    }
   public void Tiendas(View View) {
        Intent i = new Intent(Registro2.this , RegistroTiendas.class);
        startActivity(i);
    }
}
