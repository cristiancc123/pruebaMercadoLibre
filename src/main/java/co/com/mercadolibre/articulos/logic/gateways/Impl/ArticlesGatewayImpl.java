package co.com.mercadolibre.articulos.logic.gateways.Impl;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import co.com.mercadolibre.articulos.controllers.IArticlesController;
import co.com.mercadolibre.articulos.logic.gateways.IArticlesGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticlesGatewayImpl implements IArticlesGateway {

    ///////////////////////////////////////////////
    //               ATRIBUTOS                   //
    ///////////////////////////////////////////////

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spaceflight.url}")
    private String urlSpaceflight;


    ///////////////////////////////////////////////
    //                MÉTODOS                    //
    ///////////////////////////////////////////////

    @Override
    public List<ArticleDto> getArticlesApiSpaceflight() {
        ResponseEntity<List<ArticleDto>> response = restTemplate.exchange(urlSpaceflight, HttpMethod.GET, null, new ParameterizedTypeReference<List<ArticleDto>>() {});
        List<ArticleDto> articlesList = response.getBody();
        return articlesList;
    }
}
