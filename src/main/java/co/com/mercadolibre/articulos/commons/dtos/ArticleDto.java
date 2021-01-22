package co.com.mercadolibre.articulos.commons.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDto implements Serializable {

    ///////////////////////////////////////////////
    //               ATRIBUTOS                   //
    ///////////////////////////////////////////////

    private static final long serialVersionUID = 715145862883281623L;

    private String title;

    private String url;

    private String imageUrl;

}
