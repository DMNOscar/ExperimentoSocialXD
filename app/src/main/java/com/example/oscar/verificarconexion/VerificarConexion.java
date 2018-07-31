package com.example.oscar.verificarconexion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/*
 * Created by Oscar on 13/07/2018.
 */

/*
* BroadcastReceiver No ayuda adetectar cambios GLOBALES... esta diseñado para enviarnotificacions por ejemplo cuando llga un mensaje
* o cuando la bateria esta baja.
* */
public class VerificarConexion  extends BroadcastReceiver{

    private static final String LOG_TAG = "CambioEstadoRed";
    private boolean conectado = false;

    BuscadorErrores obtenerError = new BuscadorErrores();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(LOG_TAG, "Recibió una notificación sobre el estado de la red");

     //  estadoConexionInternet(context);

    }

    private boolean estadoConexionInternet(Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {

            //NetworkInfo nos devuelve  la informacion del estado de red
            NetworkInfo[] info = connectivity.getAllNetworkInfo();

            if (info != null) {
                //Recorremos el array
                for (int i = 0; i < info.length; i++) {
                    //Si encuentra  que se desconecta
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        //Si esta desconectado mando el mensaje de error.
                        if (!conectado) {
                            obtenerError.obtenerCodigo(1);
                            Log.v(LOG_TAG, "¡Ahora estás conectado a Internet!");
                            Log.e("wifi","Internet disponible a través del receptor Broadcast");
                            conectado = true;
                        }
                        return true;
                    }
                }
            }
        }
        Log.v(LOG_TAG, "¡No estás conectado a internet!");
        Log.e("wifi","Internet NO disponible a través del receptor de difusión");
        conectado = false;
        return false;
    }



}