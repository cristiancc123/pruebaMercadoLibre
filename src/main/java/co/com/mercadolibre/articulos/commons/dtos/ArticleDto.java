package co.com.mercadolibre.articulos.commons.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;


/**
 * Clase que define un articulo
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDto implements Serializable {

    ///////////////////////////////////////////////
    //               ATRIBUTOS                   //
    ///////////////////////////////////////////////

    private static final long serialVersionUID = 715145862883281623L;

    /** id del articulo */
    private String id;

    /** Titulo del articulo */
    private String title;

    /** Url del articulo */
    private String url;

    /** url de la imagen del articulo */
    private String imageUrl;

}
