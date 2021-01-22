package co.com.mercadolibre.articulos.logic.services.Impl;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import co.com.mercadolibre.articulos.logic.gateways.Impl.ArticlesGatewayImpl;
import co.com.mercadolibre.articulos.logic.services.IArticlesServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleServicesImpl implements IArticlesServices {

    ///////////////////////////////////////////////
    //               ATRIBUTOS                   //
    ///////////////////////////////////////////////

    @Autowired
    private ArticlesGatewayImpl articlesGateway;


    ///////////////////////////////////////////////
    //                MÉTODOS                    //
    ///////////////////////////////////////////////

    @Override
    public List<ArticleDto> getArticlesFromApi() {
        return articlesGateway.getArticlesApiSpaceflight();
    }

}
