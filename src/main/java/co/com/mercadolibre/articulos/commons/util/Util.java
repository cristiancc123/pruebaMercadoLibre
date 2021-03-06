package co.com.mercadolibre.articulos.commons.util;

import java.io.*;
import java.util.*;

/** Clase que permite realizar acciones utiles y que son generales para el proyecto */
public class Util {

    /**
     * Metodo que permite paginar una lista
     * @param c representa a la lista,
     * @param pageSize tamanio de la pagina
     * @return returna una lista agrupada por pagina
     */
    public static <T> List<List<T>> getPages(Collection<T> c, Integer pageSize) {
        if (c == null)
            return Collections.emptyList();
        List<T> list = new ArrayList<T>(c);
        if (pageSize == null || pageSize <= 0 || pageSize > list.size())
            pageSize = list.size();
        int numPages = (int) Math.ceil((double)list.size() / (double)pageSize);
        List<List<T>> pages = new ArrayList<List<T>>(numPages);
        for (int pageNum = 0; pageNum < numPages;)
            pages.add(list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size())));
        return pages;
    }

}
