package co.com.mercadolibre.articulos.logic.gateways.Impl;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import co.com.mercadolibre.articulos.commons.util.Util;
import co.com.mercadolibre.articulos.controllers.IArticlesController;
import co.com.mercadolibre.articulos.logic.gateways.IArticlesGateway;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Cacheable(value = "articles", key = "#root.method.name")
    public List<ArticleDto> getArticlesApiSpaceflight() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(urlSpaceflight)
                .queryParam("_limit", 500);
        ResponseEntity<List<ArticleDto>> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<ArticleDto>>() {});
        List<ArticleDto> articlesList = response.getBody();
        return articlesList;
    }

}
