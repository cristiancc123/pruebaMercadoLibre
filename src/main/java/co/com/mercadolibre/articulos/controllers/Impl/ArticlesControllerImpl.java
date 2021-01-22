package co.com.mercadolibre.articulos.controllers.Impl;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import co.com.mercadolibre.articulos.commons.util.Util;
import co.com.mercadolibre.articulos.controllers.IArticlesController;
import co.com.mercadolibre.articulos.logic.services.IArticlesServices;
import co.com.mercadolibre.articulos.logic.services.Impl.ArticleServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.ExtensionInstallationException;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v2/articles")
public class ArticlesControllerImpl implements IArticlesController {


    ///////////////////////////////////////////////
    //               ATRIBUTOS                   //
    ///////////////////////////////////////////////

    @Autowired
    private IArticlesServices articleServices;

    ///////////////////////////////////////////////
    //                MÉTODOS                    //
    ///////////////////////////////////////////////

    @Autowired
    private CacheManager cacheManager;

    @Override
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
