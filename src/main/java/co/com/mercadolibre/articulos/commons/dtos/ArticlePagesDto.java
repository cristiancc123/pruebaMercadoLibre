package co.com.mercadolibre.articulos.commons.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que define un articulo
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticlePagesDto implements Serializable {

    ///////////////////////////////////////////////
    //               ATRIBUTOS                   //
    ///////////////////////////////////////////////

    private static final long serialVersionUID = 118832632459681623L;

    /** Listado de Articulos */
    private List<ArticleDto> articles;

    /** Cantidad de paginas */
    private Integer totalPages;
}
