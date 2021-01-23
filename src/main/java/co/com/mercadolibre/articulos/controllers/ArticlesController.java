package co.com.mercadolibre.articulos.controllers;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import co.com.mercadolibre.articulos.commons.util.Util;
import co.com.mercadolibre.articulos.logic.services.IArticlesServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Clase controladora para la gestión de los articulos */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v2/articles")
public class ArticlesController {


    ///////////////////////////////////////////////
    //               ATRIBUTOS                   //
    ///////////////////////////////////////////////

    /** Propiedad del servicio donde se encuentra la lógica de negocio */
    @Autowired
    private IArticlesServices articleServices;

    ///////////////////////////////////////////////
    //                MÉTODOS                    //
    ///////////////////////////////////////////////


    /** Metodo que permite obtener el listado de articulos
     * @param pageSize tamaño de elementos por pagina
     * @param page numero de la pagina a devolver
     * @return listado de articulos
     */
    @GetMapping
    public ResponseEntity<?> getArticles(@RequestParam int pageSize,@RequestParam int page) {
        try {
            List<ArticleDto> articlesList = articleServices.getArticlesFromApi(pageSize, page);
            return new ResponseEntity<>(articlesList, HttpStatus.OK);
        }catch (Exception ex){
            String message = "Se presento un error al consultar los articulos";
            log.error(message);
            log.error(Util.getStackTrace(ex));
            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}