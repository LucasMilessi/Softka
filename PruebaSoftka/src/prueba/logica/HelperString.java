package prueba.logica;

import prueba.exeptions.PruebaModelException;

public class HelperString {

    public static boolean stringNoVacio(String str, String nombreParametro) {
        if (null != str && str.trim().length() > 0) {
            return true;
        }
        throw new PruebaModelException(String.format("El parametro [%s] esta vacío", nombreParametro));
    }

}
