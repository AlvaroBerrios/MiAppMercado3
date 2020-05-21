package com.example.miappmercado;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Mercadoña) {
        Mercadoña.execSQL("create table Clientes(Nombre varchar(100) primary key , Apellidos varchar(100) , Correo varchar(50) , Telefono int(9) , Contraseña varchar(50) , Distritos varchar(30))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
