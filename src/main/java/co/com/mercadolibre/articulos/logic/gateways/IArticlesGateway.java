package co.com.mercadolibre.articulos.logic.gateways;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/** Interfaz correspondiente a la puerta de enlace para los articulos */
public interface IArticlesGateway {

    /**
     * Metodo que permite consumir un servicio web rest para obtener los articulos
     * @return listado de articulos obtenidos por el api
     */
    public List<ArticleDto> getArticlesApiSpaceflight();

}
