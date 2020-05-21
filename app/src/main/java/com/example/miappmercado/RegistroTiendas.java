package com.example.miappmercado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistroTiendas extends AppCompatActivity {

    Spinner distritos;
    Spinner mercados;
    Spinner rubros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tiendas);
        distritos = (Spinner)findViewById(R.id.sp01);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Distritos,android.R.layout.simple_selectable_list_item);
        distritos.setAdapter(adapter);
        mercados = (Spinner)findViewById(R.id.sp02);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.Mercados,android.R.layout.simple_selectable_list_item);
        mercados.setAdapter(adapter1);
        rubros = (Spinner)findViewById(R.id.sp03);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.Rubros,android.R.layout.simple_selectable_list_item);
        rubros.setAdapter(adapter2);
    }
    public void PrincipalMercado(View View) {
        Intent i = new Intent(RegistroTiendas.this , MercadoPrincipal.class);
        startActivity(i);
    }

}
