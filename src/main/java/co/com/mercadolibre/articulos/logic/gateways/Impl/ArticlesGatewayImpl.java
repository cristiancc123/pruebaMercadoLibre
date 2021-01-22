package co.com.mercadolibre.articulos.logic.gateways.Impl;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import co.com.mercadolibre.articulos.logic.gateways.IArticlesGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/** Clase que sirve como puerta de enlace para comunicarse con sistemas externos */
@Slf4j
@RequiredArgsConstructor
@Service
public class ArticlesGatewayImpl implements IArticlesGateway {

    ///////////////////////////////////////////////
    //               ATRIBUTOS                   //
    ///////////////////////////////////////////////

    /** Propiedad utilizada para el consumo de servicios Rest */
    @Autowired
    private RestTemplate restTemplate;

    /** Propiedad que contiene la url del api externo de articulos */
    @Value("${spaceflight.url}")
    private String urlSpaceflight;

    /** Propiedad que indica el limite total de elementos a obtener del servicio externo */
    @Value("${spaceflight.limit}")
    private String limit;

    ///////////////////////////////////////////////
    //                MÉTODOS                    //
    ///////////////////////////////////////////////

    /**
     * Metodo que permite consumir un servicio web rest para obtener los articulos
     * @return listado de articulos obtenidos por el api
     */
    @Override
    @Cacheable(cacheNames = "articlesCache", key = "#root.method.name")
    public List<ArticleDto> getArticlesApiSpaceflight() {
        //Se contruye la url con el parametro
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(urlSpaceflight)
                .queryParam("_limit", limit);
        //Se consume el servicio web
        ResponseEntity<List<ArticleDto>> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<ArticleDto>>() {});
        List<ArticleDto> articlesList = response.getBody();
        return articlesList;
    }

}
