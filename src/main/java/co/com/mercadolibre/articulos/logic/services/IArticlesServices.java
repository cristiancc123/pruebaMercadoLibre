package co.com.mercadolibre.articulos.logic.services;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import co.com.mercadolibre.articulos.commons.dtos.ArticlePagesDto;

import java.util.List;

/** Interfaz correspondiente a la logica de negocio para la gestion de articulos */
public interface IArticlesServices {

    /** Metodo que permite obtener y paginar el listado de articulos
     * @param pageSize tamaño de elementos por pagina
     * @param page numero de la pagina a devolver
     * @return listado de articulos
     */
    public ArticlePagesDto getArticlesFromApi(int pageSize, int page);

}
