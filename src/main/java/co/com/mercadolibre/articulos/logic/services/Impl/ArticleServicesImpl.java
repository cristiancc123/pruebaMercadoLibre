package co.com.mercadolibre.articulos.logic.services.Impl;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import co.com.mercadolibre.articulos.commons.dtos.ArticlePagesDto;
import co.com.mercadolibre.articulos.commons.util.Util;
import co.com.mercadolibre.articulos.logic.gateways.IArticlesGateway;
import co.com.mercadolibre.articulos.logic.gateways.Impl.ArticlesGatewayImpl;
import co.com.mercadolibre.articulos.logic.services.IArticlesServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Clase que continene toda la logica de negocio para la gestion de articulos */
@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleServicesImpl implements IArticlesServices {

    ///////////////////////////////////////////////
    //               ATRIBUTOS                   //
    ///////////////////////////////////////////////

    /** Propiedad que permite obtener los articulos de un sistema externo */
    @Autowired
    private IArticlesGateway articlesGateway;

    ///////////////////////////////////////////////
    //                MÉTODOS                    //
    ///////////////////////////////////////////////

    /** Metodo que permite obtener y paginar el listado de articulos
     * @param pageSize tamaño de elementos por pagina
     * @param page numero de la pagina a devolver
     * @return listado de articulos
     */
    @Override
    public ArticlePagesDto getArticlesFromApi(int pageSize, int page) {
        List<ArticleDto> articlesList = articlesGateway.getArticlesApiSpaceflight();
        List<List<ArticleDto>> articlesPages = Util.getPages(articlesList, pageSize);
        ArticlePagesDto articlePagesDto = new ArticlePagesDto(articlesPages.get(page),articlesPages.size());
        return articlePagesDto;
    }

}
