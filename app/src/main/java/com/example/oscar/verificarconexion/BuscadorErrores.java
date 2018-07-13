package com.example.oscar.verificarconexion;

import android.support.v4.app.Fragment;


public class BuscadorErrores extends Fragment {
    private String titulo;
    private String descripcion;
    private String solucion;
    private int imgError;
    public Error error;

    //METODO PARA OBTENER LOS DETALLES DEL ERROR
    public Error obtenerCodigo(int codigoError) {
        error = new Error();
        switch (codigoError) {

            //ERRORES PRESeNTADOS EN LA APP
            case 0:
                titulo = "Sin Conexión";
                descripcion = "Parece que no hay conexión a Internet";
                solucion = "- Compruebe que el Wifi o el acceso a los datos móviles estén habilitados.\n"+"- Intente otra vez";
                imgError = R.drawable.ic_error_sin_internet;
                break;

            case 1:
                titulo = "Campos vacios";
                descripcion = "Falta información";
                solucion = "- Por favor, complete todos los campos.";
                imgError = R.drawable.ic_error_campo_vacio;
                break;

            case 2:
                titulo = "Acceso Denegado";
                descripcion = "No se encontro el usuario";
                solucion = "- Por favor, verifique su usuario y contraseña.\n"+"- Solicite sus credenciales de acceso a su vendedor.";
                imgError = R.drawable.ic_error_acceso_denegado;
                break;

            case 4:
                titulo = "Limite de Cantidad";
                descripcion = "No se puede exceder la cantidad de artículos disponible";
                solucion = "- Ingrese una cantidad valida.";
                imgError = R.drawable.ic_error_general;
                break;

            case 5:
                titulo = "Sin Detalles";
                descripcion = "No se pueden mostrar los detalles";
                solucion = "- El articulo no cuenta con más información.";
                imgError = R.drawable.ic_error_sin_detalles;
                break;

            case 6:
                titulo = "Sin Coincidencias ";
                descripcion = "La clave del cliente no es valida";
                solucion = "- Por favor verifique que la información sea correcta.";
                imgError = R.drawable.ic_error_general;
                break;

            case 7:
                titulo = "Error Inesperado";
                descripcion = "No se pudo realizar la venta";
                solucion = "- Por favor inténtelo nuevamente.\n"+ "- Si el problema persiste, contacte a soporte técnico";
                imgError = R.drawable.ic_error_general;
                break;

            case 8:
                titulo = "Falta Información";
                descripcion = "Cantidad No ingresada";
                solucion = "- Seleccione el articulo nuevamente\n"+"- Por favor ingrese una cantidad";
                imgError = R.drawable.ic_error_precio_menor;
                break;

            case 9:
                titulo = "Precio no Autorizado";
                descripcion = "El precio no puede ser menoral sugerifo";
                solucion = "- Por favor ingrese una cantidad mayo para este articulo";
                imgError = R.drawable.ic_error_general;
                break;
            //Cuando la lista esta vacia evitar que se cierre la app
            case 10:
                titulo = "Sin Articulos";
                descripcion = "No se pudieron cargar los articulos";
                solucion = "- Por favor tire hacia abajo para actualizar.\n"+"- Pruebe entrando y saliendo del catalogo.\n"+"- Puede ser que los articulos esten agotados\n"+"Si el error persiste contate a soporte tecnico y proporcione codigo de error.";
                imgError = R.drawable.ic_error_sin_detalles;
                break;

            //NO HAY RESULTADOS EN LA BUSQUEDA
            case 11:
                titulo   = "No se Encontraron Resultados";
                descripcion = "No se encontraron coincidencias en la busqueda";
                solucion = "- Verifique posibles errores ortográficos. \n"+"- Puede ser que el articulo que busca este hagotado.";
                imgError = R.drawable.ic_error_sin_resultado;
                break;

            case 12:
                titulo   = "No se Puede Completar la Acción";
                descripcion = "No hay articulos suficientes.";
                imgError = R.drawable.ic_error_sin_resultado;
                break;

            case 13:
                titulo   = "La Informacion No es Correcta";
                descripcion = "Alguno de los datos solicitados no es correcto\n";
                solucion = "- Verificar los datos.";
                imgError = R.drawable.ic_error_general;
                break;

            case 14:
                titulo = "Sin Cambios";
                descripcion ="Los datos coinciden con los almacenados";
                solucion ="- Verifique que los datos ingresados sean correctos.\n";
                imgError = R.drawable.ic_error_general;
                break;

            case 15:
                titulo = "El Cliente ya Existe";
                descripcion = "Se encontro un cliente con los datos ingresadps";
                solucion = "- Verifique que los datos ingresados sean correctos.";
                imgError = R.drawable.ic_error_general;
                break;

            case 17:
                titulo = "La ciudad ya Existe";
                descripcion = "Se encontro una ciudad con los datos ingresados";
                solucion = "- Verifique que los datos sean correctos.";
                imgError = R.drawable.ic_error_general;
                break;


            //ERRORES DE CONSULTAS
            case 400:
                titulo = "Solicitud Incorrecta";
                descripcion = "Sintaxis incorrecta";
                solucion = "- El servidor web no puede procesar la solicitud.\n"+"- Por favor, contacte a soporte técnico.\n"+"- Proporcione el código de error.";
                imgError = R.drawable.ic_error_sintaxis_incorrecta;
                break;

            case 403:
                titulo = "Denegado";
                descripcion = "El servidor no sido capaz de entender la petición del cliente";
                solucion = "- Verifique los permisos de acceso al servidor.\n"+"- Por favor, contacte a soporte técnico.\n"+"- Proporcione el código de error.";
                imgError = R.drawable.ic_error_acceso_denegado;
                break;

            case 404:
                titulo = "Sin Resultado";
                descripcion = "El servidor no encuentra nada en la ubicación solicitada";
                solucion = "- Verifique la URL\n"+"- Por favor, contacte a soporte técnico.\n"+"- Proporcione el código de error.";
                imgError = R.drawable.ic_error_sin_resultado;
                break;

            case 408:
                titulo = "Tiempo de respuesta expirado";
                descripcion = "La solicitud del cliente no se llevó a cabo dentro del plazo de tiempo";
                solucion = "Por favor intente otra vez.\n";
                imgError = R.drawable.ic_error_tiempo_agotado;
                break;

            case 410:
                titulo = "No se encontro el archivo";
                descripcion = "El recurso solicitado ya no se encuentra disponible";
                solucion = "Por favor, contacte a soporte técnico.";
                imgError = R.drawable.ic_error_archivo_no_encontrado;
                break;

            case 500:
                titulo = "Error Interno del Servido";
                descripcion = "El servidor encuentra una condición inesperada que le impide cumplir la solicitud que realizó";
                solucion = "Por favor intentelo mas tarde.";
                imgError = R.drawable.ic_error_general;
                break;

            case 502:
                titulo = "Error de Comunicación";
                descripcion = "El protocolo de comunicacion es diferente";
                solucion = "- Por favor vuelva a intentarlo.\n"+"- Si el problema persiste contacte a soporte técnico.\n"+"- Proporcione el código de error.";
                imgError = R.drawable.ic_error_general;
                break;

            default:
                titulo = "¡Ups!,Parece que algo salio mal";
                descripcion = "Error Desconocido";
                solucion = "Por favor, contacte a soporte tecnico.\n"+"- Proporcione el codigo de error";
                imgError = R.drawable.ic_error_desconocido;
                break;
        }
        error.setTitulo(titulo);
        error.setDescripcion(descripcion);
        error.setSolucion(solucion);
        error.setIconoError(imgError);

        return error;

    }

    public Error EstadoRed(int codigoError) {
        error = new Error();
        switch (codigoError) {

        }

        return error;
    }

}
