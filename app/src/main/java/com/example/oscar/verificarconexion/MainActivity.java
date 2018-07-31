package com.example.oscar.verificarconexion;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private ImageView iconoError;
    private TextView tituloError;
    private TextView descripcionError;
    private TextView solucionError;
    private TextView codigoError;
    private static final int REQUEST_CODE = 1;
    private static String PERMISOS[] = {Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.ACCESS_WIFI_STATE};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializacion();
        registerReceiver(new VerificarConexion2(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private void inicializacion() {
        iconoError = (ImageView) findViewById(R.id.imgIconoError);
        tituloError = (TextView) findViewById(R.id.txtvTituloError);
        descripcionError = (TextView) findViewById(R.id.txtvDescripcionError);
        solucionError = (TextView) findViewById(R.id.txtvPosibleSolucion);
        codigoError = (TextView) findViewById(R.id.txtvCodigoError);
    }


    public class VerificarConexion2 extends BroadcastReceiver {

        private static final String LOG_TAG = "Notificacion: ";
        private boolean conectado = false;

        BuscadorErrores obtenerError = new BuscadorErrores();

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v(LOG_TAG, "Recibió una notificación sobre el estado de la red");
            String action = intent.getAction();
            Toast.makeText(context, "Cambio de estado: " + action, Toast.LENGTH_SHORT).show();
            estadoConexionInternet(context);

        }

        private boolean estadoConexionInternet(Context context) {

            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {

                //NetworkInfo nos devuelve  la informacion del estado de red
                NetworkInfo[] info = connectivity.getAllNetworkInfo();
                NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
                if (info != null) {

                    //Recorremos el array
                    for (int i = 0; i < info.length; i++) {
                        //Si encuentra  que se desconecta
                        if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                            //Si esta desconectado mando el mensaje de error.
                            if (!conectado) {

                                obtenerError.obtenerCodigo(1);
                                //     Log.v(LOG_TAG, "¡Ahora estás conectado a Internet!");
                                //     Log.e("Red", "Internet disponible a través del receptor Broadcast");
                               // ComprobarAccesoInternet();
                                String tipo = "";
                                if (networkInfo.getType() == 0) {
                                    tipo = "Datos Moviles";
                                } else {
                                    tipo = "Red wifi";
                                }

                                /*Asigancion de mensaje de Conexion*/

                                iconoError.setImageResource(R.drawable.ic_conectado);
                                tituloError.setText("Ahora estas Conectado");
                                solucionError.setText("Conectado a traves de " + tipo);
                                codigoError.setText("1");
                              
                         /*    if (ComprobarAccesoInternet(MainActivity.this)) {

                                    descripcionError.setText("Con acceso internet");
                                } else {
                                    descripcionError.setText("Sin acceso internet");
                                }*/
                                conectado = true;
                            }
                            return true;
                        }
                    }
                }
            }

            iconoError.setImageResource(R.drawable.ic_error_sin_internet);
            tituloError.setText("Estas desconectado");
            descripcionError.setText("Conexion a internet perdida");
            solucionError.setText("El wifi esta apagado");
            codigoError.setText("1");
            conectado = false;
            return false;
        }

    }

    public boolean ComprobarAccesoInternet() {
        try {
            HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
            urlc.setConnectTimeout(1500);
            urlc.connect();
            if (urlc.getResponseCode() == 204 && urlc.getContentLength() == 0) {
                Log.e("Cambio Red ", "Conexion Establecida");
                descripcionError.setText("Conexion Establecida");
            } else {
                descripcionError.setText("Sin Acceso a Internet");
            }
        } catch (IOException e) {
            Log.e("Cambio Red ", "Error al verificar la conexión a internet", e);
            descripcionError.setText("Error al verificar la conexión a internet");
        }

        return false;
    }

}
