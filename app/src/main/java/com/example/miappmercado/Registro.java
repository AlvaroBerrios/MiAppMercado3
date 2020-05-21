package com.example.miappmercado;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.miappmercado.ui.login.LoginActivity;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    EditText etNombre,etApellidos,etCorreo,etCorreo1,etTelefono,etContraseña,etContraseña1;
    Spinner distritos;
    Button Registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        distritos = (Spinner)findViewById(R.id.sp01);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Distritos,android.R.layout.simple_selectable_list_item);
        distritos.setAdapter(adapter);
        etNombre = (EditText)findViewById(R.id.Nombre);
        etApellidos = (EditText)findViewById(R.id.Apellidos);
        etCorreo = (EditText)findViewById(R.id.Correo);
        etCorreo1 = (EditText)findViewById(R.id.Correo1);
        etTelefono = (EditText)findViewById(R.id.Telefono);
        etContraseña = (EditText)findViewById(R.id.Contraseña);
        etContraseña1 = (EditText)findViewById(R.id.Contraseña1);
        //distritos = (Spinner)findViewById(R.id.sp01);
        /*Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ejecutarservicio("http://192.168.1.26:8080/Mercadoña/insertar_cliente.php");
            }
        });*/
    }
    //METODOS PARA INGRESAR PRODUCTOS
    public void Registrar(View view){
        DataBase admin = new DataBase(this ,"Mercadoña",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String Nombre = etNombre.getText().toString();
        String Apellidos = etApellidos.getText().toString();
        String Correo = etCorreo.getText().toString();
        String Correo1 = etCorreo1.getText().toString();
        String Telefono = etTelefono.getText().toString();
        String Contraseña = etContraseña.getText().toString();
        String Contraseña1 = etContraseña1.getText().toString();
        String Distritos = distritos.getSelectedItem().toString();

        // VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS
        if (!Nombre.isEmpty() && !Apellidos.isEmpty() && !Correo.isEmpty() && !Correo1.isEmpty() && !Telefono.isEmpty() && !Contraseña.isEmpty() && !Contraseña1.isEmpty()){
            ContentValues registro = new ContentValues();
            // LLENA LOS DATOS EN LA TABLA
            registro.put("Nombre",Nombre);
            registro.put("Apellidos",Apellidos);
            registro.put("Correo",Correo);
            registro.put("Telefono",Telefono);
            registro.put("Contraseña",Contraseña);
            registro.put("Distrito",Distritos);
            // INGRESA LOS DATOS EN LA TABLA CLIENTES
            BaseDeDatos.insert("Clientes",null,registro);
            // CIERRE DE LA BASE DE DATOS
            BaseDeDatos.close();
            // CONVIERTE TODOS LOS DATOS A VACIO CUANDO SE REGISTRA
            etNombre.setText("");
            etApellidos.setText("");
            etCorreo.setText("");
            etCorreo1.setText("");
            etTelefono.setText("");
            etContraseña.setText("");
            etContraseña1.setText("");
            // MENSAJE DE REGISTRO EXITOSO
            Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Registro.this , MercadoPrincipal.class);
            startActivity(i);
        }else
            Toast.makeText(this,"Debes llenar todos los campos",Toast.LENGTH_SHORT).show();
        }

    }


    /*private void ejecutarservicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> parametros = new HashMap<String,String>();
                parametros.put("Nombre",etNombre.getText().toString());
                parametros.put("Apellidos",etApellidos.getText().toString());
                parametros.put("Correo",etCorreo.getText().toString());
                parametros.put("Telefono",etNombre.getText().toString());
                parametros.put("Contraseña",etContraseña.getText().toString());
                parametros.put("Distrito",distritos.getSelectedItem().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    /*public void Enviar(View view){
        ejecutarservicio("http://192.168.1.26/Mercadoña/insertar_Cliente.php");
    }*/




    /*public void PrincipalMercado(View View) {
        Intent i = new Intent(Registro.this , PrincipalMercado.class);
        startActivity(i);
    }*/
    /*public void MercadoPrincipal(View View) {
        Intent i = new Intent(Registro.this , MercadoPrincipal.class);
        startActivity(i);
    }*/

