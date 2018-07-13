package com.example.oscar.verificarconexion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView iconoError;
    private TextView tituloError;
    private TextView descripcionError;
    private TextView solucionError;
    private TextView codigoError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconoError = (ImageView) findViewById(R.id.imgIconoError);
        tituloError = (TextView) findViewById(R.id.txtvTituloError);
        descripcionError = (TextView) findViewById(R.id.txtvDescripcionError);
        solucionError = (TextView) findViewById(R.id.txtvPosibleSolucion);
        codigoError = (TextView) findViewById(R.id.txtvCodigoError);


      registerReceiver(new VerificarConexion(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


   /*     ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if () {
            // Si hay conexión a Internet

            tituloError.setText("Estas Nectado");
            iconoError.setImageResource(R.drawable.ic_conectado);

        } else {
            // No hay conexión a Internet}

            tituloError.setText("Sin Conexion");
            iconoError.setImageResource(R.drawable.ic_wifi_apagado);
        }*/
    }
}
